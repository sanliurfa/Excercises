/**
 * 
 */
package lecture50serializingarrays;

import java.io.Serializable;

/**
 * @author ro-goki
 *
 */
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6039787824011747089L;
	/**
	 * @param args
	 */
	private int id;
	private String name;
	
	public Person(int id, String name) {
		
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	

}
