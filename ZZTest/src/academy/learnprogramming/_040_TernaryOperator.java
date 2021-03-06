package academy.learnprogramming;

public class _040_TernaryOperator {

	public static void main(String[] args) {
		int x = 10;
		int y;
		
		if ( x > 5){
			y = 2 * x;
		} else {
			y= 4 * x;
		}
		
		// zonder accolades
		if ( x > 5)y = 2 * x;
		else y= 4 * x;
		
		System.out.println("y= "+ y);

		// hetzelfde nu met ternary
		//y = x > 5? 2 * x : 4 * x;
		// met haakjes
		y = (x > 5)? (2 * x) : (4 * x);
		System.out.println("y= "+ y);
		
		// het moet wel dezelfde type bevatten:
		System.out.println(y> 5 ? 10 : "Test");
		
		//int myInt = y < 10 ? 5 : "Test"; --> Dit zal niet werken want de resultaat is van het type sting terwijl er een int gevraagd word!!
		
		// TERNARY OPERATORS EVALUEERT ALLEEN DE EERST GELDENDE EN NIET HET VERVOLG NET ZOALS && OF || !!!
		
		int a = 1; 
		int b = 1;
		int c = a < 10 ? a++ : b++;
		// a < 10 is true dus a++ wordt uitgevoerd en b++ niet
		// a= 2
		// b = 1
		// c = 1 --> omdat a eerst wordt gebruikt en daarna de a opgehoogt word.
		
		System.out.println("a= "+ a);
		System.out.println("b= " + b);
		System.out.println("c= "+ c);
		
		// nog een voorbeeld
		
		int d = 1;
		int e = 2;
		int f = 3;
		
		if (d < 10){						// true
			f = d++ < 1 ? e++ : f++;		// d < 1 --> false dus f++, e++ wordt niet uitgevoerd --> d wordt 2 en het toekennen van f wordt eerst uitgevoerd
											// en daarna pas verhoogd dus f blijft 3 bij het printen en hierna pas verhoogd
		} else {
			f = (d + e) < 2 ? d++ : e++;	// wordt niet uitgevoerd
		}
		
		System.out.println("d= "+ d); // 2
		System.out.println("e= "+ e); // 2
		System.out.println("f= "+ f); // 3
		
		
		// ExamQuestion
		int r = 5;
		System.out.println(r > 2? x < 4 ? 10 : 8 :7);  // wat is de uitkomst
		// A. 5
		// B. 4
		// C. 10
		// D. 8
		// E. 7
		// het compileert niet vanwege lijn 66
		
		
		// Het juiste antwoord is D --> je kan het met haakjes schrijven dan wordt het overzichtelijker.
		System.out.println((r > 2) ? ((x < 4) ? 10 : 8) :7); // r , 4 -> false -> 8
		System.out.println((x>2) ? 8 : 7); // x> 2 -> true -> 8
		
		// dus de uitkomst is D.
		
		
		
		
	}

}
