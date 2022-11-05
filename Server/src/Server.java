import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Server extends UnicastRemoteObject implements ServerIF {
	
	private final static Logging logger = Logging.getLogger();
	private static String userId;
	
	private static final long serialVersionUID = 1L;
	private static DataIF data;
	private static BaseException baseException;
	String name;
	
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
	public void save (String name) throws SecurityException, IOException { 
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		System.out.println("Server's response !!!");
		this.name = name;
	}

	@Override
	public String find() throws IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		System.out.println("Server's response !!!");
		return name;
	}

	@Override
	public  ArrayList<Student> getAllStudentData() throws NullDataException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		return data.getAllStudentData(userId);
	}

	@Override
	public ArrayList<Course> getAllCourseData() throws IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		return data.getAllCourseData(userId);
	}

	@Override
	public BaseStatus addStudent(String studentInfo) throws IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		if(!data.addStudent(studentInfo, userId)) return BaseStatus.FAIL_ADD_STUDENT;
		return BaseStatus.SUCCESS;
	}

	@Override
	public BaseStatus deleteStudent(String studentId) throws IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		if(!data.findStudent(studentId, userId)) return BaseStatus.INVALID_STUDENTID;
		if(!data.deleteStudent(studentId, userId)) return BaseStatus.FAIL_DELETE_STUDENT;
		return BaseStatus.SUCCESS;
	}
	
	@Override
	public BaseStatus addCourse(String courseInfo) throws IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		if(!data.addCourse(courseInfo, userId)) return BaseStatus.FAIL_ADD_COURSE;
		else return BaseStatus.SUCCESS;
	}

	@Override
	public BaseStatus deleteCourse(String courseId) throws IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		if(!data.findCourse(courseId, userId)) return BaseStatus.INVALID_COURSEID;
		if(!data.deleteCourse(courseId, userId)) return BaseStatus.FAIL_DELETE_COURSE;
		else return BaseStatus.SUCCESS;
	}

	@Override
	public boolean findStudent(String studentId) throws SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		if(data.findStudent(studentId, userId)) return true;
		return false;
	}

	@Override
	public BaseStatus registerCourse(String studentId, String courseId) throws IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		if(!data.findStudent(studentId, userId)) return BaseStatus.INVALID_STUDENTID;
		if(!data.findCourse(courseId, userId)) return BaseStatus.INVALID_COURSEID;
		ArrayList<String> registerCourse = data.findRegisterCourse(studentId);
		ArrayList<String> completedCourse = data.findCompletedCourse(studentId);
		ArrayList<String> advancedCourse = data.findAdvancedCourse(courseId);
		if(!completedCourse.isEmpty() && completedCourse.contains(courseId)) return BaseStatus.ALREADY_COMPLETEDCOURSE;
		if(!advancedCourse.isEmpty() && advancedCourse.contains(courseId) && completedCourse.isEmpty()) return BaseStatus.DO_NOT_TAKE_ADVANCEDCOURSE; 
		if(!registerCourse.isEmpty() && !advancedCourse.isEmpty()) return BaseStatus.ALREADY_REGISTRATION; 
		data.registerCourse(studentId, courseId);
		return BaseStatus.SUCCESS;
	}

	@Override
	public boolean login(String studentId, String studentPassword) throws SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		String password = data.findStudentPassword(studentId);
		if(password.equals(studentPassword)) {
			userId = studentId;
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Registration> getAllRegistrationData() throws NullDataException, SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		return data.getAllRegistrationData();
	}
	
}
