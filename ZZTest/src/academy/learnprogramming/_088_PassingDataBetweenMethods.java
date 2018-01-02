package academy.learnprogramming;

public class _088_PassingDataBetweenMethods {

	public static void main(String[] args) {
		int number =4;
		System.out.println("Number is: " + number);
		newNumber(number);
		System.out.println("Number is: " + number);		// Wat word hier geprint?
		
		// wanneer er een metthode aangeroepen word met een parameter, dan maakt het een kopie aan van de parameter.
		// Als de waarde binnen die methode wijzigd, dan heeft dit geen invloed op de originele waarde.
		
		String name = "Jimmy";
		System.out.println("Name is "+ name);
		newName(name);
		System.out.println("Name is "+ name);
		
		StringBuilder sb = new StringBuilder();
		build(sb);
		
		System.out.println("StringBuilder sb is " + sb); // Wat print het hiet uit?
		
		
		
	}
	

	public static void newNumber(int number) {
		System.out.println("in newNumber number is "+ number);
		number = 10;
		System.out.println("in newNumber number is "+ number);
		
	}
	

	private static void newName(String name) {
		System.out.println("in newName name is "+ name);
		name = "Timmy";
		System.out.println("In newName name is "+ name);
		
	}
	
	private static void build(StringBuilder s) {
		//s = new StringBuilder();
		s.append("Tom");							// ook hier geldt dat de methode een kopie maakt, maar zowel s als sb verwijzen naar dezelfde object
													// dus wanneer wijziging plaats vind dan word zowel s al sb gewijzigd. 
													// behalve wanneer je s naar een andere nieuwe object verwijst (uitgecommtarieerd)
	}

}
