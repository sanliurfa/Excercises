package academy.learnprogramming;

public class _084_Static {
	private String name = "Static";
	
	public static void one() {};
	public static void two() {};
	
	public static void three() {
		one();						// Een static methode kan een ander static methode aanroepen
		two();
//		four();						// een static methode kan NIET een niet static methode aanroepen
		
//		System.out.println(name);	// een static methode kan NIET een niet static methode aanroepen  
		
	}
	
	public void four() {			// Een niet static methode kan een static methodes en niet static fields aanroepen
		one();
		two();
		three();
		System.out.println(name);
	}
	
	
	public static void main(String[] args) {
	
		_084_Static.one();			// je kan een static methode aanroepen met een Class.
		one();						// je kan ook een static methode direct aanroepen omdat het static is
		two();
		three();
//		four();						// maar je kan niet een NIET static methode direct aanroepen
		
		// Wat je moet doen om een niet static methode aan te roepen is een instantie van die class maken:
		
		_084_Static myInstance = new _084_Static();
		myInstance.four();			// nu kan je deze wel aanroepen
		
		// Een ander manier is wat directer;
		new _084_Static().four();
		
		
		
		
	}

}
