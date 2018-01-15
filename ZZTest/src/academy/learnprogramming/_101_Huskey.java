package academy.learnprogramming;

public class _101_Huskey extends _101_Dog{

	public _101_Huskey(int age) {
//		this();								// this(); roept de constuctor van de huidige class aan
//		super();							// suoer(); roept de constructor van de parent op
											// de compiler maakt super(); altijd aan wanneer extends wordt gebruikt
		
		super(age);
		
		System.out.println("Huskey");
	}
	
	public void eat() {
	//	super.eat();						// eerst doet het hier een aanroep naar de parent methode eat
		System.out.println("Husky eating");
		
		super.eat();						// Nadat de eigen methode uitgevoerd is doet het een aanroep naar de parent methode eat
	}
	

}
