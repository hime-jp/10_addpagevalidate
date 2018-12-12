package validate;

public class Validator {

	private StringBuffer errors;

	public Validator() {

		errors = new StringBuffer();
	}

	/**
	 * 必須チェック
	 */
	public boolean requiredCheck(String param, String message) {

		boolean result = true;

		if(param == null  || param.length() == 0) {
			result = false;
			errors.append("■" + message + "は必須入力です。<br>");
		}

		return result;

	}

	public boolean maxlengthCheck(String param, String message) {

		boolean result = true;

		if(param.length() > 10) {
			result = false;
			errors.append("■" + message + "は10文字以内です。<br>");
		}

		return result;

	}

	public boolean IntegerCheck(String val, String message) {

		//        boolean result = true;

		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException nfex) {	
			errors.append("■" + message + "は数値入力です。<br>");
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
				errors.append("■" + message + "は0文字以上です。<br>");
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
