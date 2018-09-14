package flowcontroledowhile;

public class DoWhile {

	public static void main(String[] args) {
		String [] table = {"aa", "bb", "cc"};
		int ii = 0;
		
		
		do {
			while(ii < table.length) {
				System.out.println(ii++);		// hier loopt het drie keer dus 0, 1, 2
			}
		} while (ii < table.length);			// omdat nu ii, drie geworden is kan het niet verder uitgevoerd zodat de uitslag 0, 1, 2 blijft.

		
	}

}
