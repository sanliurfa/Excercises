package usearraylist;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListCreate {
	public static void main(String[] a) {

		ArrayList al1 = new ArrayList<>();// capacity is 10
		ArrayList al2 = new ArrayList<>(20);// capacity is 20
		LinkedList ll = new LinkedList<>();
		ArrayList al3 = new ArrayList<>(ll);// capacity may greater than
													// number of objects

	}

}
