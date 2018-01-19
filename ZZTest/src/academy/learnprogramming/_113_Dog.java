package academy.learnprogramming;

public class _113_Dog extends _113_Animal implements _113_HasTail, _113_CanRun {
	public _113_Dog(int age) {
		super(age);
		System.out.println("Dog");	
	}
	
	@Override
	public int getTailLength() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	@Override									// private methoden kunnen niet overridden worden, protected en public wel.
	public void eat() {
		super.eat();
		System.out.println("Dog eating");
	}
	
	public double getAverageWeight() {			// dit doet geen aanroep om de super Methode om deze te overriden
//		return 30.0;							// bij de examen kunnen ze ook alsvolgt vragen;
		return super.getAverageWeight() + 20; 
		
//		return getAverageWeight() + 20;			// zou je hier de parent aanroep niet hebben dan roep je jezelf weer aan en dit is een 
												// oneindige loop.
	}

	@Override									// Je hoeft niet de implementatie niet hier uit te voeren. dit kan ook in de child class.
	public void run(int speed) {} ;

}
