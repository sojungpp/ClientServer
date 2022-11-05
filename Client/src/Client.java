import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Client {
	
	private final static Logging logger = Logging.getLogger();

	public static void main(String[] args) throws SecurityException, Exception{
		ServerIF server;
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			server = (ServerIF)Naming.lookup("Server");
			while(true) {
				login(server, inputReader);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NullDataException e) {
			e.printStackTrace();
		}
	}

	private static void login(ServerIF server, BufferedReader inputReader) throws SecurityException, Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), null);
		System.out.println("*********************** LOGIN (Exit: x) ***********************");
		System.out.println("Student Id: "); String studentId = inputReader.readLine().trim();
		if(studentId.equals("x")) System.exit(0);
		System.out.println("Student Password: "); String studentPassword = inputReader.readLine().trim(); 
		BaseStatus baseStatus = server.login(studentId, studentPassword);
		if(baseStatus==BaseStatus.SUCCESS) {
			String token = server.createToken(studentId);
			initialMenu(server, inputReader, token);
		}
		else new BaseException(baseStatus);
	}

	

	private static void showMenu(ServerIF server, String token) throws Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), server.decipherToken(token));
		System.out.println("\n *********************** MENU ***********************");
		System.out.println("1. List Students");
		System.out.println("2. Add Student");
		System.out.println("3. Delete Student");
		System.out.println("4. List Courses");
		System.out.println("5. Add Course");
		System.out.println("6. Delete Course");
		System.out.println("7. registerCourse");
		System.out.println("8. List Registration");
		System.out.println("x. Exit");
	}
	
	private static void initialMenu(ServerIF server, BufferedReader inputReader, String token) throws SecurityException, Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), server.decipherToken(token));
		while(true) {
		showMenu(server, token);
		String userConsoleInput = inputReader.readLine().trim();
		switch(userConsoleInput) {
			case "1" :
				showData(server.getAllStudentData(token), server, token);
				break;
			case "2" :
				addStudent(server, inputReader, token);
				break;
			case "3" :
				deleteStudent(server, inputReader, token);
				break;
			case "4" :
				showData(server.getAllCourseData(token), server, token);
				break;
			case "5" :
				addCourse(server, inputReader, token);
				break;
			case "6" :
				deleteCourse(server, inputReader, token);
				break;
			case "7" :
				registerCourse(server, inputReader, token);
				break;	
			case "8" :
				showData(server.getAllRegistrationData(token), server, token);
				break;
			case "x":
				return;
			default:
				new BaseException(BaseStatus.NO_EXIST_MENU);
		}
		}
	}
	
	private static void showData(ArrayList<?> dataList, ServerIF server, String token) throws Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), server.decipherToken(token));
		System.out.println("*********************** DATA ***********************");
		String list = "";
		for(int i=0; i<dataList.size(); i++) {
			list += dataList.get(i) + "\n";
		} System.out.println(list);
	}
	
	private static void addStudent(ServerIF server, BufferedReader inputReader, String token) throws SecurityException, Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), server.decipherToken(token));
		System.out.println("*********************** Student Information ***********************");
		System.out.println("Student Id: "); String studentId = inputReader.readLine().trim();
		System.out.println("Student Password: "); String studentPassword = inputReader.readLine().trim();
		System.out.println("Student LastName: "); String lastName = inputReader.readLine().trim();
		System.out.println("Student FirstName: "); String firstName = inputReader.readLine().trim();
		System.out.println("Student Department: "); String studentDepartment = inputReader.readLine().trim();
		System.out.println("Student Completed Course List: "); String completedCourses = inputReader.readLine().trim();
		
		BaseStatus baseStatus = server.addStudent(studentId, studentId + " " + studentPassword + " " + lastName+ " " + firstName + " " + studentDepartment + " " + completedCourses, token);
		new BaseException(baseStatus);
	}
	
	private static void deleteStudent(ServerIF server, BufferedReader inputReader, String token) throws SecurityException, Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), server.decipherToken(token));
		System.out.print("Student Id: ");
		BaseStatus baseStatus = server.deleteStudent(inputReader.readLine().trim(), token);
		new BaseException(baseStatus);
	}
	
	private static void addCourse(ServerIF server, BufferedReader inputReader, String token) throws SecurityException, Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), server.decipherToken(token));
		System.out.println("-----Course Information-----");
		System.out.println("Course Id: "); String courseId = inputReader.readLine().trim();
		System.out.println("Professor Name: "); String professorName = inputReader.readLine().trim();
		System.out.println("Course Name: "); String courseName = inputReader.readLine().trim();
		System.out.println("Advanced Course List: "); String advancedCourses = inputReader.readLine().trim();
		
		BaseStatus baseStatus = server.addCourse(courseId, courseId + " " + professorName + " " + courseName + " " + advancedCourses, token);
		new BaseException(baseStatus);
	}

	private static void deleteCourse(ServerIF server, BufferedReader inputReader, String token) throws SecurityException, Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), server.decipherToken(token));
		System.out.print("Course Id: ");
		BaseStatus baseStatus = server.deleteCourse(inputReader.readLine().trim(), token);
		new BaseException(baseStatus);
	}
	
	private static void registerCourse(ServerIF server, BufferedReader inputReader, String token) throws SecurityException, Exception {
		logger.log(new Object() {}.getClass().getEnclosingMethod().getName(), server.decipherToken(token));
		showData(server.getAllCourseData(token), server, token);
		System.out.println("Course Id: "); String courseId = inputReader.readLine().trim();
		BaseStatus baseStatus = server.registerCourse(token, courseId);
		new BaseException(baseStatus);
	}

	
}
