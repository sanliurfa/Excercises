package usearraylist;

import java.util.ArrayList;

public class ArrayListAdd {
	public static void main(String[] a) {
			
		ArrayList a1 = new ArrayList<>();
		ArrayList a2 = new ArrayList<>();

		a1.add("OC");
		a1.add("JP");
		a1.add(1,"A");
		a1.add(3,"8");
		a1.add(4,"8");	
		a2.add("OC");
		a2.add("P8");
		System.out.println(a1);//prints [OC, A, JP, 8, 8]
		a1.addAll(a2);
		System.out.println(a1);//prints [OC, A, JP, 8, 8, OC, P8]
		System.out.println(a2);

	}

}

