package academy.learnprogramming;


class Dog{
	
	private String color;
	
	public Dog(String color) {		// een constructor want het heeft geen return-type en naam is gelijk aan de class
		System.out.println("constructor");
		this.color = color;			// this refereert naar de class variabele color.
	}								
	
//	public dog() {}								// dit is geen constructor omdat het niet hetzelfde naam heeft als de class, dit zal niet compileren
//	public void dog() {}						// dit zal compileren maar is geen constructor maar een methode omdat het een return-type void heeft.
	
	
	public void printColor() {
		System.out.println("color= " + this.color);
	}
	
	
}

class Cat{
	private String color;
	private int height;
	private int length;
	
	public Cat (int length, int theHeight) {
		length = this.length;					// EXAMEN slippertje!!! dit zal compileren maar is geen goede opdracht omdat je de methode variabele lenth gelijk stelt
												// aan de class varabele wat nog geen waarde heeft
		this.length = length;					// Dit is goed, wanneer de variabele namen gelijk zijn.
		length = theHeight;						// Dit is correct wanneer de variabele namen niet gelijk zijn.
		color = "white";
	}
	
	public void printInfo() {
		System.out.println("Cat length= "+ length+ " height= "+ height+ " color= "+ color);
	}
}


public class _092_ClassConstructors {

	public static void main(String[] args) {
		Dog dog = new Dog("gray");
		dog.printColor();
		
		Cat cat = new Cat(10, 20);
		cat.printInfo();

	}

}
