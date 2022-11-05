import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Server extends UnicastRemoteObject implements ServerIF {
	
	private final static Logging logger = Logging.getLogger();
	private static final long serialVersionUID = 1L;
	private static DataIF data;
	
	protected Server() throws RemoteException {
		super();
	}

	public static void main(String[] arg) throws NotBoundException {

		try {
			Server server = new Server(); 
			Naming.rebind("Server", server); 
			System.out.println("RMI Server is ready !!!");
			
			data = (DataIF) Naming.lookup("Data");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public BaseStatus login(String userId, String studentPassword) throws SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), null);
		if(!data.findStudent(userId, null)) return BaseStatus.INVALID_STUDENTID;
		String password = data.findStudentPassword(userId);
		if(!password.equals(studentPassword)) return BaseStatus.SUCCESS;
		else return BaseStatus.FAIL_LOGIN;
	}

	@Override
	public ArrayList<Student> getAllStudentData(String token) throws SecurityException, Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), decipherToken(token));
		return data.getAllStudentData(decipherToken(token));
	}
	
	@Override
	public BaseStatus addStudent(String studentId, String studentInfo, String token) throws SecurityException, Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), decipherToken(token));
		if(data.findStudent(studentId, decipherToken(token))) return BaseStatus.ALREADY_STUDENTID;
		if(!data.addStudent(studentInfo, decipherToken(token))) return BaseStatus.FAIL_ADD_STUDENT;
		return BaseStatus.SUCCESS;
	}
	
	@Override
	public BaseStatus deleteStudent(String studentId, String token) throws SecurityException, Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), decipherToken(token));
		if(!data.findStudent(studentId, decipherToken(token))) return BaseStatus.INVALID_STUDENTID;
		if(!data.deleteStudent(studentId, decipherToken(token))) return BaseStatus.FAIL_DELETE_STUDENT;
		return BaseStatus.SUCCESS;
	}

	@Override
	public ArrayList<Course> getAllCourseData(String token) throws SecurityException, Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), decipherToken(token));
		return data.getAllCourseData(decipherToken(token));
	}
	
	@Override
	public BaseStatus addCourse(String courseId, String courseInfo, String token) throws SecurityException, Exception {
		if(data.findCourse(courseId, decipherToken(token))) return BaseStatus.ALREADY_COURSEID;
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), decipherToken(token));
		if(!data.addCourse(courseInfo, decipherToken(token))) return BaseStatus.FAIL_ADD_COURSE;
		else return BaseStatus.SUCCESS;
	}

	@Override
	public BaseStatus deleteCourse(String courseId, String token) throws SecurityException, Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), decipherToken(token));
		if(!data.findCourse(courseId, decipherToken(token))) return BaseStatus.INVALID_COURSEID;
		if(!data.deleteCourse(courseId, decipherToken(token))) return BaseStatus.FAIL_DELETE_COURSE;
		else return BaseStatus.SUCCESS;
	}

	@Override
	public boolean findStudent(String studentId) throws SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), null);
		if(data.findStudent(studentId, null)) return true;
		return false;
	}

	@Override
	public BaseStatus registerCourse(String token, String courseId) throws SecurityException, Exception {
		String studentId = decipherToken(token);
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), studentId);
		if(!data.findStudent(studentId, decipherToken(token))) return BaseStatus.INVALID_STUDENTID;
		if(!data.findCourse(courseId, decipherToken(token))) return BaseStatus.INVALID_COURSEID;
		ArrayList<String> registerCourse = data.findRegisterCourse(decipherToken(token));
		ArrayList<String> completedCourse = data.findCompletedCourse(decipherToken(token));
		ArrayList<String> advancedCourse = data.findAdvancedCourse(courseId, decipherToken(token));
		if(!completedCourse.isEmpty() && completedCourse.contains(courseId)) return BaseStatus.ALREADY_COMPLETEDCOURSE;
		if(!advancedCourse.isEmpty() && advancedCourse.contains(courseId) && completedCourse.isEmpty()) return BaseStatus.DO_NOT_TAKE_ADVANCEDCOURSE; 
		if(!registerCourse.isEmpty() && !advancedCourse.isEmpty()) return BaseStatus.ALREADY_REGISTRATION; 
		if(!data.registerCourse(studentId, courseId)) return BaseStatus.FAIL_RIGISTER_COURSE;
		return BaseStatus.SUCCESS;
	}


	@Override
	public ArrayList<Registration> getAllRegistrationData(String token) throws Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), decipherToken(token));
		return data.getAllRegistrationData(decipherToken(token));
	}

	@Override
	public String createToken(String studentId) throws Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), studentId);
		TokenBuilder tokenBuilder = new TokenBuilder();
		return tokenBuilder.encrypt(studentId);
	}

	@Override
	public String decipherToken(String token) throws SecurityException, IOException, Exception {
		TokenBuilder tokenBuilder = new TokenBuilder();
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), tokenBuilder.decrypt(token));
		return tokenBuilder.decrypt(token);
	}
	
}
