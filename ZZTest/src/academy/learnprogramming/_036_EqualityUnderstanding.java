package academy.learnprogramming;

public class _036_EqualityUnderstanding {

	public static void main(String[] args) {
		
		//examen voorbeelden
		StringBuilder one = new StringBuilder();
		StringBuilder two = new StringBuilder();
		StringBuilder three = one.append("Java");
		
		System.out.println(one == two);				//false
		System.out.println(one == three);			//true 
		
		
		// nog een
		String x = "Java";
		String y = "Java";
		
		System.out.println(x == y); 				//true --> omdat Java eerst in de String-pool kijkt of er al reedss een object bestaat 
													//         met een "Java", inhoud dit bestaat dus er word dan ook hier naar verwezen
		
		
		// en nog een
		String a = "Java";
		String b = " Java".trim();  
		
		System.out.println(a == b);					// Wat is de resultaat hiervan
		// 
		
													// False omdat de methode trim altijd een nieuwe String object aanmaakt 
		
		// nog een
		String c = "Java";
		String d = "Ja".trim()+ "va";
		
		System.out.println(c == d); 				// Wat is de resultaat hiervan
		
													// false
		
	}

}
