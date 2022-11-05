import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface ServerIF extends Remote{
	ArrayList<Student> getAllStudentData() throws RemoteException, NullDataException, SecurityException, IOException;
	ArrayList<Course> getAllCourseData() throws RemoteException, IOException;
	BaseStatus addStudent(String studentInfo) throws RemoteException, IOException;
	BaseStatus deleteStudent(String studentId) throws RemoteException, IOException;
	void save(String name) throws RemoteException, SecurityException, IOException;
	String find() throws RemoteException, SecurityException, IOException;
	BaseStatus deleteCourse(String courseId) throws RemoteException, IOException;
	BaseStatus addCourse(String courseInfo) throws RemoteException, IOException;
	boolean findStudent(String studentId) throws RemoteException, SecurityException, IOException;
	BaseStatus registerCourse(String studentId, String courseId) throws RemoteException, IOException;
	boolean login(String studentId, String studentPassword) throws RemoteException, SecurityException, IOException;
	ArrayList<Registration> getAllRegistrationData() throws RemoteException, NullDataException, SecurityException, IOException;
}
