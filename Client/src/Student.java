
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String studentId;
	protected String studentPassword;
    protected String lastName;
    protected String firstName;
    protected String department;
    protected ArrayList<String> completedCoursesList;

    public Student(String inputString) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
    	this.studentId = stringTokenizer.nextToken();
    	this.studentPassword = stringTokenizer.nextToken();
    	this.lastName = stringTokenizer.nextToken();
    	this.firstName = stringTokenizer.nextToken();
    	this.department = stringTokenizer.nextToken();
    	this.completedCoursesList = new ArrayList<String>();
    	while (stringTokenizer.hasMoreTokens()) {
    		this.completedCoursesList.add(stringTokenizer.nextToken());
    	}
    }
    public boolean match(String studentId) {
        return this.studentId.equals(studentId);
    }
    public String getName() {
        return this.lastName+this.firstName;
    }
    public ArrayList<String> getCompletedCourse() {
        return this.completedCoursesList;
    }
	public String getPassword() {
		return this.studentPassword;
	}
    public String toString() {
        String stringReturn = this.studentId + " " + this.lastName+this.firstName + " " + this.department;
        for (int i = 0; i < this.completedCoursesList.size(); i++) {
            stringReturn = stringReturn + " " + this.completedCoursesList.get(i).toString();
        }
        return "\n" + stringReturn;
    }
    public String savedData() {
        String stringReturn = this.studentId + " " + this.studentPassword + " " + this.lastName + " " + this.firstName + " " + this.department;
        for (int i = 0; i < this.completedCoursesList.size(); i++) {
            stringReturn = stringReturn + " " + this.completedCoursesList.get(i).toString();
        }
        return "\n" + stringReturn;
    }
	
}
