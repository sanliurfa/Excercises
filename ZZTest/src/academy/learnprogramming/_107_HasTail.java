package academy.learnprogramming;

public interface _107_HasTail {
//	public static final int DEFAULT_TAIL_LENGTH = 2;	// public static final hoeft niet geschreven te worden in een interface omdat dit al automatisch
														// het geval is
	int DEFAULT_TAIL_LENGTH = 2;
	
														// Dit geldt ook voor methoden in een interface
//	public int getTailLength();							// public en abstract hoeft niet geschreven worden omdat een methode binnen een interface 
														// altijd al public en abstract, dus er is geen body.

	int getTailLength();
	
//	int getWeight() {};									// Dit zal niet compileren omdat het een body beschikt.
	
}
