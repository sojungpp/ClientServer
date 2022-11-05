import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Data extends UnicastRemoteObject implements DataIF {
	
	private final static Logging logger = Logging.getLogger();

	private static final long serialVersionUID = 1L;
	protected static StudentList studentList;
	protected static CourseList courseList;
	protected static RegisterList registrationList;
	String name;
	
	protected Data() throws RemoteException {
		super();
	}

	public static void main(String[] arg) throws FileNotFoundException, IOException {

		try {
			Data data = new Data(); 
			Naming.rebind("Data", data); 
			System.out.println("Data is ready !!!");
			
			studentList = new StudentList("C:\\Users\\박소정\\eclipse-workspace\\Data\\src\\Students.txt");
			courseList = new CourseList("C:\\Users\\박소정\\eclipse-workspace\\Data\\src\\Courses.txt");
			registrationList = new RegisterList("C:\\Users\\박소정\\eclipse-workspace\\Data\\src\\Registrations.txt");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Override
	public boolean findStudent(String studentId, String userId) throws SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		if(studentList.findStudent(studentId)) return true;
		return false;
	}
	
	@Override
	public String findStudentPassword(String userId) throws SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), null);
		return studentList.findPassword(userId);
	}

	@Override
	public ArrayList<Student> getAllStudentData(String userId) throws NullDataException, SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		return studentList.getAllStudentRecords();
	}
	
	
	@Override
	public boolean addStudent(String studentInfo, String userId) throws IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		return studentList.addStudentRecords(studentInfo);
	}

	@Override
	public ArrayList<Course> getAllCourseData(String userId) throws SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		return courseList.getAllCourseRecords();
	}


	@Override
	public boolean deleteStudent(String studentId, String userId) throws IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		return studentList.deleteStudentRecords(studentId);
	}
	
	@Override
	public boolean findCourse(String courseId, String userId) throws SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		if(courseList.findCourse(courseId)) return true;
		return false;
	}
	
	@Override
	public boolean addCourse(String courseInfo, String userId) throws IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		if(courseList.addCourseRecords(courseInfo)) return true;
		else return false;
	}

	@Override
	public boolean deleteCourse(String courseId, String userId) throws IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		if(courseList.deleteCourseRecords(courseId)) return true;
		else return false;
	}

	@Override
	public ArrayList<String> findCompletedCourse(String userId) throws SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		return studentList.findCompletedCourse(userId);
	}

	@Override
	public ArrayList<String> findAdvancedCourse(String courseId, String userId) throws SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		return courseList.findAdvancedCourse(courseId);
	}
	
	@Override
	public ArrayList<String> findRegisterCourse(String userId) throws SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		return registrationList.findregisterCourse(userId);
	}

	@Override
	public boolean registerCourse(String userId, String courseId) throws IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		return registrationList.addRegistrationRecords(userId, courseId);
	}

	@Override
	public ArrayList<Registration> getAllRegistrationData(String userId) throws NullDataException, SecurityException, IOException {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), userId);
		return registrationList.getAllRegistrationRecords();
	}



	
}
