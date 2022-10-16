import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements ServerIF {
	
	private static final long serialVersionUID = 1L;
	private static DataIF data;
	String name;
	
	protected Server() throws RemoteException {
		super();
	}

	public static void main(String[] arg) throws NotBoundException {

		try {
			Server server = new Server(); //��ü ����
			Naming.rebind("Server", server); //server��ü�� AddServer �̸����� ���
			System.out.println("RMI Server is ready !!!");
			
			data = (DataIF) Naming.lookup("Data");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //�����ڵ� print
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
	}


	@Override
	public void save (String name) throws RemoteException { //������ �����ִ� ��
		System.out.println("Server's response !!!");
		this.name = name;
	}

	@Override
	public String find() throws RemoteException {
		System.out.println("Server's response !!!");
		return name;
	}

	@Override
	public  ArrayList<Student> getAllStudentData() throws RemoteException, NullDataException {
		return data.getAllStudentData();
	}

	@Override
	public ArrayList<Course> getAllCourseData() throws RemoteException {
		return data.getAllCourseData();
	}
	
}
