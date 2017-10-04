package academy.learnprogramming;

public class _061_ContinueStatement {

	public static void main(String[] args) {
		// Continue statement gaat naar de volgende Itteratie!!
		
		String [] animals = {"Dog", "Cat", "Lizard", "Bird", "Snake" };
		
		for (String animal : animals) {
			System.out.println(animal);
		}
		
		MY_LOOP:
			for (String animal : animals) {
				if(animal.equals("Cat")){
					continue MY_LOOP;
				}
					System.out.println(animal);
			}
		
		
		// om verwarring te zorgen bij een examen wordt de label naam gelijk aan een variabele
		
		animal:
			for (String animal : animals) {
				if(animal.equals("Cat")){
					continue animal;
				}
					System.out.println(animal);
			}
			
			// je kan ook hetzelfde bereiken ZONDER een label te schrijven
			
				for (String animal : animals) {
					if(animal.equals("Cat")){
						continue ;
					}
						System.out.println(animal);
				}			
				
				
				// hetzelfde kan ook verkregen worden met een while loop
				int index = 0;
				while (index < animals.length){
					String animal = animals[index];
					index++;
					
					if (animal.equals("Lizard")){
						continue;
					}
					System.out.println(animal);
					
				}
				
/*
 * lijst welke je moet onthouden
 * 				Optional Labels			Break			continue
 * if			yes						no				no   			// geen loop
 * while		yes						yes				yes				// loop
 * dowhile		yes						yes				yes				// loop
 * for			yes						yes				yes				// loop
 * switch		yes						yes				no				// geen loop
 */
			

	}

}
