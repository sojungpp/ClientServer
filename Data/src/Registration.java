
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Registration implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String studentId;
    protected ArrayList<String> registerCoursesList;

    public Registration(String inputString) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString); 
    	this.studentId = stringTokenizer.nextToken(); 
    	this.registerCoursesList = new ArrayList<String>();
    	while (stringTokenizer.hasMoreTokens()) {
    		this.registerCoursesList.add(stringTokenizer.nextToken());
    	}
    }
    public boolean match(String studentId) {
        return this.studentId.equals(studentId);
    }

    public String toString() {
        String stringReturn = this.studentId + " ";
        for (int i = 0; i < this.registerCoursesList.size(); i++) {
            stringReturn = stringReturn + " " + this.registerCoursesList.get(i).toString();
        }
        return "\n" + stringReturn;
    }

    public ArrayList<String> getRegisterCourse() {
        return this.registerCoursesList;
    }
	public ArrayList<String> getRegisterCoursesList() {
		return registerCoursesList;
	}
	public void setRegisterCoursesList(String id) {
		this.registerCoursesList.add(id);
	}
    
	
    
}
