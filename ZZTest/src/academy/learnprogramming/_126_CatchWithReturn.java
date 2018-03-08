package academy.learnprogramming;

public class _126_CatchWithReturn {

	public static void main(String[] args) {
		// finally wordt Altijd uitgevoerd behalve wanneer er een System.exit uitgevoerd wordt
		
		System.out.println(calculate());
		
		
	}
	
	public static int calculate() {
		try {
			System.exit(0);  // system.exit zorgt hier voor dat er niets uitgevoerd wordt
							// dit word op verschillende plekken op de examen gevraagd, dus in de catch of in finally
			return 10/0;
		} catch (Exception e) {
			System.out.println("error");
			return 1;
		} finally {
			System.out.println("finally");
			return 0;
		}
		
	}

}
