package academy.learnprogramming;

public class _107_Bear extends _107_Animal implements _107_Omnivore{
	
	@Override									// de methoden wat de Omnivore overerft moeten hier geimplementeerd worden
	public void eatPlants() {
		System.out.println("Bear eating plants");
		
	}
	
	@Override
	public void eatMeat() {
		System.out.println("Bear eating meat");
		
	}
	
	
	public int getWeight(){
		return 2000;
	}
	
	protected void printName() {
		System.out.println("Bear");
	}

}
