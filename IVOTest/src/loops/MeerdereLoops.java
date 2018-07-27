package loops;

public class MeerdereLoops {

	public static void main(String[] args) {
		int j=0, k=0;
		for (int i = 0; i < 2; i++) {			// de buitenste loop is voor het aantal rijen 
			do {
				k=0;
				while(k<4) {					// De binnenste loop is de loop van de aantal kolommen 0 > 1 > 2 > 3 dus vier kolommen
					k++;
					System.out.print(k+" " );
				}
				System.out.println(" ");
				j++;
			} while (j<3);
			System.out.println("----");
		}

	}

}


/**
 * 1 2 3 4
 * 1 2 3 4 
 * 1 2 3 4 
 * ----
 * 1 2 3 4
 * ----
 * 
 * Vraag:
 * Wat moet de waarden van x, y, en  z zijn om de bovenstaande gegevens te krijgen
 * 
 * iteratie	 	i<x		k<z -> K++		j<y
 * 0			0			1			1
 * 1			0			2			2
 * 2			0			3			3	
 * 3			0			4
 * 4
 * 5
 * 
 */
