package academy.learnprogramming;

public class _101_Dog extends _101_Animal {
	public _101_Dog(int age) {
		super(age);
		System.out.println("Dog");
		
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

}
