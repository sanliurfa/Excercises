package _047e18lastdigitchecker;

public class LastDigitChecker {

	public static void main(String[] args) {
		System.out.println(hasSameLastDigit(41, 22, 71));
		System.out.println(hasSameLastDigit(23, 32, 42));
		System.out.println(hasSameLastDigit(9, 99, 999));
		System.out.println(hasSameLastDigit(22, 23, 34));

	}

	public static boolean hasSameLastDigit(int a, int b, int c) {

		if (a < 10 || b < 10 || c < 10 || a > 1000 || b > 1000 || c > 1000) {
			return false;
		}
		
		int aDigit = a % 10;
		int bDigit = b % 10;
		int cDigit = c % 10;
		if (aDigit == bDigit || aDigit == cDigit || bDigit == cDigit) {
			return true;
		}
		
		
		
//		for (int i = a; i > 0; ) {
//			int aDigit = i % 10;
//			for (int j = b; j > 0;) {
//				int bDigit = j % 10;
//				for (int k = c; k > 0;) {
//					int cDigit = k % 10;
//					if (aDigit == bDigit || aDigit == cDigit || bDigit == cDigit) {
//						return true;
//					}
//				}
//			}
//		}
		return false;
	}
}