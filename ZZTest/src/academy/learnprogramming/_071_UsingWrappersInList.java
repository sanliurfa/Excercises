package academy.learnprogramming;

import java.util.*;

public class _071_UsingWrappersInList {

	public static void main(String[] args) {
		/**
		 * Je kan geen list maken van Primitives!!
		 */
		
		// dus dit werkt niet, omdat je niet een list kan maken van primitives
		// dit komt omdat primitives geen classes zijn
//		List<double> doubleList = new ArrayList<>();
	
		
		// Om dit te verhelpen gebruikt men Wrappers, deze hebben dezelfde naam, maar zijn classes en dus worden zij 
		// geschreven met hoofdletters
		List<Double> doubleList = new ArrayList<>();
		
		doubleList.add(10.55); // hier wordt autoboxing toegepast, dwz de primitive 10.5 wordt automatisch omgezet in een class
		doubleList.add(new Double(55.10)); // dit is hetzelfde als hierboven zonder autoboxing toe te passen
		doubleList.remove(55.10); // weer autoboxing toepassing
		
		double first = doubleList.get(0); // dit is unboxing; dus de waarde van de index 0 wordt automatisch omgezet naar een double
		
		System.out.println(first);
		System.out.println(doubleList);
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(null);
		
		System.out.println(numbers);
		
		
// EXAMEN instinker:		
//		int number = numbers.get(0); // LET OP!! hier wordt een unboxing toegepast maar je kan een null waarde niet omzetten naar een 
									// primitive!! je kan wel de waarde 0 omzetten maar niet null!!
		
//		System.out.println(number);
		
// Nog een EXAMEN instinker
		List<Integer> nums = new ArrayList<>();
		nums.add(1); // index 0
		nums.add(2); // index 1
		
		nums.remove(1); // verwijderd de waarde in index 1
//		nums.remove(new Integer (1)); // dit leegt de index met de INHOUD met de waarde 1
		System.out.println(nums);
		
	
		
		
		
		
		
		
		

	}

}
