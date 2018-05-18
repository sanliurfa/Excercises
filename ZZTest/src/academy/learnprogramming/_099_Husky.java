package academy.learnprogramming;

public class _099_Husky extends _099_Dog {

	public _099_Husky(int age) {
		super(age);
		// TODO Auto-generated constructor stub
	}
	public _099_Husky() {
//		this();							// this() roept de constructor op van de huidige class
		super();						// super() roept de constructor van parent class
		System.out.println("Husky");
	}

}
