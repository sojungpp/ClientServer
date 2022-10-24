

public enum BaseStatus {
	
	// ���� �� �޴�
	SUCCESS(1000,"�����߽��ϴ�."),
	NO_EXIST_MENU(1001, "���� �޴��Դϴ�."),
	
	// �л�
	INVALID_STUDENTID(2000, "�������� �ʴ� �й��Դϴ�."),
	
	// ����
	INVALID_COURSEID(3000, "�������� �ʴ� �����Դϴ�."),
	DO_NOT_TAKE_ADVANCEDCOURSE(3001, "���̼� ������ �����ϼ���."),
	ALREADY_COMPLETEDCOURSE(3002, "�̹� ������ �����Դϴ�."),
	
	// ������û
	ALREADY_REGISTRATION(4000, "�̹� ���� ��û�� �����Դϴ�.");

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
