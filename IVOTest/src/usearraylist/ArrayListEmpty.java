package usearraylist;

import java.util.ArrayList;

public class ArrayListEmpty {
	public static void main(String[] a) {
			
		ArrayList al = new ArrayList<>();
		System.out.println(al.isEmpty());//prints false  print wanneer het leeg is true
		System.out.println("ArrayList word gevuld");
		al.add("OC");
		al.add("JP");
		al.add(1,"A");
		al.add(3,"8");
		al.add(4,"8");	
		System.out.println(al);//prints [OC, A, JP, 8, 8]
		System.out.println(al.isEmpty());//prints false  print wanneer het leeg is true
		System.out.println(al.size());//prints 5 print de grootte van de ArrayList
	}

}
