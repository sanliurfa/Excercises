package academy.learnprogramming;

public class _044_ForLoop {

	public static void main(String[] args) {
		for (int i=0; i < 10 ; i++) {
			System.out.print(i + " ");  	// geen println dus resultaat wordt op een lijn geprint
		}

		//System.out.println("i= " + i);	// i wordt niet herkend omdat het alleen binnen de for loop is geinialiseerd 
		
		System.out.println(); 				// wordt gebruikt om een nieuwe lijn te krijgen 
		
		int a;
		for (a = 0; a < 10; a++) {			// a wordt buiten de loop geinialiseerd waardoor het buiten de for loop ook gebruikt worden
			System.out.print(a + " ");
		}
		
		System.out.println();				// nieuwe regel
		System.out.println("after for loop a= " + a);  	// a kan hier nog gebruikt worden omdat het buiten de for loop is geinitialiseerd
		
		int x = 0;												
		int y;		
		int z;													// it  	x	y	z
		for ( y = 0, z=0; x < 5 && y < 10;x++, y++) {			// 0	0	0	0
																// 1	1	1	0
																// 2	2	2	0
																// 3	3	3	0
																// 4	4	4	0
																// 5	5	5	0
			System.out.println("y= "+ y);
		}
		System.out.println("x= "+ x);
		System.out.println("y= "+ y);
		
		int d= 10;
		//for (int e = 0, d=0; e < 0 || d < 10; e++, d--) {} compileert niet omdat de variabele d al reeds geinialiseerd is
		
		// het is dan of je 
		// int d = 10;
		// int d = 0; schrijft
		
		// J e mag ook geen verschillende typen gebruiken
		//for (long z = 0, int d = 0; z < 10; z++, d++) {}  dit compileert dus ook niet
		
		
	}
	

}
