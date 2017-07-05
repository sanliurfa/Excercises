package lecture52passingbyvalue;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		App app = new App();
		//-----------------------------------------
		int value = 7;
		
		System.out.println("1. Value is ; "+ value);
		
		app.show(value);
		
		System.out.println("4. Value is ; "+ value);
		
		//------------------------------------------
		System.out.println();
		
		Person person = new Person("Bob");
		System.out.println("1. (Adres object 1) Person is: "+ person);
		
		app.show(person);
		
		System.out.println("4. (Adres object 1) Person is: "+ person);

	}
	
	
	public void show(int value){
		System.out.println("2. Value is ; "+ value);
		
		value = 8;
		
		System.out.println("3. Value is ; "+ value);
	}
	
	
	public void show(Person person){ // dit maakt een een kopie van person
		System.out.println("2. (Adres object 1) Person is: "+ person);
		
		person.setName("Sue"); // dit veranderd de waarde van de referentie (Adres object 1) person dus de originele object)
		
		person = new Person("Mike"); //Dit maakt een  nieuwe object aan. met de waarde Mike erin
		
	//	person.setName("Sue"); 
		
		System.out.println("3. (Adres object 2) Person is: "+ person); 
	}

}
