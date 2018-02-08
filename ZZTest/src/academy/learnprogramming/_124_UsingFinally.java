package academy.learnprogramming;

public class _124_UsingFinally {

	public static void main(String[] args) {
		String[] array = new String[5];
		array[0] = "John";
		
		try {
			String element = firstToUpperCase(array);
			System.out.println("element= " + element);

		} catch (NullPointerException e) {
			System.out.println("Error message " + e.getMessage());
		} finally {
			System.out.println("finally block");
		}
		
		// De volgorde moet altijd try - catch - finally zijn
		// finally zal altijd uitgevoerd worden.
		
		// examenvraag wat zal worden geprint
		String str = "";
		try {
		//	int result = 10/0;
			str += "a";
		} catch (Exception e) {
			str += "b";
		} finally {
			str += "c";
		}
		
		str += "d";
		System.out.println(str);
		// Wanneer er geen catch gedaan wordt zal de uitkomst acd zijn
		// Wanneer er wel een catch wordt uitgevoerd dan zal de uitkomst bcd zijn
		// omdat str += a niet uitgevoerd zal worden.

	}

	public static String firstToUpperCase(String[] array) {
		return array[0].toUpperCase();
	}

}
