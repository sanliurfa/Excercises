package flowcontrolternary;

public class TernaryNotStatement {

	public static void main(String[] args) {
		//(5000 > 2000)? 15 : 10;  // Dit werkt niet omdat het een statement zijn.
		
		
		int bill = 2000;
		int qty = 10;
		int days = 10;
		int discount = (bill > 1000)? 
				((qty > 11)? 10 : 
			                   (days > 9? 20 : 30)) 
			                        : 5;
		System.out.println(discount);
	}

}
