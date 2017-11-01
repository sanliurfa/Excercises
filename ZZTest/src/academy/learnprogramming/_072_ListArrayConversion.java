package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _072_ListArrayConversion {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Tony");
		names.add("Jimmy");
		names.add("Anthony");
		
		Object [] namesArray = names.toArray();
		System.out.println(namesArray.length);
		
		String [] stringArray = names.toArray(new String[0]);
		
		String [] anotherStringArray = names.toArray(new String[names.size()]);
		
		
		// Het converteren van een array naar een list
		
		String [] petsArray = {"Dog", "cat", "parrot"};
		//String [] petsArray = new String[] {"Dog", "cat", "parrot"};
		//List<String> petsList = Arrays.asList(petsArray);
		
		// Je kan de bovenstaande ook in een keer aanpassen
		List<String> petsList = Arrays.asList(petsArray); // returns a fixed size list
		System.out.println(petsList.size());
		
		
		//Wanneer wij iets wijzigen van de petsList dan wijzigt ook de petsArray
		petsList.set(0, "bird");
		System.out.println(petsList);
		System.out.println(Arrays.toString(petsArray));
		
		
		
		// Wanneer wij iets wijzigen van de petArray dan wijzigt ook de petsList
		
		petsArray[0] = "husky";
		System.out.println(petsList);
		System.out.println(Arrays.toString(petsArray));
	
		// LET OP met een "asList" List krijgt men een FIXED SIZE hierdoor kan je niets toevoegen of verwijderen
//		petsList.add("newDog");
//		petsList.remove(1);
		
		
		
			

	}

}
