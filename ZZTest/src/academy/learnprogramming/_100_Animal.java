package academy.learnprogramming;

public class _100_Animal {
//	public _099_Animal() {
//		System.out.println("Animal");
//	}

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

	public _100_Animal(int age) {
		System.out.println("Animal");
		this.age = age;
	}
	
	protected void printDetails() {
		System.out.println("name= "+ name+ " age= "+ age);
	}
}