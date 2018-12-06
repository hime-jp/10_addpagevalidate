class MinusException extends Exception{	//1
	public static void main (String[] args) {
	MinusException me = new MinusException();
		me.exMethod();
	}
	void exMethod(){
		try {
			filewrite();  
			} catch(MinusException e) {	//4
			System.out.println("正しい値を入力してください");
			}
		}

	void filewrite()throws MinusException{	//2
		String str;
		KeyIO key = new KeyIO();
		str=key.keyboardIn();
		if(Integer.parseInt(str)<0){
			throw new MinusException();	//3
		}
	}
}