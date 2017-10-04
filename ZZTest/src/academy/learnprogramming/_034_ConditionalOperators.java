package academy.learnprogramming;

public class _034_ConditionalOperators {

	public static void main(String[] args) {
		int f = 4;
		boolean g = false && (f++ < 4); // && betekent dat beide zijden true moeten zijn, maar dit de tweede expressie word alleen
										// uitgevoerd wanneer de linkerkant true is
		
		boolean h = (f-- == 4) && !g;  	// eerste statement is true want f = 4, deze wordt na de vergelijking verminderd en wordt 3
										// g = false want de tweede statement van hierboven voor wordt nooit uitgevoerd
										// de !g wordt dus true
		
		System.out.println("f= " + f); 	// 4
		System.out.println("g= " + g);	// false
		System.out.println("h= " + h);	// true
		
		//Een andere vraag
		int myInt = 3;
		int anotherInt = 4;
		boolean myBoolean = (myInt <= 3) && (anotherInt-- == 4) || (myInt++ == 4);
						   // true				true -> anotherInt = 3  || MyInt++ wordt niet uitgevoerd  
		
		System.out.println("myInt= "+ myInt); // 3
		System.out.println("anotherInt= "+ anotherInt); //3
		System.out.println("myBoolean= "+ myBoolean); // true
		
		// Nog een vraag
		boolean x = true, z = false;
		int y = 20;
		x = (y != 10) ^ (z = false);
						// (y != 10) -> true
						// (z = false)
						// antwoord is true wanneer en van beide verschillend zijn dus true
		
		System.out.println("x= "+ x); //true
		System.out.println("y= "+ y); //20
		System.out.println("z= "+ z); // false

	}

}
