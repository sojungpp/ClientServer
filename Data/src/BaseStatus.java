

public enum BaseStatus {
	
	// 성공 및 메뉴
	SUCCESS(1000,"성공했습니다."),
	NO_EXIST_MENU(1001, "없는 메뉴입니다."),
	
	// 학생
	INVALID_STUDENTID(2000, "존재하지 않는 학번입니다."),
	
	// 과목
	INVALID_COURSEID(3000, "존재하지 않는 과목입니다."),
	DO_NOT_TAKE_ADVANCEDCOURSE(3001, "선이수 과목을 수강하세요."),
	ALREADY_COMPLETEDCOURSE(3002, "이미 수강한 과목입니다."),
	
	// 수강신청
	ALREADY_REGISTRATION(4000, "이미 수강 신청한 과목입니다.");

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
