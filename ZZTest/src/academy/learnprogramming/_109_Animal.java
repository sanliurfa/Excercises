package academy.learnprogramming;

public class _109_Animal {
//	public _099_Animal() {
//		System.out.println("Animal");
//	}
	
	public _109_Animal() {
		
	}

	private int age;
	private String name; 
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public _109_Animal(int age) {
		System.out.println("Animal");
		this.age = age;
	}
	
	protected void printDetails() {
		System.out.println("name= "+ name+ " age= "+ age);
	}
	
	public void eat() {
		System.out.println("Animal is eating");
	}
	
//	public final double getAverageWeight() {				// Wanneer een methode final is dan kan het niet overridden worden.
	public double getAverageWeight() {
		return 10.0;
	}
}
