package academy.learnprogramming;

public interface _109_Herbivore {

	
//	default int getRewuiredPlantAmount(); 	// een default methode moet een body hebben, dus dit compileert niet
	
//	public int getRewuiredPlantAmount() {	// dit heeft wel een body maar geen defoult keyword voor.
//		return;								// ook dit zal niet compileren
//	}
	
	default void eatPlants() {
		System.out.println("Eating plants");
	}
}
