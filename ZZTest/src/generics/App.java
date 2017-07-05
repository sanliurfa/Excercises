/**
 * 
 */
package generics;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ro-goki
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		// Voor java 5 //
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("appel");
		list.add("banaan");
		list.add("sinasappel");
		
		String fruit = (String) list.get(1);
		System.out.println(fruit);
		
		// Generics na java 5//
		ArrayList<String> strings = new ArrayList<String>();
		
		strings.add("poes");
		strings.add("hond");
		strings.add("vogel");
		
		String dier = strings.get(1);
		System.out.println(dier);
		
		// Je kan meerdere typen declareren (paramaterized)
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		

	}

}
