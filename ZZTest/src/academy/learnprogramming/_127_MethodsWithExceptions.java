package academy.learnprogramming;

class NoMoreMeatException extends Exception {
}

class NoMorePlansException extends RuntimeException {
}

interface Omnivore {
	void eatMeat(int amount) throws NoMoreMeatException; // (4)

	void eatPlants(int amount);
}

class Bear implements Omnivore {

	/*
	 * (non-Javadoc)
	 * 
	 * @see academy.learnprogramming.Omnivore#eatMeat(int)
	 */
	@Override
	public void eatMeat(int amount) throws NoMoreMeatException { // (3) wanneer hieraangegeven word dat er een exception
																	// word gegooit dat geimplemteerd word
																	// dan moet het in de interface methode ook
																	// aangegeven worden dat het een exception word
																	// gegooid
		if (amount <= 0) { // (1) controleert of de waarde
			throw new NoMoreMeatException(); // (2) gooit hier is een Exception deze of behandeld of gedeclareerd
												// worden; dus moet het hierboven aangegeven worden
												// dat het een exception gooit; throws NoMoreMeatException
		}
		System.out.println("Eating meat.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see academy.learnprogramming.Omnivore#eatPlants(int)
	 */
	@Override
	public void eatPlants(int amount) {
		if (amount <= 0) {
			throw new NoMorePlansException(); // Dit hoeft niet afgehandeld worden omdat het een runtime exception is
		}
		System.out.println("Eating plants");
	}

}

public class _127_MethodsWithExceptions {

	public static void main(String[] args) {
		Bear bear = new Bear();
		try {
			bear.eatMeat(2); // omdat dit een checked- exception is kan gooien moet dit behandeld worden door
								// een try catch
			bear.eatPlants(-2);
		}catch (NoMorePlansException e) {
			e.printStackTrace();
			System.out.println("No plants");
		} catch (RuntimeException e) {
			System.out.println("Runtime");
		} catch (NoMoreMeatException e) {
			e.printStackTrace();
			System.out.println("Bear is hungry");
		} finally {
			System.out.println("finally");
		}

//		 bear.eatPlants(-2); 	// dit hoef je niet te behandelen want het is een
								// unchecked exception
	}

}
