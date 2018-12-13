package validate;

public class Validator {

	private StringBuffer errors;

	public Validator() {

		errors = new StringBuffer();
	}

	/**
	 * �K�{�`�F�b�N
	 */
	
	//�^�C�g���`�F�b�N
	public boolean requiredCheck(String param, String message) {

		boolean result = true;

		if(param == null  || param.length() == 0) {
			result = false;
			errors.append("��" + message + "�͕K�{���͂ł��B<br>");
		}

		return result;

	}

	//���������`�F�b�N
	public boolean maxlengthCheck(String param, String message) {

		boolean result = true;

		if(param.length() > 10) {
			result = false;
			errors.append("��" + message + "��10�����ȓ��ł��B<br>");
		}

		return result;

	}

	//���l�`�F�b�N
	public boolean IntegerCheck(String val, String message) {

		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException nfex) {	
			errors.append("��" + message + "�͐��l���͂ł��B<br>");
			return false;
		}

	}

	//�}�C�i�X�`�F�b�N
	public boolean MinusCheck(String val, String message) {

		try {
			int num = Integer.parseInt(val);

			if(num >= 0) {
				return true;
			}else {
				errors.append("��" + message + "��0�ȏ�ł��B<br>");
				return false;
			}

		} catch (NumberFormatException nfex) {	

		}
		return false;
	}
	
	//�{�b�N�X�`�F�b�N
	public boolean BoxCheck(String[] genre, String message) {
		
		boolean result = true;

		if(genre == null  || genre.length == 0) {
			result = false;
			errors.append("��" + message + "��I�����Ă��������B<br>");
		}

		else if(genre.length > 3) {
			result = false;
			errors.append("��" + message + "�̑I����3�܂łł��B<br>");
		}

		return result;

	}



	public String getMessage() {
		return errors.toString();
	}
}
