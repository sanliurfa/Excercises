package academy.learnprogramming;

public class _090_OverloadingMethods {
	
	public void walk(int miles) {
		
	}
	
	public void walk(short feet) {					// overload; heeft een andere argument type
		
	}
	
	public boolean walk() {							// overload; heeft een andere return type
		return false;
	}
	
	void walk(int miles, short feet) {}
	public void walk (float miles) {}				// geeft een foutmelding omdat zowel de methode naam en de atgumenten  
//	public int walk (float miles) {}				// dubbel voorkomen, al is de argumentennamm verschillend
	
	public void walk(int [] lengths) {}
//	public void walk(int... vars) {}			// Dit zal niet werken omdat al en array aanwezig is met hetzelfde type


	
	public static void run(int length) {}
	public static void run(Integer length) {}
	public static void run(double kilometer) {}
	
	public static void jump(String s) {
		System.out.println("String");
	}
	
	public static void jump(Object o) {
		System.out.println("Object");
	}
	
	public static int sum(int a, int b) {
		System.out.println("int sum");
		return a+b;
	}
	
	public static long sum(long a, long b) {
		System.out.println("long sum");
		return a+b;
	}
	
	public static Integer sum(Integer a, Integer b) {
		System.out.println("Integer sum");
		return a+b;
	}
	
	public static int sum(int... numbers) {
		System.out.println("sum varargs");
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		run(9L);								// Dit zal werken al bestaat er geen methode met de type long. Deze wordt namelijk gepromoveerd naar Double
		jump(25);								// er bestaat een methode met een Object type dus dit copileerd
		jump("test");
		sum(1,2);					// welke methode wordt hier aangeroepen, en wat gebeurd er wanneer je die met commentarieerd?
	}
	

}
