package auto;

import voertuigen.*;

public class Auto extends Vierwielers{

	public static void main(String[] args) {
	
	Auto auto1 = new Auto();
	System.out.println(auto1.banden);
	
	Vierwielers auto2 = new Auto();
	System.out.println("Je kan wel een object maken van de type Vierwieler maar niet bij de variabele komen");
	
	Vierwielers auto3 = new Vierwielers();
	System.out.println("Je kan wel een object maken van de type Vierwieler maar niet bij de variabele komen");

	}

}
