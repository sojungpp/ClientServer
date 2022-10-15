import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) throws NotBoundException, IOException{
		ServerIF server;
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				server = (ServerIF)Naming.lookup("Server");
				showMenu();
				String userConsoleInput = inputReader.readLine().trim();
				if (userConsoleInput.equals("1")) showData(server, "student");
				else if (userConsoleInput.equals("2")) showData(server, "course");
				else if (userConsoleInput.equals("3")) exitProgram();
				else if (userConsoleInput.isBlank()) showBlankError();
				else showEtcError();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	private static void showCourseData(ServerIF server) throws RemoteException {
		System.out.println("Server's answer: " + server.getAllCourseData());
	}

	private static void showEtcError() {
		System.out.println("It does not exist ! Please try again !");
	}

	private static void showBlankError() {
		System.out.println("No value entered. Please try again !");
	}

	private static void showStudentData(ServerIF server) throws RemoteException {
		System.out.println("Server's answer: " + server.getAllStudentData());
	}

	private static void showData(ServerIF server, String string) throws RemoteException {
		if(string.equals("student")) System.out.println(server.getAllStudentData());
		else System.out.println(server.getAllCourseData());
	}

	private static void exitProgram() {
		System.out.println("~ Bye ~");
		System.exit(0);
	}

	private static void showMenu() {
		System.out.println("\n *********************** MENU ***********************");
		System.out.println("1. List Students");
		System.out.println("2. List courses");
		System.out.println("3. Exit");
	}

}
