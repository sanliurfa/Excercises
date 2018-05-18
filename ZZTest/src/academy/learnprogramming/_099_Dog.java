package academy.learnprogramming;

public class _099_Dog extends _099_Animal {
	public _099_Dog() {
		System.out.println("Dog constructor without param");
	}
	
	public _099_Dog(int age) {
		super(age);
		System.out.println("Dog");
	}

}
