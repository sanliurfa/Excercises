/**
 * 
 */
package lecture58objectsinsetsandkeys;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ro-goki
 *
 *
 */

class Person{
	private int id;
	private String name;
	
	public Person(int id, String name){
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return id + " : " + name ;
	}
	

	
}

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Person p1 = new Person(1, "Bob");
		Person p2 = new Person(2, "Sue");
		Person p3 = new Person(3, "Mike");
		Person p4 = new Person(2, "Sue");
		
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("one", 1);
		
		for(String key: map.keySet()){
			System.out.println(key +": "+ map.get(key));
		}
		
		Set<String> set = new LinkedHashSet<String>();
		
		set.add("dog");
		set.add("cat");
		set.add("mouse");
		set.add("cat");
		
		System.out.println(set);

	}

}
