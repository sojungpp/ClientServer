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
					showData(server.getAllCourseData());
					break;
				case "x":
					return;
				default:
					showEtcError();
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			}
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
		System.out.println("2. List courses");
		System.out.println("x. Exit");
	}

}
