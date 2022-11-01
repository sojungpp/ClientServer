import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Client {

	public static void main(String[] args) throws NotBoundException, IOException{
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

	private static void login(ServerIF server, BufferedReader inputReader) throws IOException, NullDataException {
		System.out.println("*********************** LOGIN (Exit: x) ***********************");
		System.out.println("Student Id: "); String studentId = inputReader.readLine().trim();
		if(studentId.equals("x")) System.exit(0);
		System.out.println("Student Password: "); String studentPassword = inputReader.readLine().trim();
		if(!server.findStudent(studentId)) new BaseException(BaseStatus.INVALID_STUDENTID);
		else if(server.login(studentId, studentPassword)) initialMenu(server, inputReader);
		else new BaseException(BaseStatus.FAIL_LOGIN);
	}
	
	private static void showMenu() {
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
	
	private static void initialMenu(ServerIF server, BufferedReader inputReader) throws IOException, RemoteException, NullDataException {
		while(true) {
		showMenu();
		String userConsoleInput = inputReader.readLine().trim();
		switch(userConsoleInput) {
			case "1" :
				showData(server.getAllStudentData());
				break;
			case "2" :
				addStudent(server, inputReader);
				break;
			case "3" :
				deleteStudent(server, inputReader);
				break;
			case "4" :
				showData(server.getAllCourseData());
				break;
			case "5" :
				addCourse(server, inputReader);
				break;
			case "6" :
				deleteCourse(server, inputReader);
				break;
			case "7" :
				registerCourse(server, inputReader);
				break;	
			case "8" :
				showData(server.getAllRegistrationData());
				break;
			case "x":
				System.exit(0);
			default:
				new BaseException(BaseStatus.NO_EXIST_MENU);
		}
		}
	}
	
	private static void showData(ArrayList<?> dataList) {
		System.out.println("*********************** DATA ***********************");
		String list = "";
		for(int i=0; i<dataList.size(); i++) {
			list += dataList.get(i) + "\n";
		} System.out.println(list);
	}
	
	private static void addStudent(ServerIF server, BufferedReader inputReader) throws IOException, RemoteException {
		System.out.println("*********************** Student Information ***********************");
		System.out.println("Student Id: "); String studentId = inputReader.readLine().trim();
		System.out.println("Student Password: "); String studentPassword = inputReader.readLine().trim();
		System.out.println("Student LastName: "); String lastName = inputReader.readLine().trim();
		System.out.println("Student FirstName: "); String firstName = inputReader.readLine().trim();
		System.out.println("Student Department: "); String studentDepartment = inputReader.readLine().trim();
		System.out.println("Student Completed Course List: "); String completedCourses = inputReader.readLine().trim();
		
		BaseStatus baseStatus = server.addStudent(studentId + " " + studentPassword + " " + lastName+ " " + firstName + " " + studentDepartment + " " + completedCourses);
		new BaseException(baseStatus);
	}
	
	private static void deleteStudent(ServerIF server, BufferedReader inputReader) throws RemoteException, IOException {
		System.out.print("Student Id: ");
		BaseStatus baseStatus = server.deleteStudent(inputReader.readLine().trim());
		new BaseException(baseStatus);
	}
	
	private static void addCourse(ServerIF server, BufferedReader inputReader) throws IOException, RemoteException {
		System.out.println("-----Course Information-----");
		System.out.println("Course Id: "); String courseId = inputReader.readLine().trim();
		System.out.println("Professor Name: "); String professorName = inputReader.readLine().trim();
		System.out.println("Course Name: "); String courseName = inputReader.readLine().trim();
		System.out.println("Advanced Course List: "); String advancedCourses = inputReader.readLine().trim();
		
		BaseStatus baseStatus = server.addCourse(courseId + " " + professorName + " " + courseName + " " + advancedCourses);
		new BaseException(baseStatus);
	}

	private static void deleteCourse(ServerIF server, BufferedReader inputReader) throws RemoteException, IOException {
		System.out.print("Course Id: ");
		BaseStatus baseStatus = server.deleteCourse(inputReader.readLine().trim());
		new BaseException(baseStatus);
	}
	
	private static void registerCourse(ServerIF server, BufferedReader inputReader) throws IOException, RemoteException {
		System.out.println("Student Id: "); String studentId = inputReader.readLine().trim();
		showData(server.getAllCourseData());
		System.out.println("Course Id: "); String courseId = inputReader.readLine().trim();
		BaseStatus baseStatus = server.registerCourse(studentId, courseId);
		new BaseException(baseStatus);
	}

	
}
