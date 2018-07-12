package oefeningen;

public class Oefening006ArrayTest {
	public static int[] getArray() {
		return null;
	}

	public static void main(String[] args) {
		int index = 1;
		try {
			getArray()[index = 2]++; 
		} catch (Exception e) {} // empty catch 
		System.out.println("index = " + index);
	}

}

/*
 * Eerst word index = 2 uitgevoerd
 * Daarna wordt getArray() uitgevoerd dit levert een null op
 * dus null[2] dit gooit een exception wat niets uitvoerd
 * dan word er een print uitgevoerd de index = al op 2 gezet 
 * ds het print een 2
 * 
 *   
 * This means, first index = 2 will be executed, which assigns 2 to index. 
 * After that null[2] is executed, which throws a NullPointerException. But this exception is caught by the catch block, which prints nothing. 
 * So it seems like NullPointerException is not thrown but it actually is.
 * In other words, the embedded assignment of 2 to index occurs before the check for array reference produced by getArray().  
 */
