
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentList {
	protected ArrayList<Student> vStudent;
	protected String studentFileName;
	
	
	public StudentList(String studentFileName) throws FileNotFoundException, IOException {
		this.studentFileName = studentFileName;
		BufferedReader studentFile = new BufferedReader(new FileReader(studentFileName));
		this.vStudent = new ArrayList<Student>();
		while (studentFile.ready()) {
			String stuInfo = studentFile.readLine();
			if(!stuInfo.equals("")) this.vStudent.add(new Student(stuInfo));
		} studentFile.close();
	}

	public ArrayList<Student> getAllStudentRecords() throws NullDataException {
		if(this.vStudent.size() == 0) throw null;
		return this.vStudent;
	}
	
	public boolean addStudentRecords(String studentInfo) throws IOException {
		if(this.vStudent.add(new Student(studentInfo)) && saveFile(vStudent)) return true;
		return false;
	}

	private boolean saveFile(ArrayList<Student> vStudent) throws IOException {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(studentFileName));	
			for(int i=0; i<vStudent.size(); i++) {
				String content = vStudent.get(i).savedData();
				bufferedWriter.write(content);
				bufferedWriter.newLine();
			};
			bufferedWriter.close();
			return true;
	}
	
	public boolean deleteStudentRecords(String studentId) throws IOException {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student student = (Student) this.vStudent.get(i);
			if (student.match(studentId) && this.vStudent.remove(student) && saveFile(vStudent)) return true;
		} return false;
	}

	public boolean isRegisteredStudent(String studentId) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student objStudent = (Student) this.vStudent.get(i);
			if (objStudent.match(studentId)) return true;
		} return false;
	}

	public boolean findStudent(String studentId) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student student = (Student) this.vStudent.get(i);
			if (student.match(studentId)) return true;
		} return false;
	}
	
	public String findPassword(String studentId) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student student = (Student) this.vStudent.get(i);
			if (student.match(studentId)) return student.getPassword();
		} return null;
	}

	public ArrayList<String> findCompletedCourse(String studentId) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student student = (Student) this.vStudent.get(i);
			if (student.match(studentId)) return student.getCompletedCourse();
		} return null;
	}

}
