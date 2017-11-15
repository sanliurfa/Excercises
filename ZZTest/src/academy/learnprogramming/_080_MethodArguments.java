package academy.learnprogramming;

public class _080_MethodArguments {

	int getZero() {
		return 0;			// no arguments, returns zero of andere woord niladic argument
	}
	
	int increment(int number) {	// one argument of monadic argument
		return number++;
	}
	
	int sum(int a, int b) {		// two arguments ofwel dyadic
		return a + b;
	}
	
	int plusMinus(int a, int b, int c) {
		return a + b -c;		// three arguments of triadic
	}
	
	double average(double a, double b, double c, double d) {
		return a+ b+ c+ d / 4.0;	// four arguments, of polyadic
	}
	
//	void test {}	// does not compile, no arguments
	 
//	void test (int a; int b) {} // does not compile, parameters are with , not with ;
	
	void test(int a, int b) {} // dit is een normale methode
	
//	void test2 (int a);			// dit compileert niet omdat het een body nodig heeft.
		
	
	
	
	public static void main(String[] args) {

	}

}
