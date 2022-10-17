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
	String name;
	
	protected Data() throws RemoteException {
		super();
	}

	public static void main(String[] arg) throws FileNotFoundException, IOException {

		try {
			Data data = new Data(); //객체 생성
			Naming.rebind("Data", data); //data객체를 Data 이름으로 등록
			System.out.println("Data is ready !!!");
			
			studentList = new StudentList("C:\\Users\\박소정\\eclipse-workspace\\Data\\src\\Students.txt");
			courseList = new CourseList("C:\\Users\\박소정\\eclipse-workspace\\Data\\src\\Courses.txt");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //에러코드 print
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Override
	public void save (String name) throws RemoteException { //에러를 던져주는 것(throws)
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
	public boolean addStudent(String studentInfo) throws RemoteException {
		if(studentList.addStudentRecords(studentInfo)) return true;
		else return false;
	}

	@Override
	public boolean deleteStudent(String studentId) throws RemoteException {
		if(studentList.deleteStudentRecords(studentId)) return true;
		else return false;
	}
	
}
