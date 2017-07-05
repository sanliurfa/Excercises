package lector47enumtypes;

public enum Animal {
	//CAT, DOG, MOUSE; //Dit zijn objecten, zonder new aan te spreken
	CAT("henry"), DOG("Fido"), MOUSE("Jerry");
	// je kan in de bovenstaande objecten een constructor maken waarbij een variabele toegekent kan worden
	
	
	private String name;
	
	Animal(String name ){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String toString(){
		return "This animal is called: "+name;
	}
	
}
