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
				showMenu();
				String userConsoleInput = inputReader.readLine().trim();
				switch(userConsoleInput) {
				case "1" :
					showData(server.getAllStudentData());
					break;
				case "2" :
					deleteStudent(server, inputReader);
					break;
				case "3" :
					addStudent(server, inputReader);
					break;
				case "4" :
					showData(server.getAllCourseData());
					break;
				case "5" :
					
					break;
				case "6" :
					
					break;
				case "7" :
					//studentId와 courseId 저장해놓는 수강신청 만들기
					//학생정보유무, 과목유무체크, 선수과목체크 등등(서버에서), exception으로 처리할지 return value로 처리할지
					break;	
				case "x":
					return;
				default:
					showEtcError();
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NullDataException e) {
			e.printStackTrace();
		}
	}

	private static void addStudent(ServerIF server, BufferedReader inputReader) throws IOException, RemoteException {
		System.out.println("-----Student Information-----");
		System.out.println("Student Id: "); String studentId = inputReader.readLine().trim();
		System.out.println("Student Name: "); String studentName = inputReader.readLine().trim();
		System.out.println("Student Department: "); String studentDepartment = inputReader.readLine().trim();
		System.out.println("Student Completed Course List: "); String completedCourses = inputReader.readLine().trim();
		
		if(server.addStudent(studentId + " " + studentName + " " + studentDepartment + " " + completedCourses)) System.out.println("SUCCESS");
		else System.out.println("FAIL");
	}

	private static void deleteStudent(ServerIF server, BufferedReader inputReader) throws RemoteException, IOException {
		System.out.print("Student Id: ");
		if(server.deleteStudent(inputReader.readLine().trim())) System.out.println("SUCCESS");
		else System.out.println("FAIL");
	}

	private static void showData(ArrayList<?> dataList) {
		String list = "";
		for(int i=0; i<dataList.size(); i++) {
			list += dataList.get(i) + "\n";
		} System.out.println(list);;
	}

	private static void showEtcError() {
		System.out.println("It does not exist ! Please try again !");
	}

	private static void showMenu() {
		System.out.println("\n *********************** MENU ***********************");
		System.out.println("1. List Students");
		System.out.println("2. Add Student");
		System.out.println("3. Delete Student");
		System.out.println("4. List Courses");
		System.out.println("5. Add Course");
		System.out.println("6. Delete Course");
		System.out.println("7. Reservation");
		System.out.println("x. Exit");
	}

}
