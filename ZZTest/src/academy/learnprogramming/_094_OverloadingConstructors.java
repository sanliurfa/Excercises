package academy.learnprogramming;


class Dog1 {
	private String name;
	private String breed;
	private double weight;
	
	public Dog1 (String name) {
//		this.name = name;				// Dit is geen goede programmering omdat je verschillende codes meerdere keren gebruikt
//		breed = "husky";				// in verschillende constuctoren. Je kan een aanroep doen naar een tweede constructor 
//		weight = 30.0;					// d.m.v. this() als methode. regel is hierbij dat de aanroep naar this() de eerste opdracht
										// moet zijn er kan dus een opdracht ervoor geplaatst worden
		
//		System.out.println("constructor1"); // Dit kan dus niet voor de aanroep this(name, "husky"); geplaatst worden
		this(name, "husky");
		System.out.println("constructor 1"); // hier kan dit wel geplaatst worden
	}
	
	public Dog1(String name, String breed) {
//		this.name = name;
//		this.breed = breed;
//		weight = 30.0;
		this(name, breed, 30.0);		// Dit word ook wel de CONSTRUCOR CHAIN genoemd
		System.out.println("consroctur 2");

	
	}
	
	public Dog1(String name, String breed, double weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
		System.out.println("constructor 3");
	}
	
	public void print() {
		System.out.println("name " + name + " breed "+ breed +" weight " + weight);
	}
	
	
	
}


public class _094_OverloadingConstructors {

	public static void main(String[] args) {
		Dog1 dog1 = new Dog1("Jimmy");
		dog1.print();
		
		Dog1 dog2 = new Dog1("Anthony", "shepard");
		dog2.print();
		
		Dog1 dog3 = new Dog1("Rex", "german shephard", 40);
		dog3.print();
		

//		Uitkomst;
//		constructor 3
//		consroctur 2
//		constructor 1
//		name Jimmy breed husky weight 30.0
//		constructor 3
//		consroctur 2
//		name Anthony breed shepard weight 30.0
//		constructor 3
//		name Rex breed german shephard weight 40.0

		
		
		
	}

}
