
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CourseList {
	protected ArrayList<Course> courseList;
	
	public CourseList(String courseFileName) throws FileNotFoundException, IOException {
		BufferedReader courseFile = new BufferedReader(new FileReader(courseFileName));
		this.courseList = new ArrayList<Course>();
		while (courseFile.ready()) {
			String stuInfo = courseFile.readLine();
			if (!stuInfo.equals("")) this.courseList.add(new Course(stuInfo));
		} courseFile.close();
	}

	public ArrayList<Course> getAllCourseRecords() {
		return this.courseList;
	}

	public boolean isRegisteredCourse(String sSID) {
		for (int i = 0; i < this.courseList.size(); i++) {
			Course objCourse = (Course) this.courseList.get(i);
			if (objCourse.match(sSID)) return true;
		} return false;
	}
}
