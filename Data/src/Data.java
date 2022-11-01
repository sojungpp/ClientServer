import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Data extends UnicastRemoteObject implements DataIF {

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
	public void save(String name) throws RemoteException { 
		System.out.println("Server's response !!!");
		this.name = name;
	}

	@Override
	public String find() throws RemoteException {
		System.out.println("Server's response !!!");
		return name;
	}

	@Override
	public ArrayList<Student> getAllStudentData() throws RemoteException, NullDataException {
		return studentList.getAllStudentRecords();
	}

	@Override
	public ArrayList<Course> getAllCourseData() throws RemoteException {
		return courseList.getAllCourseRecords();
	}

	@Override
	public boolean addStudent(String studentInfo) throws IOException {
		return studentList.addStudentRecords(studentInfo);
	}

	@Override
	public boolean deleteStudent(String studentId) throws IOException {
		return studentList.deleteStudentRecords(studentId);
	}

	@Override
	public boolean deleteCourse(String courseId) throws IOException {
		if(courseList.deleteCourseRecords(courseId)) return true;
		else return false;
	}

	@Override
	public boolean addCourse(String courseInfo) throws IOException {
		if(courseList.addCourseRecords(courseInfo)) return true;
		else return false;
	}

	@Override
	public boolean findStudent(String studentId) throws RemoteException {
		if(studentList.findStudent(studentId)) return true;
		return false;
	}

	@Override
	public boolean findCourse(String courseId) throws RemoteException {
		if(courseList.findCourse(courseId)) return true;
		return false;
	}

	@Override
	public ArrayList<String> findCompletedCourse(String studentId) throws RemoteException {
		return studentList.findCompletedCourse(studentId);
	}

	@Override
	public ArrayList<String> findAdvancedCourse(String courseId) throws RemoteException {
		return courseList.findAdvancedCourse(courseId);
	}

	@Override
	public void registerCourse(String studentId, String courseId) throws IOException {
		registrationList.addRegistrationRecords(studentId, courseId);
	}

	@Override
	public ArrayList<String> findRegisterCourse(String studentId) {
		return registrationList.findregisterCourse(studentId);
	}

	@Override
	public String findStudentPassword(String studentId) throws RemoteException {
		return studentList.findPassword(studentId);
	}

	@Override
	public ArrayList<Registration> getAllRegistrationData() throws RemoteException, NullDataException {
		return registrationList.getAllRegistrationRecords();
	}



	
}
