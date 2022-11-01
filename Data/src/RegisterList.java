
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RegisterList {
	protected ArrayList<Registration> vRegistration;
	protected String sRegistrationFileName;
	
	public RegisterList(String sRegistrationFileName) throws FileNotFoundException, IOException {
		this.sRegistrationFileName = sRegistrationFileName;
		BufferedReader objStudentFile = new BufferedReader(new FileReader(sRegistrationFileName));
		this.vRegistration = new ArrayList<Registration>();
		while (objStudentFile.ready()) {
			String registrationInfo = objStudentFile.readLine();
			if (!registrationInfo.equals("")) {
				this.vRegistration.add(new Registration(registrationInfo));
			}
		}
		objStudentFile.close();
	}
	
	private boolean saveFile(ArrayList<Registration> vRegistration) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(sRegistrationFileName));	
		for(int i=0; i<vRegistration.size(); i++) {
			String content = vRegistration.get(i).toString();
			bufferedWriter.write(content);
			bufferedWriter.newLine();
		};
		bufferedWriter.close();
		return true;
}

	public ArrayList<Registration> getAllRegistrationRecords() throws NullDataException {
		if(this.vRegistration.size() == 0) throw null;
		return this.vRegistration;
	}
	
	public boolean addRegistrationRecords(String studentId, String courseId) throws IOException {
		if(this.vRegistration.add(new Registration(studentId + " " + courseId)) && saveFile(vRegistration)) return true;
		return false;
	}
	
	public boolean deleteRegistrationRecords(String studentId, String courseId) throws IOException {
		for (int i = 0; i < this.vRegistration.size(); i++) {
			Registration registration = (Registration) this.vRegistration.get(i);
			if (registration.match(studentId) && registration.getRegisterCoursesList().equals(courseId)) {
				if(this.vRegistration.remove(registration.getRegisterCoursesList().equals(courseId)) && saveFile(vRegistration)) return true;
			}
		} return false;
	}
	
	public Registration isRegisteredInfo(String sSID) {
		for (int i = 0; i < this.vRegistration.size(); i++) {
			Registration registration = (Registration) this.vRegistration.get(i);
			if (registration.match(sSID)) {
				return registration;
			}
		}
		return null;
	}
	
	public ArrayList<String> findregisterCourse(String studentId) {
		for (int i = 0; i < this.vRegistration.size(); i++) {
			Registration registration = (Registration) this.vRegistration.get(i);
			if (registration.match(studentId)) {
				return registration.getRegisterCourse();
			}
		}
		return null;
	}
}
