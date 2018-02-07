package academy.learnprogramming;

import javax.management.RuntimeErrorException;

public class _122_CheckedVsUnchecked {

	public static void main(String[] args) {
		

	}
	
	public static void myMethod() throws Exception{
		throw new Exception("Failed to load");
	}
	
	public static void anotherMethod() {
		throw new RuntimeException("Wrong parameter");
	}

}
