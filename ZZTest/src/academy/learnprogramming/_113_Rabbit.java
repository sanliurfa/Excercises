package academy.learnprogramming;

public class _113_Rabbit extends _113_Animal implements _113_Herbivore, _113_Hop{
	public _113_Rabbit() {
//		super;							 
										
		
//		super().setAge(3);				 
										
		
		super();						 
		super.setAge(3);				
		this.setAge(3);					 
										
		setAge(3);						
	}
	
	public void printDetails() {
		System.out.println("Rabbit average jump height = "+ _113_Hop.getAverageJumpHeight());
	}									// Wanneer je een static interface methode wil aanroepen dan moet je de interface naam ervoor plaatsen
										// anders geeft het een compilatie error aan.
	
	public _113_Rabbit(int age) {
//		this(age);						 
										
		
		super(3);						
										
		
	}

}
