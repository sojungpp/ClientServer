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
	public boolean addStudent(String studentInfo) throws RemoteException {
		if(data.addStudent(studentInfo)) return true;
		else return false;
	}

	@Override
	public boolean deleteStudent(String studentId) throws RemoteException {
		if(data.deleteStudent(studentId)) return true;
		else return false;
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
	public ArrayList<String> registerCourse(String studentId, String courseId) throws RemoteException {
		if(!data.findStudent(studentId)) new InvalidStudentIdException(); //학생유무체크
		if(!data.findCourse(courseId)) System.out.println("존재하지 않는 과목입니다."); //과목유무체크
		ArrayList<String> completedCourse = data.findCompletedCourse(studentId);
		ArrayList<String> advancedCourse = data.findAdvancedCourse(courseId);
		for(int i=0; i<advancedCourse.size(); i++) {
			if(!completedCourse.contains(advancedCourse.get(i))) System.out.println("선이수 과목을 수강하세요."); //선이수과목체크
		}
		data.registerCourse(studentId + " " + courseId);
		return completedCourse;

	}
	
}
