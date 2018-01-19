package academy.learnprogramming;

public class _113_Main {

	public static void main(String[] args) {

		_113_Rabbit rabbit = new _113_Rabbit();
		rabbit.eatPlants();
		
		_113_Cat cat = new _113_Cat(2);
		int speed = cat.getSpeed();
		System.out.println("cat speed is "+ speed);	// speed wordt 15 omdat het overridden wordt door de class Cat
													// Wanneer dit niet zou worden overridden door Cat dan krijgt het van de interface Run
													// Wanneer dit ook niet overridden zou worden dan krijgt het de waarde van Walk welke de parent
													// is van Run.
		

	}

}
