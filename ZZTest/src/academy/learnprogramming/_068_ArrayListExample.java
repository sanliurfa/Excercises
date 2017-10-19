package academy.learnprogramming;

import java.util.ArrayList;
import java.util.List;

public class _068_ArrayListExample {

	public static void main(String[] args) {
		ArrayList myList = new ArrayList();
		ArrayList<Object> myList2 = new ArrayList<>();
		
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		List<String> list3 = new ArrayList<>();   //using interface (List) as type
		
		// Je kan niet een  List maken van het type ArrayList
//		ArrayList<String> list4 = new List();	Dit zal niet compileren
		
		List<String> list5 = new ArrayList<>(20);
		
	}

}
