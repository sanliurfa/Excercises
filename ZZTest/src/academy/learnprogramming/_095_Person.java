package academy.learnprogramming;

public class _095_Person {

	
	private String firstName;
	private String lastName;
	
	public _095_Person() {
		this("Eric", "Jonson");
	}
	
	public _095_Person(String firstName, String last) {
//		this();										// je moet niet de constractor zonder parameter oproepen want hierdoor krij je een loop
													// de standaard constructor roept de tweede constuctor aan en andersom
		this.firstName = firstName;
		this.lastName = last;
//		String firstName = "myName"; 				// Dit kan niet omdat de lokale variabele hetzelfde naam als de parameter variabele
//		String lastName = "myLastname";				// dit kan wel omdat de lokale variabel niet hetzelfde is als de parameter variabele
//		lastName = last;							// Deze lokale variabele kan je dan vullen met de parameter
//		this.lastName = last;						// Of je maakt de class variabele gelijk hieraan met de this verwijzing ernaar
		lastName = last;							// wanneer je geen lokale lastName hebt dan hoef je ook geen this ervoor te zetten
	}
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
//		this();										// this() kan je alleen aanroepen in een constructor en NIET in een methode
		this.firstName = firstName;
	}
	
	public String getFullName() {
//		return this.firstName + " " + this.lastName;	// ja kan dit ook zonder this schrijven omdat je geen lokale variabele
														// en parameter hebt.
		return firstName + " " + lastName;
	}

	public static void main(String[] args) {
		
	}

}
