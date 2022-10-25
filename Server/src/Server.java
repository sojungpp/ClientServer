import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Server extends UnicastRemoteObject implements ServerIF {
	
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
	public void save (String name) throws RemoteException { 
		System.out.println("Server's response !!!");
		this.name = name;
	}

	@Override
	public String find() throws RemoteException {
		System.out.println("Server's response !!!");
		return name;
	}

	@Override
	public  ArrayList<Student> getAllStudentData() throws RemoteException, NullDataException {
		return data.getAllStudentData();
	}

	@Override
	public ArrayList<Course> getAllCourseData() throws RemoteException {
		return data.getAllCourseData();
	}

	@Override
	public BaseStatus addStudent(String studentInfo) throws IOException {
		return data.addStudent(studentInfo);
	}

	@Override
	public BaseStatus deleteStudent(String studentId) throws IOException {
		return data.deleteStudent(studentId);
	}

	@Override
	public boolean deleteCourse(String courseId) throws RemoteException {
		if(data.deleteCourse(courseId)) return true;
		else return false;
	}

	@Override
	public boolean addCourse(String courseInfo) throws RemoteException {
		if(data.addCourse(courseInfo)) return true;
		else return false;
	}

	@Override
	public boolean findStudent(String studentId) throws RemoteException {
		if(data.findStudent(studentId)) return true;
		return false;
	}

	@Override
	public BaseStatus registerCourse(String studentId, String courseId) throws RemoteException {
		if(!data.findStudent(studentId)) return BaseStatus.INVALID_STUDENTID;
		if(!data.findCourse(courseId)) return BaseStatus.INVALID_COURSEID;
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
	public boolean login(String studentId, String studentPassword) throws RemoteException {
		String password = data.findStudentPassword(studentId);
		if(password.equals(studentPassword)) return true;
		return false;
	}
	
}
