package oefeningen;

public class Oefening010CharArrays {

	public static void main(String[] args) {

		char[] arr = { 97, '\t', 'e', '\n', 'i', '\t', 'o' };
		for (char var : arr) {
			System.out.print(var);
		}
		System.out.print("\nThe length is :" + arr.length);
		System.out.println("\nDit is een nieuwe lijn \n\tEn dit is een nieuwe lijn en een nieuwe tab\ten nog en Tab");

	}

}
