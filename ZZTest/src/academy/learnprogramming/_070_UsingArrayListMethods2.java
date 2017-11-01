package academy.learnprogramming;

import java.time.Period;
import java.util.*;

public class _070_UsingArrayListMethods2 {

	public static void main(String[] args) {
		List<String> pets = new ArrayList<>();
		
		System.out.println(pets.isEmpty());
		System.out.println(pets.size());
		
		
		if (pets.isEmpty()) {
			System.out.println("no pets");
		}
		
		if (pets.size() == 0) {
			System.out.println("no pets");
		}
		
		pets.add("Cat");
		System.out.println(pets.isEmpty());
		System.out.println(pets.size());
		
		pets.clear();
		System.out.println(pets.isEmpty());
		System.out.println(pets.size());
		
		pets.add("Dog");
		System.out.println(pets.contains("cat"));
		System.out.println(pets.contains("Dog"));
		
		// equals vergelijkt twee list of het zelfde inhoud en op de zelfde volgorde heeft
		
		List<String> newPets = new ArrayList<>();
		newPets.add("Dog");
		System.out.println(pets.equals(newPets));
		
		newPets.add("Cat");
		System.out.println(pets.equals(newPets));
		
		pets.add("Dog");
		System.out.println(pets);
		System.out.println(newPets);
		
		System.out.println(pets.equals(newPets));
		
		
		
		
		
		
		

	}

}
