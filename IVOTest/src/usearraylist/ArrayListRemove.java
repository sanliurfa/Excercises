package usearraylist;

import java.util.ArrayList;

public class ArrayListRemove {
	public static void main(String[] a) {
			
		ArrayList al = new ArrayList<>();
		al.add("OC");
		al.add("JP");
		al.add(1,"A");
		al.add(3,"8");
		al.add(4,"8");	
		System.out.println(al);//prints [OC, A, JP, 8, 8]
		System.out.println("al.remove(\"A\")");
		al.remove("A");
		System.out.println("al.remove(3)");
		al.remove(3);
		System.out.println(al);//prints [OC, JP, 8]
		System.out.println("al.clear()");
		al.clear();
		System.out.println(al);//prints []
		
	}

}