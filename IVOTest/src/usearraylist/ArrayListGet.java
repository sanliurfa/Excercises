package usearraylist;

import java.util.ArrayList;

public class ArrayListGet {
	public static void main(String[] a) {
			
		ArrayList al = new ArrayList<>();
		al.add("OC");
		al.add("JP");
		al.add(1,"A");
		al.add(3,"8");
		al.add(4,"8");	
		System.out.println(al);//prints [OC, A, JP, 8, 8]
		System.out.println("al.set(1, \"P\")");
		al.set(1, "P");
		System.out.println(al);//prints [OC, P, JP, 8, 8]
		System.out.println("al.get(2)");
		System.out.println(al.get(2));//prints JP
		
	}

}
