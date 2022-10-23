
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exception.NullDataException;

public class StudentList {
	protected ArrayList<Student> vStudent;
	
	public StudentList(String sStudentFileName) throws FileNotFoundException, IOException {
		BufferedReader objStudentFile = new BufferedReader(new FileReader(sStudentFileName));
		this.vStudent = new ArrayList<Student>();
		while (objStudentFile.ready()) {
			String stuInfo = objStudentFile.readLine();
			if (!stuInfo.equals("")) {
				this.vStudent.add(new Student(stuInfo));
			}
		}
		objStudentFile.close();
	}

	public ArrayList<Student> getAllStudentRecords() throws NullDataException {
		if(this.vStudent.size() == 0) throw new NullDataException("~~~~~~~~~~ Student data is null ~~~~~~~~~~");
		return this.vStudent;
	}
	
	//이유 넣기 + exception처리해서 boolean을 void로 -> 과제
	public boolean addStudentRecords(String studentInfo) {
		if(this.vStudent.add(new Student(studentInfo))) return true;
		else return false;
	}
	
	public boolean deleteStudentRecords(String studentId) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student student = (Student) this.vStudent.get(i);
			if (student.match(studentId)) {
				if(this.vStudent.remove(student)) return true;
				else return false;
			}
		} return false;
	}

	public boolean isRegisteredStudent(String sSID) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student objStudent = (Student) this.vStudent.get(i);
			if (objStudent.match(sSID)) {
				return true;
			}
		}
		return false;
	}

	public boolean findStudent(String studentId) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student student = (Student) this.vStudent.get(i);
			if (student.match(studentId)) return true;
		} return false;
	}

	public ArrayList<String> findCompletedCourse(String studentId) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student student = (Student) this.vStudent.get(i);
			if (student.match(studentId)) {
				return student.getCompletedCourse();
			}
		}
		return null;
	}
}
