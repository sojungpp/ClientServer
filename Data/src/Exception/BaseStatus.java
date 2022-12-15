

public enum BaseStatus {
	
	// 성공 및 메뉴
	SUCCESS(1000,"성공했습니다."),
	NO_EXIST_MENU(1001, "없는 메뉴입니다."),
	FAIL_LOGIN(1002, "잘못된 비밀번호입니다."),
	
	// 학생
	INVALID_STUDENTID(2000, "존재하지 않는 학번입니다."),
	FAIL_ADD_STUDENT(2001, "학생 등록에 실패했습니다."),
	FAIL_DELETE_STUDENT(2002, "학생 삭제에 실패했습니다."),
	ALREADY_STUDENTID(2003, "이미 존재하는 학번입니다."),
	
	// 과목
	INVALID_COURSEID(3000, "존재하지 않는 과목입니다."),
	DO_NOT_TAKE_ADVANCEDCOURSE(3001, "선이수 과목을 수강하세요."),
	ALREADY_COMPLETEDCOURSE(3002, "이미 수강한 과목입니다."),
	FAIL_ADD_COURSE(3003, "과목 등록에 실패했습니다."),
	FAIL_DELETE_COURSE(3004, "과목 삭제에 실패했습니다."),
	ALREADY_COURSEID(3005, "이미 존재하는 과목입니다."),
	
	// 수강신청
	ALREADY_REGISTRATION(4000, "이미 수강 신청한 과목입니다."),
	FAIL_RIGISTER_COURSE(4001, "수강 신청에 실패했습니다.");

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
