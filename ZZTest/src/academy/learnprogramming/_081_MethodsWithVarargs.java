package academy.learnprogramming;

import java.util.Arrays;

public class _081_MethodsWithVarargs {

	
	public void jump1(int... numbers) {}				// een varargs argument
	
	public void jump2(int start, int... numbers) {}		// twee argumenten met een varargs argument
	
//	public void jump3(int... numbers, int start) {}		// dit zal niet compileren omdat de varags altijd de laatste argument moet zijn
	
//	public void jump4(int... start, int... numbers) {}	// dit zal niet compileren omdat er maar een varags mag zijn
	
	public void jump5(int[] start, int[] numbers) {}	// arrays daarintegen zal wel compileren
	
	
	
	
	public static void main(String[] args) {
		jump(1);						// jump aanroep met alleen de start argument
		jump(2, 3);						// jump aanroep met de start en number varags 
		jump(4, 5,6,7);					// jump aanroep met de start en drie varargs aanroep
		jump(1, new int[] {2,3,4});		// jump aanroep met de start en een array voor de vulling van de varargs, al is dit redundent
//		jump(1, null);					// jump aanroep met de start en null voor de varaargs
										// Dit zal niet werken en geeft een nullexception omdat numbers de lengte van null moet tonen
										// en dat kan niet. het is dan beter om hier niet op te geven
		run();
		run(11, 22, 33, 44, 55, 66, 77, 88, 99);

	}
	
	
	public static void jump(int start, int... numbers) {
		System.out.println("start= "+ start + " numberslength= "+ numbers.length);
	}
	
	public static void run(int... numbers) {
		for (int number : numbers) {
			System.out.println("number =" + number);
		}
		System.out.println(Arrays.toString(numbers));
	}	

}
