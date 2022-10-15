
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String studentId;
    protected String name;
    protected String department;
    protected ArrayList<String> completedCoursesList;

    public Student(String inputString) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString); //StringTokenizer : 문자열을 쪼개주는 클래스, 쪼개어진 문자열 = 토큰, 기본 delimiter인 공백을 기준으로 분리
    	this.studentId = stringTokenizer.nextToken(); //nextToken 다음 토큰 반환 (string)
    	this.name = stringTokenizer.nextToken();
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
        return this.name;
    }
    public ArrayList<String> getCompletedCourses() {
        return this.completedCoursesList;
    }
    public String toString() {
        String stringReturn = this.studentId + " " + this.name + " " + this.department;
        for (int i = 0; i < this.completedCoursesList.size(); i++) {
            stringReturn = stringReturn + " " + this.completedCoursesList.get(i).toString();
        }
        return "\n" + stringReturn;
    }
}
