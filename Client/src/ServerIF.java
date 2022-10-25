import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface ServerIF extends Remote{
	ArrayList<Student> getAllStudentData() throws RemoteException, NullDataException;
	ArrayList<Course> getAllCourseData() throws RemoteException;
	BaseStatus addStudent(String studentInfo) throws RemoteException, IOException;
	BaseStatus deleteStudent(String studentId) throws RemoteException, IOException;
	void save(String name) throws RemoteException;
	String find() throws RemoteException;
	boolean deleteCourse(String courseId) throws RemoteException;
	boolean addCourse(String courseInfo) throws RemoteException;
	boolean findStudent(String studentId) throws RemoteException;
	BaseStatus registerCourse(String studentId, String courseId) throws RemoteException;
	boolean login(String studentId, String studentPassword) throws RemoteException;
}
