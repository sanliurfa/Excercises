/**
 * 
 */
package forloop1;

/**
 * @author ro-goki
 *
 */
/**
 * @author ro-goki
 *
 */
public class ForLooptTest1 {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
/*		
		
		int x = 0;
		for(long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
		   System.out.print(y + " ");
		}
		System.out.println();
		System.out.println(x);
		System.out.println();
	//	System.out.println(y);
	*/	
		/*
		int x = 0;
		for(long y = 0, x = 4; x < 5 && y < 10; x++, y++) { // DOES NOT COMPILE
		System.out.print(x + " ");
		}
		// Compileert niet omdat x buiten de for loop initialiseerd word en y binnen

		*/
		
		int x = 0;
		long y = 10;
		for(y = 0, x = 4; x < 5 && y < 10; x++, y++) {
		System.out.print(x + " ");
		}
		// Dit is op te lossen om beide variabele buiten de for loop te initialeseren
		
	/*	
		for(long y = 0, int x = 4; x < 5 && y<10; x++, y++) { // DOES NOT COMPILE
			System.out.print(x + " ");
			}
			// Dit compileert niet omdat het in de initialisatie verschillende types zijn. Dit mag niet binnen de for loop initialisatie block.  
		
		*/
		
		
	}

}
