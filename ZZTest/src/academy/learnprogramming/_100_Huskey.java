package academy.learnprogramming;

public class _100_Huskey extends _100_Dog{

	public _100_Huskey(int age) {
//		this();								// this(); roept de constuctor van de huidige class aan
//		super();							// suoer(); roept de constructor van de parent op
											// de compiler maakt super(); altijd aan wanneer extends wordt gebruikt
		
		super(age);
		
		System.out.println("Huskey");
	}
}
