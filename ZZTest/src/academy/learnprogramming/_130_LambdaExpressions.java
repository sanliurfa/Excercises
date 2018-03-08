package academy.learnprogramming;

import java.util.ArrayList;
import java.util.List;


class Animal130 {
	private String type;
	private boolean canJump;
	private boolean canSwim;

	public Animal130(String type, boolean canJump, boolean canSwim) {
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

interface CheckAnimal130 {
	boolean check(Animal130 animal);
}


class CheckCanJump130 implements CheckAnimal130{

	/* (non-Javadoc)
	 * @see academy.learnprogramming._130_LambdaExpressions.CheckAnimal#check(academy.learnprogramming._129_LambdaExpressions.Animal)
	 */
	@Override
	public boolean check(Animal130 animal) {
		return animal.isCanJump() ;
	}
	
}




public class _130_LambdaExpressions {


	public static void main(String[] args) {
		List<Animal130> animals = new ArrayList<>();
		animals.add( new Animal130("fish", false, true));
		animals.add( new Animal130("rabbit", true, false));
		animals.add( new Animal130("dog", true, true));
		
		print(animals, new CheckCanJump130());
		
		print(animals, animal -> animal.isCanSwim());
		print(animals, animal -> !animal.isCanSwim());
		
		
		
		print(animals, animal -> System.out.println("checking animal= "+ animal.isCanJump());
	}
	
	private static void print(List<Animal130> animals, CheckAnimal130 filter) {
		for (Animal130 animal : animals) {
			if(filter.check(animal)) {
				System.out.println(animal.getType());
			}
		}
		System.out.println();
	}
	

}
