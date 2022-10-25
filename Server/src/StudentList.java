
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentList {
	protected ArrayList<Student> vStudent;
	protected String sStudentFileName;
	
	
	public StudentList(String sStudentFileName) throws FileNotFoundException, IOException {
		this.sStudentFileName = sStudentFileName;
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
		if(this.vStudent.size() == 0) throw null;
		return this.vStudent;
	}
	
	public BaseStatus addStudentRecords(String studentInfo) throws IOException {
		if(this.vStudent.add(new Student(studentInfo)) && saveFile(vStudent)) return BaseStatus.SUCCESS;;
		return BaseStatus.FAIL_ADD_STUDENT;
	}

	private boolean saveFile(ArrayList<Student> vStudent) throws IOException {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(sStudentFileName));	
			for(int i=0; i<vStudent.size(); i++) {
				String content = vStudent.get(i).savedData();
				bufferedWriter.write(content);
				bufferedWriter.newLine();
			};
			bufferedWriter.close();
			return true;
	}
	
	public BaseStatus deleteStudentRecords(String studentId) throws IOException {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student student = (Student) this.vStudent.get(i);
			if (student.match(studentId)) {
				if(this.vStudent.remove(student) && saveFile(vStudent)) return BaseStatus.SUCCESS;
				else return BaseStatus.FAIL_DELETE_STUDENT;
			}
		} return BaseStatus.INVALID_STUDENTID;
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

	public String findPassword(String studentId) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student student = (Student) this.vStudent.get(i);
			if (student.match(studentId)) {
				return student.getPassword();
			}
		}
		return null;
	}
}
