package academy.learnprogramming;

public class _029_UnaryOperators {

	public static void main(String[] args) {
		// ! (not) zal niet compileren bij primitieven oftewel getallen
		// - (min) zal niet compileren bij booleans.
		
		//int myInt = !5; // zal niet compileren
		// boolean z = -true // zal niet compileren
		// boolean z = !0 // zal dus niet compileren
		
		// increment en decrement hebben een hogere rangorde dan (*, /, +, - enz)
		
		// exam questions
		int e = 3;
		int f = ++e * 5 / e-- + --e;
		// e= 3
		// 4 * 5 / e-- + --e; -> ++e -> ++3 -> e=4
		// 4 * 5 / 4 + --e; -> e=4 -> e-- -> e = 3
		// 4 * 5 / 4 + 2; -> --e -> --3 -> e=2
		// 20 / 4 + 2
		// 5 + 2
		// 7
		
		System.out.println("e= "+ e + " f= "+ f);
		
		int g = 6;
		int h = 2;
		int i = ++h + --g * 3 + 2 * g++ - h-- % --g;
		
		// 3 + --g * 3 + 2 * g++ - h-- % --g; -> ++h -> ++2 -> h = 3
		// 3 + 5 * 3 + 2 * g++ - h-- % --g; -> --g -> --6 -> g = 5
		// 3 + 5 * 3 + 2 * 5 - h-- % --g; -> g = 5 -> g++ -> 5++ -> g = 6
		// 3 + 5 * 3 + 2 * 5 - 3 % --g; -> h = 3 -> h-- -> h = 2
		// 3 + 5 * 3 + 2 * 5 - 3 % 5; g = 6 -> --g -> g= 5 -->!!!! 3 % 5 want 3 / 5 = 0 rest 3 !!!!
		// 3 + 5 * 3 + 2 * 5 - 3
		// 3 + 15 + 10 - 3
		// 25
		
		System.out.println("g= "+ g + " h= " + h + " i= " + i);

	}

}
