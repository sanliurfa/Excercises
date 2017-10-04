package academy.learnprogramming;

public class _043_DoWhileLoop {

	public static void main(String[] args) {
		int x=20;
		while (x > 10) x--;					// dit is zonder accolades genoteerd! op een regel.
			System.out.println("x= " + x);  
		
			
			
			int x2 = 20;
			
			do x2--;
			while (x2 > 10);
			
			System.out.println("x2= " + x2);
			
			int y = 10;
			int z = 5;
			while ( y < 20)
				y++;				// wanneer er geen accolades gebruikt wordt dan geldt alleen de eerste statement bij de while loop
									// dus de hierna onderstaande hoort niet bij de while loop 
									// dus y wordt opgehoogt tot 20
				z+=2;				// z wordt verhoogd met 2, dus z= 7
									// y word dus 20 + 10 = 30
				y +=10;
				
				System.out.println("x= "+ x + " y= " + y + " z= " + z);
				
				
				int number = 10;
				
				while(number > 10){		// dit while loop zal nooit uitgevoerd worden omdat number nooit groter zal zijn dan 10
					number--;
				}
										// vervolgens zal de wo while inwerking treden,
				do{ 
					number--;			// number wordt hier 9 (eerst uitvoer en dan 
				
					while (number > 5){
						number += 1;
										// na dit lijn zal number 1 erbij opgeteld worden en zal 10 worden
					} 					// vervolgens zal er weer een controle uitgevoerd worden of de number < dan 10 is
				}while (number > 10); 	// dus zal het in een invinitive loop komen tussen 9 en 10

				
				System.out.println("number = "+ number);
				
				}
		
	}


