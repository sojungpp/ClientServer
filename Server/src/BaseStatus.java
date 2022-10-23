

public enum BaseStatus {
	
	// ����
	SUCCESS(1000,"�����߽��ϴ�."),
	
	// �л�
	INVALID_STUDENTID(2000, "�������� �ʴ� �й��Դϴ�.");

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
