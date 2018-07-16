package staticintitializer;

public class StaticExample {	
	public static void main(String args[]) throws ClassNotFoundException{
		//Loading a class
		
		
		StaticInitializer.class.forName("staticintitializer.StaticInitializer");
	}
}

class StaticInitializer{
	int i;
	static int j;
	static{
		//i = 10; - compiler error. Instance variable not allowed inside static initializer
		System.out.println("Block 1");
	}
	static{
		j = 20;// This is fine
		System.out.println("Block 2");
	}
	static{
		System.out.println(j);
		System.out.println("Block 3");
		
		staticmethod();// This is fine
		//instancemethod(); - compiler error. Instance method not allowed inside static initializer
	}	
	public static void staticmethod(){
		System.out.println("Static method");
	}
	public void instancemethod(){
		System.out.println("Instance method");		
	}
}
/*
 * Output for the above program will be:
 * Block 1
 * Block 2
 * 20
 * Block 3
 * Static method
 */
