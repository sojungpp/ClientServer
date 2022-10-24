
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RegisterList {
	protected ArrayList<Registration> vRegistration;
	
	public RegisterList(String sRegistrationFileName) throws FileNotFoundException, IOException {
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

	public ArrayList<Registration> getAllRegistrationRecords() throws NullDataException {
		if(this.vRegistration.size() == 0) throw null;
		return this.vRegistration;
	}
	
	public void addRegistrationRecords(String studentId, String courseId) {
		Registration registration = isRegisteredInfo(studentId);
		if(registration!=null) registration.setRegisterCoursesList(courseId);
		this.vRegistration.add(new Registration(studentId + " " + courseId));
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
