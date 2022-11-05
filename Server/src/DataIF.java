import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DataIF extends Remote{
	ArrayList<Student> getAllStudentData(String userId) throws RemoteException, NullDataException, SecurityException, IOException;
	ArrayList<Course> getAllCourseData(String userId) throws RemoteException, SecurityException, IOException;
	boolean addStudent(String studentInfo, String userId) throws RemoteException, IOException;
	boolean deleteStudent(String studentId, String userId) throws RemoteException, IOException;
	boolean deleteCourse(String courseId, String userId) throws RemoteException, IOException;
	boolean addCourse(String courseInfo, String userId) throws RemoteException, IOException;
	boolean findStudent(String studentId, String userId) throws RemoteException, SecurityException, IOException;
	boolean findCourse(String courseId, String userId) throws RemoteException, SecurityException, IOException;
	ArrayList<String> findCompletedCourse(String userId) throws RemoteException, SecurityException, IOException;
	ArrayList<String> findAdvancedCourse(String courseId, String userId) throws RemoteException, SecurityException, IOException;
	boolean registerCourse(String studentId, String courseID) throws RemoteException, IOException;
	ArrayList<String> findRegisterCourse(String userId) throws RemoteException, SecurityException, IOException;
	String findStudentPassword(String userId) throws RemoteException, SecurityException, IOException;
	ArrayList<Registration> getAllRegistrationData(String string) throws RemoteException, NullDataException, SecurityException, IOException;
}