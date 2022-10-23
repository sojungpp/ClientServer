package exception;

public class InvalidStudentIdException extends BaseException {

	public InvalidStudentIdException() {
		super(BaseStatus.INVALID_STUDENTID.getCodeNumber(), BaseStatus.INVALID_STUDENTID.getMessage());
	}
	
	
}