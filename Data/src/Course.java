
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String courseId;
    protected String professor;
    protected String name;
    protected ArrayList<String> completedCoursesList;

    public Course(String inputString) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
    	this.courseId = stringTokenizer.nextToken();
    	this.professor = stringTokenizer.nextToken();
    	this.name = stringTokenizer.nextToken();
    	this.completedCoursesList = new ArrayList<String>();
    	while (stringTokenizer.hasMoreTokens()) this.completedCoursesList.add(stringTokenizer.nextToken());
    }
    
    public boolean match(String courseId) {
        return this.courseId.equals(courseId);
    }
    public String getName() {
        return this.professor;
    }
    public ArrayList<String> getCompletedCourses() {
        return this.completedCoursesList;
    }
    public String toString() {
        String stringReturn = this.courseId + " " + this.professor + " " + this.name;
        for (int i = 0; i < this.completedCoursesList.size(); i++) {
            stringReturn = stringReturn + " " + this.completedCoursesList.get(i).toString();
        }
        return "\n" + stringReturn;
    }
}
