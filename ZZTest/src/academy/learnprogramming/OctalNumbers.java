package academy.learnprogramming;

public class OctalNumbers {

	public static void main(String[] args) {
		// octal number is van 0-7 er staat hier een 0 ervoor!!
		
		int oct = 07; //7 decimal
		int firstOct = 010; //  8 decimal
		int secondOct = 022; // 18 decimal
		
		int sumOct = firstOct +  secondOct;
		System.out.println("first= "+ firstOct+ " second= " + secondOct);
		System.out.println("decimal sum= "+ sumOct + " octSum= "+ Integer.toOctalString(sumOct));
		
		// hexadecimale numbers bevatten een x (0-9) en (A-F) 16 in decimal
		
		// binary numbers bevatten een b 
		
		//Standaard word een komma getal als double opgeslagen
		
		double myDouble =  2.54;
		double myDouble2 = 2.54F;
		double anotherDouble = 2.54D; // de D hoeft niet achter geplaatst worden omdat het al een double
		double scientific = 5.000125E03; // De E03 geeft aan hoeveel plaatsen de punt naar rechts verschoven moet worden
										// Dus dit is gelijk aan 5000.125 dit compileert.
										// Soms geven ze op de examen een F in plaats van E, dat werkt dus niet!!
		double scientific2 = 5.000125E3;
		double myDouble3 = 5000.125;
		
		System.out.println("scientific= " + scientific);
		System.out.println("scientific2= " + scientific2);
		System.out.println("myDouble3= " + myDouble3);
		
		double hexPi = 0x1.91eb851eb851fp1; // p is een indicator voor een hexadecimale number met een floating point.
		
		System.out.println("hexPi= " + hexPi);
		

	}

}
