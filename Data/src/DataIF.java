import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DataIF extends Remote{
	ArrayList<Student> getAllStudentData(String userId) throws RemoteException, NullDataException, SecurityException, IOException;
	ArrayList<Course> getAllCourseData(String userId) throws RemoteException, SecurityException, IOException;
	boolean addStudent(String studentInfo, String userId) throws RemoteException, IOException;
	boolean deleteStudent(String studentId, String userId) throws RemoteException, IOException;
	void save(String name) throws RemoteException, SecurityException, IOException;
	String find() throws RemoteException, SecurityException, IOException;
	boolean deleteCourse(String courseId, String userId) throws RemoteException, IOException;
	boolean addCourse(String courseInfo, String userId) throws RemoteException, IOException;
	boolean findStudent(String studentId, String userId) throws RemoteException, SecurityException, IOException;
	boolean findCourse(String courseId, String userId) throws RemoteException, SecurityException, IOException;
	ArrayList<String> findCompletedCourse(String studentId) throws RemoteException, SecurityException, IOException;
	ArrayList<String> findAdvancedCourse(String courseId) throws RemoteException, SecurityException, IOException;
	void registerCourse(String studentId, String courseID) throws RemoteException, IOException;
	ArrayList<String> findRegisterCourse(String studentId) throws RemoteException, SecurityException, IOException;
	String findStudentPassword(String studentId) throws RemoteException, SecurityException, IOException;
	ArrayList<Registration> getAllRegistrationData() throws RemoteException, NullDataException, SecurityException, IOException;
}