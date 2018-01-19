package academy.learnprogramming;

public class _113_PolyParameters {
	public static void main(String[] args) {
		_113_Huskey husky= new _113_Huskey(3);
		husky.setName("Rex");
		printDetails(husky);
		
		_113_Rabbit rabbit = new _113_Rabbit();
		rabbit.setName("Bunny");
		printDetails(rabbit);
		
		_113_Cat cat = new _113_Cat(2);
		cat.setName("Tom");
		printDetails(cat);
		
		_113_Animal rex = createAnimal("Rex", 4);
		printDetails(rex);
		
		_113_Animal kitty = createAnimal("Kitty", 3);
		printDetails(kitty);
		
		_113_Animal bunny = createAnimal("Bunny", 2);
		printDetails(bunny);
		
		
		
	}
	
//	public static void printDetails(_113_Huskey husky) {
//		husky.printDetails();
//	}
//
//	public static void printDetails(_113_Rabbit rabbit) {
//		rabbit.printDetails();
//	}
//	
	
	
	// In plaats van de bovenstaande steeds opnieuw te herhalen kunnen we ook de onderstaande toepassen omdat ze allenmaal van Animal zijn
	public static void printDetails(_113_Animal animal) {
		animal.printDetails();
	}
	
	public static _113_Animal createAnimal(String name, int age) {
		if(name.equals("Rex")) {
			_113_Animal animal = new _113_Huskey(age);
			animal.setName(name);
			return animal;
		} else if ( name.equals("Kitty")){
			_113_Animal cat = new _113_Cat(3);
			cat.setName(name);
			return cat;
		}
		_113_Animal rabbit = new _113_Rabbit(age);
		rabbit.setName(name);
		return rabbit;
		
	}

}
