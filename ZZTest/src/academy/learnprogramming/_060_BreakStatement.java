package academy.learnprogramming;

public class _060_BreakStatement {

	public static void main(String[] args) {
		
//		myLabel:												// Je kan geen label gebruiken bij een assignement!
//			int[] myArray = {1, 2, 3};

		
		myLabel: {												// Je kan een Label gebruiken bij een blok!!
		int[] myArray = {1, 2, 3};								// Alleen nu is myArray alleen te gebruiken binnen de blok en niet buiten.
	}
		
	String[] animals = {"Dog", "Cat", "Lizard", "Bird", "Snake"};
	
	for (String animal : animals) {
		System.out.println(animal);
	}
	
	// Het gebruik van een break statement met label
	
	MY_LOOP:
		for (String animal : animals) {
			if(animal.equals("Cat")){
				break MY_LOOP;									// breekt door de for Loop!!
			}
			System.out.println(animal);
		}
	
	
	// Het kan verwarrend worden wanneer de label hetzelfde naam krijgt als de variabele
		animal :for (String animal : animals) {
			if(animal.equals("Cat")){
				break animal;									// breekt door de for Loop!!
			}
			System.out.println(animal);
		}
		
		
			for (String animal : animals) {
				if(animal.equals("Lizard")){
					break;									// breekt door de for Loop!! Conclusie BREAK springt uit elke LOOP en niet bijv if.
				}
				System.out.println(animal);
			}
		
			
			int index = 0;									// Hetzelfde maar nu met while loop
			while(index < animals.length){
				String animal = animals[index];
				if (animal.equals("Lizard")){
					break;
				}
				System.out.println(animal);
				index++;
			}
	
	
		
	}

}
