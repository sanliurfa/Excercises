package academy.learnprogramming;

class Example{
	private String name= "dog";
	
	{
		System.out.println(name);					// een instant initializer
	}
	
	private static int COUNT = 0;
	
	static {										// static initializer
		System.out.println(COUNT);
	}
	
	{												// tweede instant initializer
		COUNT += 10;
		System.out.println(COUNT);
	}
	
	public Example() {								// constructor
		System.out.println("constructor");
	}
	
}

class Demo{
	static {										// static initializer
		add(2);
	}
	
	static void add(int number) {					// static method
		System.out.println(number + " ");
	}
	
	Demo(){											// constructor
		add(5);
	}
	
	static {										// static initializer
		add(4);
	}
	
	{												// initializer
		add(6);
	}
	
	static {										// static initializer
		
		new Demo();	//omdat dit static initializer een constructor aanroept, zal het eerst alle andere initializers uitvoeren
					// voordat het de opdracht van de constructor uitgevoerd word. hierdoor krijg dus 2, 4, (init) 6, 8, 5 (const) 6, 8, 5
	}
	
	{												// initializer
		add(8);
	}
	// volgorde wordt dan:
	//  2, 4, 6, 8, 5
}



public class _096_OrderOfInitiakization {

	public static void main(String[] args) {
		Example example = new Example();
		new Demo();

	}

}


//		CONCLUSIE:
//		1.	Static
//		2. 	Instant variables
//		2.	Instant Initializer
//		3. 	constructors
