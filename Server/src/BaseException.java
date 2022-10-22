
public class BaseException extends Exception {
	
	final int codeNumber;
    final String message;

	public BaseException(int codeNumber, String message) {
		this.codeNumber = codeNumber;
		this.message = message;
		System.out.println("ÄÚµå : " + codeNumber + " | " + message);
	}


	
	
}
