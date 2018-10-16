package _047e14numberpalindrome;

public class NumberPalindrome {

	public static void main(String[] args) {
	
		System.out.println(isPalindrome(-1221));
		System.out.println(isPalindrome(707));
		System.out.println(isPalindrome(11212));
		System.out.println(isPalindrome(-222));
		
	}
	
	public static boolean isPalindrome(int number) {
	String original, reverse = "";


	original = Integer.toString(Math.abs(number));

	int length = original.length();
	for (int i = length - 1; i >= 0; i--) {
		reverse = reverse + original.charAt(i);
	}
	if (original.equals(reverse)) {
		return true;
	}
	return false;

}

}
