package academy.learnprogramming;

public class _099_Huskey extends _099_Dog{

	public _099_Huskey(int age) {
//		this();								// this(); roept de constuctor van de huidige class aan
//		super();							// suoer(); roept de constructor van de parent op
											// de compiler maakt super(); altijd aan wanneer extends wordt gebruikt
		
		super(age);
		
		System.out.println("Huskey");
	}
}
