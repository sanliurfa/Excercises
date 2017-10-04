package academy.learnprogramming;

public class QuestionExamplesString {

	public static void main(String[] args) {
		int numDogs = 4;
		String dogType = "Husky";
//		String anotherDog = numDogs + 1;	// Dit zal niet compileren omdat de uitkomst een int is en er wordt een String gevraagd.
		String anotherDog = numDogs + 1 + ""; // Dit werkt wel
		System.out.println(anotherDog + " "+ dogType);
		System.out.println(numDogs+ " "+ 1);
		
		
		// wat wordt de uitkomst van de onderstaande
		String s= "Hello";
		String t = new String(s);
		if ("Hello".equals(s)) System.out.println("one");
		if ( t==s) System.out.println("two");
		if (t.equals(s)) System.out.println("three");
		if ("Hello" == s) System.out.println("four");
		if ("Hello" == t) System.out.println("five");
		
		
		
		// Antwoord: one, three, four. s refereert naar een string object met "Hello" erin
		// t mmakt een new object hierin stopt een referent (adres) van s.
		// one vergelijkt de inhoud, dit is gelijk
		// two vergelijkt de referenties van t en s, dit is niet gelijk want s verwijst naar een "Hello" object
		// three vergelijkt de inhoud van t en s, dit is geljik
		// four vergelijkt de s referentie met een literal Hello
		// five vergelijkt de t referentie met een literal Hello, dit is niet gelijk want t refereert naar de adres s
		
		// Wat is de resultaat van de onderstaande
		String s1 = "java";
		StringBuilder s2 = new StringBuilder("java");
//		if (s1 == s2) System.out.println("1");
		if (s1.equals(s2)) System.out.println("2");
		
		
		// Dit compileert niet want je kan geen String met een StringBuilder vergelijken want het zijn twee verschillende klassen 
		// Denk bijvoorbeeld aan dat je een int niet met een String kan vergelijken. Het zijn twee verschillende klassen
		
		
		// Wat is de resultaat van de volgende code
		
		//StringBuilder b = "rumble";									// Let op; je moet voor een stringBuilder altijd een new object aanmaken!!!!
		StringBuilder b = new StringBuilder("rumble");
		b.append(4).deleteCharAt(3).delete(3, b.length()-1);			// b.length()-1 betekent tot de einde en dan - 1 , dus een na laatste
		System.out.println(b);
		
		
		//Volgende vraag: Wat is de uitkomst van het volgende, kies alle mogelijke antwoorden
		String numbers = "012345678";
		System.out.println(numbers.substring(1, 3));
		System.out.println(numbers.substring(7, 7));
		System.out.println(numbers.substring(7));
		
		// A. 12
		// B. 123
		// C. 7
		// D. 78
		// E. Een lege lijn
		// F. Een exception word gegooid
		// G. De code compileert niet
		
		
		// Antwoord: A, E, en D
		
		//Wat is de resultaat van het volgende
		int total = 0;
		StringBuilder letters = new StringBuilder("abcdefg");
		total += letters.substring(1, 2).length();
		total += letters.substring(6, 6).length();
		total += letters.substring(6, 5).length();
		System.out.println(total);
		
		// A. 1
		// B. 2
		// C. 3
		// D. 7
		// E. Een exception word gegooid
		// F. De code compileert niet
		
		// Antwoord: E. (lijn 74: eind index is kleiner dan start index)
		
		
		// Wati het resultaat (kies alle mogelijke antwoorden
		StringBuilder numbers1 =  new StringBuilder("0123456789");
		numbers1.delete(2, 8);
		numbers1.append("-").insert(2, "+");
		System.out.println(numbers1);
		
		// A. 01+89-
		// B. 012+9-
		// C. 012+-9
		// D. 0123456789
		// E. Een exception word gegooid
		// F. De code compileert niet
		
		
		//Antwoord A. 01+89-
		
		
		
		
		
		
		
		
		

	}

}
