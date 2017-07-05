/**
 * 
 */
package lecture51transient;

import java.io.Serializable;

/**
 * @author ro-goki
 *
 */
public class Person implements Serializable{
	
	/*
	 * Serializen is het omzetten van een object in een serie van bytes zodat het 
	 * makkelijker op volgorde kan opgeslagen of gecommuniceerd kan worden.
	 * Voorbeeld is bijvoorbeeld het opslaan in een bestand.
	 */


	private static final long serialVersionUID = 4917959441541466006L;
	// UID zorgt ervoor dat de versie waarbij het object ge-serialized is
	// controle kan uitvoeren om te zorgen dat het met de juiste class gede-serialized word.


	/**
	 * @param args
	 */
	private transient int id;
	// transient word gebruikt voor die onderdelen die niet ge-serialized mogen worden.
	
	private String name;
	
	private static int count;
	
	public Person(){
		System.out.println("Default constuctor");
	}
	
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Person.count = count;
	}

	public Person(int id, String name) {
		
		this.id = id;
		this.name = name;
		
		System.out.println("Two argument constuctor");
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "] Count is: "+ count;
	}
	
	

}
