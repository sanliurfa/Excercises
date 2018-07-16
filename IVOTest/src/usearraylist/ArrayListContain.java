package usearraylist;

import java.util.ArrayList;

public class ArrayListContain {
	public static void main(String[] a) {
			
		ArrayList al = new ArrayList<>();
		al.add("OC");
		al.add("JP");
		al.add(1,"A");
		al.add("OC");
		al.add(3,"8");
		al.add(4,"8");	
		System.out.println(al);//prints [OC, A, JP, 8, 8]
		System.out.println("al.contains(\"A\")");
		System.out.println(al.contains("A"));//prints true
		System.out.println("al.indexOf(\"OC\")");
		System.out.println(al.indexOf("OC"));//prints 0
		System.out.println("al.lastIndexOf(\"OC\")");
		System.out.println(al.lastIndexOf("OC"));//prints 5
	}

}