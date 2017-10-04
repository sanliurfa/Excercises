package academy.learnprogramming;

public class StringBuilderExample {

	public static void main(String[] args) {
		String myString = "";
		
		for (char c = 'a'; c <= 'z'; c++) {
			myString += c;
		}
		
		System.out.println(myString);
		
		//met een stringBuilder
		
		StringBuilder sb = new StringBuilder();
		for (char c = 'a'; c <= 'z'; c++)  {
			sb.append(c);
		}

		System.out.println(sb);
		
		StringBuilder builder = new StringBuilder("start");
		builder.append("-middle");
		StringBuilder anotherBuilder = builder.append("-end"); // LET OP hier krijgt anotherBuilder een referentie naar builder-object 
																//en er word end toegevoegd.
																// dus zowel builder als anotherBuilder referen naar hetzelfde object.!!!
		
		System.out.println("builder= " + builder);
		System.out.println("anotherBuilder= " + anotherBuilder);
		
		//kijken of het naar dezelfde object refereert
		System.out.println( builder == anotherBuilder);
		System.out.println(System.identityHashCode(builder));
		System.out.println(System.identityHashCode(anotherBuilder));
		
		// EXAMENVraag: wat wordt de output van de onderstaande
		
		StringBuilder a = new StringBuilder("This ");
		StringBuilder b = a.append("Java ");
		b = b.append("is").append(" so ").append("Cool");
		System.out.println("a= "+ a);
		System.out.println("b= "+ b);
		
		
		
		// antwoord: beide refereren naar hetzelfde adres en dus geeft beide "This Java is so Cool" aan.
		
		
		
		
		
		
	}

}
