package usearraylist;

import java.util.ArrayList;

public class ArrayListSubList {
	public static void main(String[] a) {
			
		ArrayList a1 = new ArrayList<>();
		
		a1.add("OC");
		a1.add("JP");
		a1.add(1,"A");
		a1.add(3,"8");
		a1.add(4,"8");	
		System.out.println(a1);
		System.out.println("a1.subList(1, 3)");
		System.out.println(a1.subList(1, 3));//prints [A, JP]
		
		System.out.println("Let op eerste index is inclusief, laatste is exclusief, dus 1 TOT 3");
		

	}

}
