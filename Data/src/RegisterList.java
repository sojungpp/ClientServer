
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exception.NullDataException;

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

	public void addRegistrationRecords(String registrationInfo) {
		this.vRegistration.add(new Registration(registrationInfo));
		System.out.println("수강신청되었습니다.");
	}
	
}
