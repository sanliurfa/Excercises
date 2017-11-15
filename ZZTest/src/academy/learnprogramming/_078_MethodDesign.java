package academy.learnprogramming;

public class _078_MethodDesign {
	
	public void jump() {};
	
//	void public jump2() {}; // Compile error omdat de return type altijd voor de class naam moet staan.
	
	void jump3() {}; // heeft een default acces modifier, of wel private package access modifier 

	public final void jump4() {}; // met een optionele final
	
	public static final void jump5() {};
	
	public final static void jump6() {}; // het geeft niet of final of static volgorde
	
	static public void jump7() {};
	
	static final public void jump8() {};
	
	
	
	public static void main(String[] args) {
		
		

	}

}
