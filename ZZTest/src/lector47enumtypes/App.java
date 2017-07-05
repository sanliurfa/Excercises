package lector47enumtypes;

public class App {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		Animal animal = Animal.CAT;

		switch(animal){
		case CAT:
			System.out.println("Cat");
			break;
		case DOG:
			System.out.println("Dog");
			break;
		case MOUSE:
			System.out.println("Mouse");
			break;
		
		}
		System.out.println(Animal.DOG);
		
		System.out.println("Enum name as a string: "+ Animal.DOG.name()); // dit geeft de naam van het object.
		
		System.out.println(Animal.DOG.getClass());
		
		System.out.println(Animal.DOG instanceof Animal); // het is een instantie van Animal
		
		System.out.println(Animal.DOG instanceof Enum); // maar ook een instantie van Enum
		
		System.out.println(Animal.MOUSE.getName());
		
		// je kan ook andersom; object vragen en zijn inhoud;
		
		Animal animal2 = Animal.valueOf("CAT");
		System.out.println(animal2);

	}

}
