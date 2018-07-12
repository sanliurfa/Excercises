package oefeningen;

public class Oefening002Loops {


	public static void main(String[] args) {
		int j = 0, k = 0;
		
		for (int i = 0; i < 2; i++) {
			do {
				k=0;
				while (k < 4) {
					k++;
					System.out.print(k+ " ");
				}
				System.out.println(" ");
				j++;
			} while (j < 3);
			System.out.println("-----");
			
		}

	}

}
