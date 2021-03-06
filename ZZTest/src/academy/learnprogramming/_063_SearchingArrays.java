package academy.learnprogramming;

import java.util.Arrays;

public class _063_SearchingArrays {

	public static void main(String[] args) {
		// Voor het examen moet je weten welke uitkomsten je kan krijgen in een bepaalde situatie
		// Je hoeft niet te weten hoe de binary search werkt.
		
		int[] numbers= {1, 2, 5, 6, 7};
		
		System.out.println(Arrays.binarySearch(numbers, 2));		// hier word gezocht naar number 2 in numbers
		System.out.println(Arrays.binarySearch(numbers, 5));
		System.out.println(Arrays.binarySearch(numbers, 7));
		System.out.println(Arrays.binarySearch(numbers, 1));
		System.out.println(Arrays.binarySearch(numbers, 3));
		System.out.println(Arrays.binarySearch(numbers, 6));
		System.out.println(Arrays.binarySearch(numbers, 4));
		
		// Regel 1: Wanneer er een getal gevonden word dan krijg je de index terug (beginnend met 0)
		// Regel 2: Wanneer er een getal niet gevonden word dan krijg je een - en de index waar het zou moet zitten bijvoorbeeld:
		// In de eerst print wordt gezocht naar het getal 2, dit zou na het nummer 1 moeten komen op index 0 dus resultaat -2?
		
		// Bij niet gestorteerde
		
		int[] notSortedNumbers = {5, 4, 10, 8, 6};
		
		System.out.println(Arrays.toString(notSortedNumbers));
		System.out.println(Arrays.binarySearch(notSortedNumbers, 5));
		System.out.println(Arrays.binarySearch(notSortedNumbers, 8));
		
		// Regel 3: wanneer het niet gesorteerd dan kan men unpredictable result krijgen
		// Bij een examen: wanneer het niet gesorteerd is dan meteen de antwoord unpredictable result geven.
		
		//Wanneer wij het wel gaan sorteren
		Arrays.sort(notSortedNumbers);
		
		System.out.println(Arrays.toString(notSortedNumbers));
		System.out.println(Arrays.binarySearch(notSortedNumbers, 5));
		System.out.println(Arrays.binarySearch(notSortedNumbers, 8));

		// Dan krijgt men een heel ander resultaat
		
	}

}
