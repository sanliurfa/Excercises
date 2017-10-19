package academy.learnprogramming;

import java.util.ArrayList;
import java.util.List;

public class _069_UsingArrayListMethods {

	public static void main(String[] args) {
		//List list = new ArrayList<>();
		// onderstaande is gelijk aan de bovenstaande; alsof je de type wel heb gedefinieerd
		 List<Object> list = new ArrayList<>();
		
		list.add("dog");
		list.add(5);
		
		System.out.println(list);
		
		List<String> pets = new ArrayList<>();
		pets.add("dog");
		
		pets.add(0, "cat");			// (index, String)
		System.out.println(pets);
		
		// Voor de examen schrijf voor jezelf hoe de list er voor staat:
		// 	0		1
		//	cat		dog
		pets.add(1, "parrot"); 	//cat, parrot, dog
		pets.add(0, "husky");	//husky, cat, parrot, dog
		pets.add(1, "bird");	//husky, bird, cat, parrot, dog
		System.out.println(pets);
		
		pets.remove("parrot"); 	//husky, bird, cat, dog
		System.out.println(pets); 
		
		pets.remove(1);			//husky, cat, dog
		System.out.println(pets);
		
		pets.set(0, "newBird");	//newBird, cat, dog
		System.out.println(pets);
		
//		pets.set(6, "outofIndex"); // Dit zorgt voor een exception omdat in de list maar 3 posities 
//		System.out.println(pets);	// aanwezig zijn.
		
		
		
		
		
		
		
		
		

	}

}
