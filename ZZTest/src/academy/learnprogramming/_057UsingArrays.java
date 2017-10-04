package academy.learnprogramming;

import java.util.Arrays;

public class _057UsingArrays {

	public static void main(String[] args) {
		String [] pets = {"parrot", "cat", "dog" };
		
		for (int i = 0; i < pets.length; i++) {
			System.out.println(pets[i]);
		}
			
		pets[0] = "bird";
		
		for (int i = 0; i <= pets.length - 1; i++) {   	// <= gaat niet werken omdat de index met 0 begint en dus de laatste niet meegenomen moet worden
			System.out.println(pets[i]); 			// wat wel werkt is in dit geval i <= pets.lenght -1
		}
		
		
		// wanneer je direct arrays print, dan krijg je de array hashcode
		System.out.println(pets);
		
		// je kan toString gebruiken om de inhoud hiervan netjes te printen
		System.out.println(Arrays.toString(pets));
		
		// default krijg de int Array de 0 waarde
		int [] numbers = new int[5];
		System.out.println(Arrays.toString(numbers));
		
		// default krijgt de String Array de null waarde
		String [] newPets = new String[5];
		System.out.println(Arrays.toString(newPets));
		
		
		// voor het vullen van een array
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 10;
		}
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("numbers[ "+ i + " ]= " + numbers[i]);
		}
		System.out.println(numbers);
		System.out.println(Arrays.toString(numbers));
		
		// met Wrappers
		Integer [] nums = new Integer[4];
		System.out.println(Arrays.toString(nums));
		
		for (int i = 0; i < nums.length; i++) {
			nums [i] = i % 3;						// iteratie 	i		(i%3)
													//	1			0		0 (0/3 en dan rest hiervan)
													//	2			1		1 (1/3 
													//	3			2		1 (2/3) rest 2	
													//  4			3		1 (3/3 rest is 0)
			}
		
		
		System.out.println(Arrays.toString(nums));
		
		
		
	}

}
