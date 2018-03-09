package academy.learnprogramming;

import java.util.ArrayList;
import java.util.List;


class Animal {
	private String type;
	private boolean canJump;
	private boolean canSwim;

	public Animal(String type, boolean canJump, boolean canSwim) {
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

interface CheckAnimal {
	boolean check(Animal animal);
}


class CheckCanJump implements CheckAnimal{

	/* (non-Javadoc)
	 * @see academy.learnprogramming._129_LambdaExpressions.CheckAnimal#check(academy.learnprogramming._129_LambdaExpressions.Animal)
	 */
	@Override
	public boolean check(Animal animal) {
		return animal.isCanJump() ;
	}
	
}




public class _129_LambdaExpressions {


	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<>();
		animals.add( new Animal("fish", false, true));
		animals.add( new Animal("rabbit", true, false));
		animals.add( new Animal("dog", true, true));
		
		print(animals, new CheckCanJump());
		
		print(animals, animal -> animal.isCanSwim());
		print(animals, animal -> !animal.isCanSwim());
		

		
	}
	
	private static void print(List<Animal> animals, CheckAnimal filter) {
		for (Animal animal : animals) {
			if(filter.check(animal)) {
				System.out.println(animal.getType());
			}
		}
		System.out.println();
	}
	

}
