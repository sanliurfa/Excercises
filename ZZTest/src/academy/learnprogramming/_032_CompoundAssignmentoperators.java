package academy.learnprogramming;

public class _032_CompoundAssignmentoperators {

	public static void main(String[] args) {
		int x = 2;
		int z = 3;
		
		x = x * z;	//
		x *= z; 	// shorter compound assignment x = x * z
		
		System.out.println("x= "+ x);
		
		// Je kan niet en inialitiseren en gebruik maken van de compound assignemt tegelijk 
		
		// int a *= z --> dit werkt dus niet
		
		// twee verschillende typen
		long a = 10;
		int b = 4;
		
		//b = b * a; --> dit werkt niet omdat naar een long gevraagd word

		b = (int) (b*a);
		b *= a; // short for of b = (int) (b*a);
		
		System.out.println("b= "+ b);
		
		//Exam questions
		long c = 4;
		long d = (c = 2);
				
		System.out.println("c= "+ c + " d= " + d);
		
		//nog een voorbeeld
		
		long e = 3;
		long f = 2;
		long h = 1;
		
		long i = e + 3 * (f = 3) - (h -= 2);
		// 3 + 3 * 3 - (h -= 2);
		// h = h - 2  --> h = 1 - 2 = -1
		// 3 + 3 * 3 - -1
		// 3 + 9 + 1
		// 13
				
		System.out.println("e= "+ e);
		System.out.println("f= "+ f);
		System.out.println("h= "+ h);
		System.out.println("i= "+ i);

	}

}
