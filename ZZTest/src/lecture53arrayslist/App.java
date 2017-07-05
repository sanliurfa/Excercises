package lecture53arrayslist;

import java.util.ArrayList;
import java.util.List;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(10);
		numbers.add(100);
		numbers.add(40);
		
		System.out.println(numbers.get(0));
		
		System.out.println("Iteration #1: ");
		// index for loop iteration
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));			
		}
		
		//removing items
		numbers.remove(numbers.size()-1);
		
		// this is very slow because it removes de first index
		numbers.remove(0);
		
		
		System.out.println("\nIteration #2: ");
		for(Integer value:numbers){
			System.out.println(value);
		}
		
// List interface
		List<String> values = new ArrayList<String>();

	}

}
