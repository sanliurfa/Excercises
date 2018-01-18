package academy.learnprogramming;

public class _103_Eagle extends _103_Bird {
	public int fly(int height) {
		System.out.println("Eagle is flying at "+ height + " meters.");
		return height;
	}
	
//	public void eat(int amount) {			// dit is een overloading omdat er al een methode bestaat met dezelfde naam en parameter
//											// in de parent class
//	}
	
	
//	public int eat(int amount) {			// Dit geeft een compilatie error omdat er gepoogd wordt om te overloading (hetzelfde naam 
//		return amount;						// en parameter als de parent class) ,aar heeft niet hetzelfde return type.
//	}										// Dus COMPILATIE ERROR.

}
