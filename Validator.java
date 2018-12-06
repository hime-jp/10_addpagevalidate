package validate;

public class Validator {

	StringBuffer errors;

	public Validator() {

		errors = new StringBuffer();
	}

	/**
	 * �K�{�`�F�b�N
	 */
	public boolean requiredCheck(String param, String message) {

		boolean result = true;

		if(param == null) {
			result = false;
			errors.append("��" + message + "�͕K�{���͂ł��B<br>");
		}

		return result;

	}

	public boolean minlengthCheck(String param, String message) {

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






	public String getMessage() {
		return errors.toString();
	}
}
