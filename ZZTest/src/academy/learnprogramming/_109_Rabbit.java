package academy.learnprogramming;

public class _109_Rabbit extends _109_Animal implements _109_Herbivore, _109_Hop{
	public _109_Rabbit() {
//		super;							 
										
		
//		super().setAge(3);				 
										
		
		super();						 
		super.setAge(3);				
		this.setAge(3);					 
										
		setAge(3);						
	}
	
	public void printDetails() {
		System.out.println("Rabbit average jump height = "+ _109_Hop.getAverageJumpHeight());
	}									// Wanneer je een static interface methode wil aanroepen dan moet je de interface naam ervoor plaatsen
										// anders geeft het een compilatie error aan.
	
	public _109_Rabbit(int age) {
//		this(age);						 
										
		
		super(3);						
										
		
	}

}
