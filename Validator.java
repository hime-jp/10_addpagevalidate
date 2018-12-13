package validate;

public class Validator {

	private StringBuffer errors;

	public Validator() {

		errors = new StringBuffer();
	}

	/**
	 * 必須チェック
	 */
	
	//タイトルチェック
	public boolean requiredCheck(String param, String message) {

		boolean result = true;

		if(param == null  || param.length() == 0) {
			result = false;
			errors.append("■" + message + "は必須入力です。<br>");
		}

		return result;

	}

	//文字超えチェック
	public boolean maxlengthCheck(String param, String message) {

		boolean result = true;

		if(param.length() > 10) {
			result = false;
			errors.append("■" + message + "は10文字以内です。<br>");
		}

		return result;

	}

	//数値チェック
	public boolean IntegerCheck(String val, String message) {

		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException nfex) {	
			errors.append("■" + message + "は数値入力です。<br>");
			return false;
		}

	}

	//マイナスチェック
	public boolean MinusCheck(String val, String message) {

		try {
			int num = Integer.parseInt(val);

			if(num >= 0) {
				return true;
			}else {
				errors.append("■" + message + "は0以上です。<br>");
				return false;
			}

		} catch (NumberFormatException nfex) {	

		}
		return false;
	}
	
	//ボックスチェック
	public boolean BoxCheck(String[] genre, String message) {
		
		boolean result = true;

		if(genre == null  || genre.length == 0) {
			result = false;
			errors.append("■" + message + "を選択してください。<br>");
		}

		else if(genre.length > 3) {
			result = false;
			errors.append("■" + message + "の選択は3つまでです。<br>");
		}

		return result;

	}



	public String getMessage() {
		return errors.toString();
	}
}
