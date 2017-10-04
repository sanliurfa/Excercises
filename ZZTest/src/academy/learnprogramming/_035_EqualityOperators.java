package academy.learnprogramming;

public class _035_EqualityOperators {

	public static void main(String[] args) {
		boolean x = true;
		boolean y = false;
		boolean z = (y = true) && (x = false);
					// y krijgt de nieuwe waarde true 
					// compiler kijkt naar de tweede statement want de eerste gedeelte is true
					// x krijgt de waarde false
					// true && false -> false
		
		System.out.println("x= "+ x); //false
		System.out.println("y= "+ y); //true
		System.out.println("z= "+ z); //false

	}

}
