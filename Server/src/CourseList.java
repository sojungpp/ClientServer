
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CourseList {
	protected ArrayList<Course> vCourse;
	
	public CourseList(String sCourseFileName) throws FileNotFoundException, IOException {
		BufferedReader objCourseFile = new BufferedReader(new FileReader(sCourseFileName));
		this.vCourse = new ArrayList<Course>();
		while (objCourseFile.ready()) {
			String stuInfo = objCourseFile.readLine();
			if (!stuInfo.equals("")) {
				this.vCourse.add(new Course(stuInfo));
			}
		}
		objCourseFile.close();
	}

	public ArrayList<Course> getAllStudentRecords() {
		return this.vCourse;
	}

	public boolean isRegisteredStudent(String sSID) {
		for (int i = 0; i < this.vCourse.size(); i++) {
			Course objStudent = (Course) this.vCourse.get(i);
			if (objStudent.match(sSID)) {
				return true;
			}
		}
		return false;
	}
}
