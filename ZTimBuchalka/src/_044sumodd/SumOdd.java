package _044sumodd;

public class SumOdd {

	static int sum = 0;

	public static void main(String[] args) {
		System.out.println(sumOdd(1, 100));
		System.out.println(sumOdd(-1, 100));
		System.out.println(sumOdd(100, 100));
		System.out.println(sumOdd(100, -100));
		System.out.println(sumOdd(100, 1000));
	}

	public static boolean isOdd(int number) {
		if (number < 0 || (number % 2 == 0) ) {
			return false;
		} else {
			return true;
		}
	}

	public static int sumOdd(int start, int end) {

//		if (start > 0 || end > 0 || end >= start) {
//
//			for (int i = start; i < end; i++) {
//				if (isOdd(i)) {
//					sum = sum + i;
//
//				} else {
//					continue;
//				}
//			}
//
//		} else {
//			return -1;
//		}
//		return sum;

		if(start < 0 || end < 0 || start > end) {
			return -1;
		}
		
		int sum = 0;
		
		for (int i = start; i <= end; i++) {
			if (isOdd(i)) {
				sum += i;
			
		}
		}
		return sum;
	}
}
