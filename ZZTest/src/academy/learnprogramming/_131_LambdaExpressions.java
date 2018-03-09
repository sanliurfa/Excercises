package academy.learnprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


class Animal131 {
	private String type;
	private boolean canJump;
	private boolean canSwim;

	public Animal131(String type, boolean canJump, boolean canSwim) {
		this.type = type;
		this.canJump = canJump;
		this.canSwim = canSwim;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the canJump
	 */
	public boolean isCanJump() {
		return canJump;
	}

	/**
	 * @return the canSwim
	 */
	public boolean isCanSwim() {
		return canSwim;
	}

}

interface CheckAnimal131 {                     // interfaces met een methode worden ook wel functionele interfaces genoemd.
	boolean check(Animal131 animal);     
}


class CheckCanJump131 implements CheckAnimal131{

	/* (non-Javadoc)
	 * @see academy.learnprogramming._131_LambdaExpressions.CheckAnimal#check(academy.learnprogramming._129_LambdaExpressions.Animal)
	 */
	@Override
	public boolean check(Animal131 animal) {
		return animal.isCanJump() ;
	}
	
}

interface AnotherCheck131{
	boolean check(Animal131 first, Animal131 second);
}


public class _131_LambdaExpressions {


	public static void main(String[] args) {
		List<Animal131> animals = new ArrayList<>();
		animals.add( new Animal131("fish", false, true));
		animals.add( new Animal131("rabbit", true, false));
		animals.add( new Animal131("dog", true, true));
		
//		print(animals, new CheckCanJump131());
		
		print(animals, animal -> animal.isCanSwim());
		print(animals, animal -> !animal.isCanSwim());
		
		
		print(animals, (Animal131 animal) -> {
			return animal.isCanJump();							// Bij een statement dan is er geen 
		});
		
		
		print(animals, (Animal131 animal) -> {
			System.out.println("checking animal= "+ animal.getType());
			return animal.isCanJump();
		});
		
		
		Animal131 fish = animals.get(0);
		Animal131 rabbit = animals.get(1);
		Animal131 dog = animals.get(2);
		
		print(fish, rabbit, (f, s) -> f.isCanJump() && s.isCanSwim() );
		print(fish, dog, ((first, second) -> first.isCanSwim() && second.isCanSwim() ));
		
		List<String> names = new ArrayList<>();
		names.add("John");
		names.add("Anthony");
		names.add("Jimmy");
		names.add("Timmy");
		
		System.out.println("names= "+ names);
		
//		names.removeIf(name -> name.charAt(0) == 'J');
		
		names.removeIf((String str) -> {				// Lange versie lambda
			return str.charAt(0) == 'J';
		});
		
		System.out.println("After filter names= " + names);
	}
	
	private static void print(Animal131 first, Animal131 second, AnotherCheck131 check) {
		System.out.println(check.check(first, second));
	}
	
	private static void print(List<Animal131> animals, Predicate<Animal131> filter) {
		for (Animal131 animal : animals) {
			if(filter.test(animal)) {
				System.out.println(animal.getType());
			}
		}
		System.out.println();
	}
	

}
