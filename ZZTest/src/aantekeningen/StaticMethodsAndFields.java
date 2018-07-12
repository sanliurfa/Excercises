package aantekeningen;

public class StaticMethodsAndFields {

	private static int i;					// Dit is een static variabele dus een class variabele	
	private int j;							// j is een instance variabele dus voor elk instance zijn eigen variabele

	public StaticMethodsAndFields(int j) {
		this.j = j;
	}

	static {								
		i = 100;							// bij initialistie is class variabele 100
	}

	public static void main(String args[]) {
		StaticMethodsAndFields example1 = new StaticMethodsAndFields(10);
		StaticMethodsAndFields example2 = new StaticMethodsAndFields(20);
		StaticMethodsAndFields.i = 200;
		System.out.println(example1.j);
		System.out.println(example2.j);
		System.out.println(example1.i);
		System.out.println(example2.i);
	}

}
