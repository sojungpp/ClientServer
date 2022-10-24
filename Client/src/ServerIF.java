import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface ServerIF extends Remote{
	ArrayList<Student> getAllStudentData() throws RemoteException, NullDataException;
	ArrayList<Course> getAllCourseData() throws RemoteException;
	boolean addStudent(String studentInfo) throws RemoteException;
	boolean deleteStudent(String studentId) throws RemoteException;
	void save(String name) throws RemoteException;
	String find() throws RemoteException;
	boolean deleteCourse(String courseId) throws RemoteException;
	boolean addCourse(String courseInfo) throws RemoteException;
	boolean findStudent(String studentId) throws RemoteException;
	BaseStatus registerCourse(String studentId, String courseId) throws RemoteException;
}
