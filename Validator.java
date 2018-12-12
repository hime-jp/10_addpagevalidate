package validate;

public class Validator {

	private StringBuffer errors;

	public Validator() {

		errors = new StringBuffer();
	}

	/**
	 * �K�{�`�F�b�N
	 */
	public boolean requiredCheck(String param, String message) {

		boolean result = true;

		if(param == null  || param.length() == 0) {
			result = false;
			errors.append("��" + message + "�͕K�{���͂ł��B<br>");
		}

		return result;

	}

	public boolean maxlengthCheck(String param, String message) {

		boolean result = true;

		if(param.length() > 10) {
			result = false;
			errors.append("��" + message + "��10�����ȓ��ł��B<br>");
		}

		return result;

	}

	public boolean IntegerCheck(String val, String message) {

		//        boolean result = true;

		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException nfex) {	
			errors.append("��" + message + "�͐��l���͂ł��B<br>");
			return false;
		}

	}

	public boolean MinusCheck(String val, String message) {

		//boolean result = true;

		try {
			int num = Integer.parseInt(val);

			if(num >= 0) {
				return true;
			}else {
				errors.append("��" + message + "��0�����ȏ�ł��B<br>");
				return false;
			}

		} catch (NumberFormatException nfex) {	

		}
		return false;
	}
	



	public String getMessage() {
		return errors.toString();
	}
}
