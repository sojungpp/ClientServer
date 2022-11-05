import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface ServerIF extends Remote{
	ArrayList<Student> getAllStudentData(String token) throws RemoteException, NullDataException, SecurityException, IOException, Exception;
	ArrayList<Course> getAllCourseData(String token) throws RemoteException, IOException, SecurityException, Exception;
	BaseStatus addStudent(String studentId, String studentInfo, String token) throws RemoteException, IOException, SecurityException, Exception;
	BaseStatus deleteStudent(String studentId, String token) throws RemoteException, IOException, SecurityException, Exception;
	BaseStatus deleteCourse(String courseId, String token) throws RemoteException, IOException, SecurityException, Exception;
	BaseStatus addCourse(String courseInfo, String token) throws RemoteException, IOException, SecurityException, Exception;
	boolean findStudent(String studentId) throws RemoteException, SecurityException, IOException;
	BaseStatus registerCourse(String token, String courseId) throws RemoteException, IOException, SecurityException, Exception;
	BaseStatus login(String studentId, String studentPassword) throws RemoteException, IOException;
	ArrayList<Registration> getAllRegistrationData(String token) throws RemoteException, NullDataException, SecurityException, IOException, Exception;
	String createToken(String studentId) throws SecurityException, IOException, Exception;
	String decipherToken(String studentId) throws SecurityException, IOException, Exception;
}
