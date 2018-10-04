package e009equalityprinter;

public class EqualityPrinter {

	public static void main(String[] args) {
		printEqual(1, 1, 1);
		printEqual(1, 1, 2);
		printEqual(-1, -1, -1);
		printEqual(1, 2, 3);
		printEqual(2, 1, 1);

	}
	
	public static void printEqual(int par1, int par2, int par3) {
		if (par1 < 0 || par2 < 0 || par3 < 0) {
			System.out.println("Invalid Value");
		} else if (par1 == par2 && par1 == par3 ) {
			System.out.println("All numbers are equal");
		} else if (par1 != par2 && par1 != par3 && par2 != par3) {
			System.out.println("All numbers are different");
		} else {
			System.out.println("Neither all are equal or different");
		}
	}
	
	
	

}
