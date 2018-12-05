package validate;

public class Validator {
	
	StringBuffer errors;

    public Validator() {
    	
        errors = new StringBuffer();
    }

    /**
     * 必須チェック
     */
    public boolean requiredCheck(String param, String message) {
    	
        boolean result = true;

        if(param == null) {
            result = false;
            errors.append("■" + message + "は必須入力です。<br>");
        }
        
        return result;
        
    	}
    
    public boolean minlengthCheck(String param, String message) {
    	
        boolean result = true;

        if(param.length() > 10) {
            result = false;
            errors.append("■" + message + "は10文字以内です。<br>");
        }
        
        return result;
        
    	}
    
    public boolean IntegerCheck(String param, String message) {
    	
        boolean result = true;

		int num = Integer.parseInt();
        if(param == null) {
            result = false;
            errors.append("■" + message + "は数値入力です。<br>");
        }
        
        return result;
        
    	}
    
    	public String getMessage() {
    		return errors.toString();
    }
}