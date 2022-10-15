
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentList {
	protected ArrayList<Student> studentList;
	
	public StudentList(String studentFileName) throws FileNotFoundException, IOException {
		BufferedReader objStudentFile = new BufferedReader(new FileReader(studentFileName));
		this.studentList = new ArrayList<Student>();
		while (objStudentFile.ready()) {
			String stuInfo = objStudentFile.readLine();
			if (!stuInfo.equals("")) this.studentList.add(new Student(stuInfo));
		}
		objStudentFile.close();
	}

	public ArrayList<Student> getAllStudentRecords() {
		return this.studentList;
	}

	public boolean isRegisteredStudent(String sSID) {
		for (int i = 0; i < this.studentList.size(); i++) {
			Student objStudent = (Student) this.studentList.get(i);
			if (objStudent.match(sSID)) return true;
		}
		return false;
	}
}
