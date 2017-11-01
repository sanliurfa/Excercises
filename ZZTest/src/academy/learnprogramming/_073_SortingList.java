package academy.learnprogramming;

import java.util.*;

public class _073_SortingList {

	public static void main(String[] args) {
		List<String> numsList = new ArrayList<>();
		numsList.add("500");
		numsList.add("10");
		numsList.add("9");
		numsList.add("50");
		numsList.add("40");
		
		System.out.println(numsList);
		
		Collections.sort(numsList);
		System.out.println(numsList); // 10, 40, 50, 500, 9
		// Dit word als String gesorteerd hierdoor dus alfabetish en omdat de 9 hoger staat dan 500 krijg je de bovenstaande sortering
		
		List<Integer> numbers = Arrays.asList(5, 4, 8, 10, 11, 7, 3);
		System.out.println(numbers);
		Collections.sort(numbers);
		System.out.println(numbers);
		//Omdat het hier om Integers gaat wordt dit wel netjes gesorteerd.
		
		
		
		
		
		
		
		

	}

}
