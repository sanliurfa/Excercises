package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _074_SearchingArrayList {

	public static void main(String[] args) {
		List<String> numsList = new ArrayList<>();
		numsList.add("500");
		numsList.add("10");
		numsList.add("9");
		numsList.add("50");
		numsList.add("40");
		
		System.out.println(numsList);
		int index = Collections.binarySearch(numsList, "10");
		System.out.println(index);
		// Men krijgt hier de resultaat -1 omdat de lijst nog niet gesorteerd is.
		// ook hiet geldt dat als eerst gesorteerd moet worden voordat men een Search gaat uitvoeren.
		
		Collections.sort(numsList);
		index = Collections.binarySearch(numsList, "10");
		System.out.println(index); // 0
		
		System.out.println(numsList);
		
		List<Integer> numbers = Arrays.asList(5, 4, 8, 10, 11, 7, 3);
		System.out.println(numbers);
		index = Collections.binarySearch(numbers, 10);
		
		// Ook hier geldt dat de list gesorteerd moet zijn voor een Search actie
		// en hier wordt het op een integer manier gesorteerd
		Collections.sort(numbers);
		index = Collections.binarySearch(numbers, 10);
		System.out.println(numbers);
		System.out.println(index);
		
				

	}

}
