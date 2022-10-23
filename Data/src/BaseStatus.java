

public enum BaseStatus {
	
	// 성공
	SUCCESS(1000,"성공했습니다."),
	
	// 학생
	INVALID_STUDENTID(2000, "존재하지 않는 학번입니다.");

	private final int codeNumber;
	private final String message;
	
	private BaseStatus(int codeNumber, String message) {
		this.codeNumber = codeNumber;
		this.message = message;
	}

	public int getCodeNumber() {
		return codeNumber;
	}

	public String getMessage() {
		return message;
	}
	
	

	
}
