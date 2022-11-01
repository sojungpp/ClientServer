
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CourseList {
	protected ArrayList<Course> vCourse;
	protected String sCourseFileName;
	
	public CourseList(String sCourseFileName) throws FileNotFoundException, IOException {
		this.sCourseFileName = sCourseFileName;
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

	public ArrayList<Course> getAllCourseRecords() {
		return this.vCourse;
	}

	public boolean isRegisteredCourse(String sSID) {
		for (int i = 0; i < this.vCourse.size(); i++) {
			Course objCourse = (Course) this.vCourse.get(i);
			if (objCourse.match(sSID)) {
				return true;
			}
		}
		return false;
	}

	public boolean deleteCourseRecords(String courseId) throws IOException {
		for (int i = 0; i < this.vCourse.size(); i++) {
			Course course = (Course) this.vCourse.get(i);
			if (course.match(courseId)) {
				if(this.vCourse.remove(course) && saveFile(vCourse)) return true;
				else return false;
			}
		} return false;
	}

	public boolean addCourseRecords(String courseInfo) throws IOException {
		if(this.vCourse.add(new Course(courseInfo)) && saveFile(vCourse)) return true;
		else return false;
	}

	public boolean findCourse(String courseId) {
		for (int i = 0; i < this.vCourse.size(); i++) {
			Course course = (Course) this.vCourse.get(i);
			if (course.match(courseId)) return true;
		} return false;
	}

	public ArrayList<String> findAdvancedCourse(String courseId) {
		for (int i = 0; i < this.vCourse.size(); i++) {
			Course course = (Course) this.vCourse.get(i);
			if (course.match(courseId)) {
				return course.getAdvancedCourses();
			} 
		}
		return null;
	}
	
	private boolean saveFile(ArrayList<Course> vCourse) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(sCourseFileName));	
		for(int i=0; i<vCourse.size(); i++) {
			String content = vCourse.get(i).toString();
			bufferedWriter.write(content);
			bufferedWriter.newLine();
		};
		bufferedWriter.close();
		return true;
}
}
