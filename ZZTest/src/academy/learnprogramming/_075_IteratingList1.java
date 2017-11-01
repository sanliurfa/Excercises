package academy.learnprogramming;

import java.util.*;

public class _075_IteratingList1 {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(2);
		numbers.add(4);
		numbers.add(6);
		
		for(int i = 0; i < numbers.size(); i++) {
			System.out.println("Element at index "+ i + " is " + numbers.get(i));
//			numbers.remove(2); // index out of bounds						
		}
		
		for (Integer number : numbers) {
			System.out.println("number " + number);
			
//			numbers.remove(2); // concurrent modification error 
			// Net als hierboven kan men niet een remove actie uitvoeren wanneer er een itteratie uitgevoerd word.
		}
		
		for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
			Integer number = iterator.next();
			System.out.println(number);
			iterator.remove();     			// met iterator kan de huidige gekozen waarde verwijderd worden.
		}
		
		System.out.println(numbers);		// Met iterator kan men dus en kiezen en de gekozen waarde verwijderen.
		// de lijst is nu leeg
		
		// we gaan weer vullen maar nu in een keer
		numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
		
		// we gebruiken nu de ListIterator
		for (ListIterator<Integer> listIterator = numbers.listIterator(3); listIterator.hasPrevious();){
			System.out.println(listIterator.previous());
			listIterator.remove();
		}
		
		System.out.println(numbers);

	}

}
