import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DataIF extends Remote{
	ArrayList<Student> getAllStudentData() throws RemoteException, NullDataException;
	ArrayList<Course> getAllCourseData() throws RemoteException;
	boolean addStudent(String studentInfo) throws RemoteException, IOException;
	boolean deleteStudent(String studentId) throws RemoteException, IOException;
	void save(String name) throws RemoteException;
	String find() throws RemoteException;
	boolean deleteCourse(String courseId) throws RemoteException, IOException;
	boolean addCourse(String courseInfo) throws RemoteException, IOException;
	boolean findStudent(String studentId) throws RemoteException;
	boolean findCourse(String courseId) throws RemoteException;
	ArrayList<String> findCompletedCourse(String studentId) throws RemoteException;
	ArrayList<String> findAdvancedCourse(String courseId) throws RemoteException;
	void registerCourse(String studentId, String courseID) throws RemoteException, IOException;
	ArrayList<String> findRegisterCourse(String studentId) throws RemoteException;
	String findStudentPassword(String studentId) throws RemoteException;
	ArrayList<Registration> getAllRegistrationData() throws RemoteException, NullDataException;
}