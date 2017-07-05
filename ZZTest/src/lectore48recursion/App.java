/**
 * 
 */
package lectore48recursion;

/**
 * @author ro-goki
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int value = 5;
		
		System.out.println(factorial(value));
		
		
		/*
		 * een factorial number is een nummer die recursief met zichzelf vermunigvuldigt
		 * en iedere keer met -1 dalend voorbeeld = 4! > 4*3*2*1 
		 */
		
		
	}
	
	private static int factorial(int value){
		System.out.println(value);
		
		if (value == 1){
			return 1;
		}
		
		return factorial(value - 1)* value;
		//calculate(value);  // Dit is recursie het roept zichzelf weer aan!
							// dit geeft een stackoverflow want het zit in een infinite loop
							// je moet hierom een controle inbouwen met een if statement
	}

}
