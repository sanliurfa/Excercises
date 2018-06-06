package academy.learnprogramming;

public class _111_Polymorphism {
	public static void main(String[] args) {
		_111_Huskey husky = new _111_Huskey(5);
		husky.setName("Rex");
		
		_111_Dog dog = husky;					// dit heet upcasting
												// dit is een andere referentie naar de Husky object
												// een referentie genaamd husky en de andere dog
												// nu kan je dog methoden aanroepen
		dog.printDetails();
		
		// je kan dit ook de interface refereren naar husky
		_111_HasTail hasTail = husky;
		// hierdoor kan je een aanroep doen naar getTailLength wat in de interface_111_Hastail bevindt
		System.out.println("tailLength= "+ hasTail.getTailLength());
		
		_111_CanRun canRun = husky;
		canRun.run(5);
		
		_111_Animal animal = husky;
		animal.printDetails();
		
		// DUS: Omdat _111_Husky een child is van Dog en hierdoor ook automatisch een child is van parents van Dog en gebruik kan maken van 
		// de interfaces van Dog, kan je dit upcasten.
		// Hierdoor kan je gebruik maken van de methoden die hieronder zitten.
		
		_111_Animal cat = new _111_Cat(2);
		_111_Cat myCat = (_111_Cat) cat; 		// dit wordt DownCasting genoemd
												// hier wil je myCat, wat van het _111_Cat is, gelijk stellen aan cat 
												// _111_Animal type is. hierom MOET je het casten
		
		myCat.getSpeed();
		
			// Het moet wel hirarchisch geraliteerd zijn, dus je kan niet:
			// Bear bear = (Bear)"test"; Casten want een String en Bear zijn niet hirarchisch geraliteerd
	}

}