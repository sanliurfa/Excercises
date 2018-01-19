package academy.learnprogramming;

public class _111_Huskey extends _111_Dog{

	public _111_Huskey(int age) {
//		this();								
//		super();							
											
		
		super(age);
		
		System.out.println("Huskey");
	}
	
	public void eat() {
	//	super.eat();						
		System.out.println("Husky eating");
		
		super.eat();						
	}
	
	@Override								// Wanneer getTailLength niet in de parent van Huskey geimplenteerd word dan moet het verplicht
	public int getTailLength() {			// in de Child class geimplementeerd worden. Mocht het wel in de parent geimplementeerd zijn
		// TODO Auto-generated method stub	// dan hoeft het niet in de child geimplementeerd worden.
		return 20;
	}
	
	
	public void run(int speed) {
	System.out.println("Husky running at speed= " + speed);
		
	}
	

}
