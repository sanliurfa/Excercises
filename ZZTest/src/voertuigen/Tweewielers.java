package voertuigen;

import motor.Motor;

public class Tweewielers {

	public static void main(String[] args) {
	
		Motor motor1 = new Motor();
		System.out.println("motor1 werkt niet");
		
		Tweewielers motor2 = new Motor();
		System.out.println("motor 3 werkt niet, want Type Tweewielers weet niets van de protected variabele banden wat in de child is gedefineerd");
		
		Tweewielers motor3 = new Tweewielers();
		System.out.println("motor 3 werkt niet, want Type Tweewielers weet niets van de protected variabele banden wat in de child is gedefineerd");
		
//		Motor motor4 = new Tweewielers();
		System.out.println("motor4 werkt niet, je kan geen nieuwe parent instantie maken van het type child");
		
	}
	
}
