
public class BaseException extends Exception {
	private static final long serialVersionUID = 1L;
	final int codeNumber;
    final String message;

	public BaseException(BaseStatus baseStatus) {
		this.codeNumber = baseStatus.getCodeNumber();
		this.message = baseStatus.getMessage();
		System.out.println("ÄÚµå : " + codeNumber + " | " + message);
	}
}
