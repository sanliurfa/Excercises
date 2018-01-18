package academy.learnprogramming;

public class _103_Snake extends _103_Reptile {

	@Override
	protected boolean hasLegs() {

		return false;
	}
	
	@Override
	protected double getWeight() {			// Je kan als child methode van een overridden methode een mindere access modifier geven
		return 10.0;						// maar niet een striktere, dus het kan public worden maar niet default of private
	}

}



// Overriding = hetzelfde naam en dezelfde parameter
// Overloading = hetzelfde naam NIET hetzelfde parameter

