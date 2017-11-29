package academy.learnprogramming;

public class _084_DogTester {

	public static void main(String[] args) {
		_084_Dog husky = new _084_Dog();
		
		System.out.println(husky.count); 	// we krijgen hier een waarschuwing dat count static is en dat de field op een static wijze 
											// aangeroepen moet worden.
		System.out.println(_084_Dog.count);
		
		_084_Dog anotherDog = new _084_Dog();
		anotherDog.incrementCounter(); 		// ook hier krijgen we een waarschuwing dat de methode op een static wijze 
											// aangeroepen moet worden.
		
		// dit is de juiste manier om een static methode aan te roepen
		_084_Dog.incrementCounter();
		
		System.out.println(_084_Dog.count);
		
		// Wat gebeurd er wanneer we alle waarden op null zetten?
		
		husky = null;
		anotherDog = null;
		
		System.out.println(_084_Dog.count);
		System.out.println(husky.count);
		System.out.println(anotherDog.count);
		
		_084_Dog.count = 10;
		_084_Dog newDog = new _084_Dog();
		_084_Dog dog2 = new _084_Dog();
		newDog.count = 5;
		
		
		System.out.println(_084_Dog.count); // Wat komt hier als antwoord uit.
		System.out.println(newDog.count);
		System.out.println(dog2.count);
		
		newDog.count = 11;
		
		System.out.println(_084_Dog.count); // Wat komt hier als antwoord uit.
		System.out.println(newDog.count);
		System.out.println(dog2.count);
		
		
		// wanneer het static is zullen de nieuwe objecten dezelfde static field delen.
		
		

	}

}
