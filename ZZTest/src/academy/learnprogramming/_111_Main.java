package academy.learnprogramming;

public class _111_Main {

	public static void main(String[] args) {

		_108_Rabbit rabbit = new _108_Rabbit();
		rabbit.eatPlants();
		
		_108_Cat cat = new _108_Cat();
		int speed = cat.getSpeed();
		System.out.println("cat speed is "+ speed);	// speed wordt 15 omdat het overridden wordt door de class Cat
													// Wanneer dit niet zou worden overridden door Cat dan krijgt het van de interface Run
													// Wanneer dit ook niet overridden zou worden dan krijgt het de waarde van Walk welke de parent
													// is van Run.
		

	}

}
