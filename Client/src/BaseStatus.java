

public enum BaseStatus {
	
	// ���� �� �޴�
	SUCCESS(1000,"�����߽��ϴ�."),
	NO_EXIST_MENU(1001, "���� �޴��Դϴ�."),
	FAIL_LOGIN(1002, "�߸��� ��й�ȣ�Դϴ�."),
	
	// �л�
	INVALID_STUDENTID(2000, "�������� �ʴ� �й��Դϴ�."),
	FAIL_ADD_STUDENT(2001, "�л� ��Ͽ� �����߽��ϴ�."),
	FAIL_DELETE_STUDENT(2002, "�л� ������ �����߽��ϴ�."),
	ALREADY_STUDENTID(2003, "�̹� �����ϴ� �й��Դϴ�."),
	
	// ����
	INVALID_COURSEID(3000, "�������� �ʴ� �����Դϴ�."),
	DO_NOT_TAKE_ADVANCEDCOURSE(3001, "���̼� ������ �����ϼ���."),
	ALREADY_COMPLETEDCOURSE(3002, "�̹� ������ �����Դϴ�."),
	FAIL_ADD_COURSE(3003, "���� ��Ͽ� �����߽��ϴ�."),
	FAIL_DELETE_COURSE(3004, "���� ������ �����߽��ϴ�."),
	ALREADY_COURSEID(3005, "�̹� �����ϴ� �����Դϴ�."),
	
	// ������û
	ALREADY_REGISTRATION(4000, "�̹� ���� ��û�� �����Դϴ�."),
	FAIL_RIGISTER_COURSE(4001, "���� ��û�� �����߽��ϴ�.");

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
