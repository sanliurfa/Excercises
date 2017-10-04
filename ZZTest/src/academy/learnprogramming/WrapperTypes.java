package academy.learnprogramming;

public class WrapperTypes {

	public static void main(String[] args) {
		int myInt = 10; 							//een primitieve int
		Integer myInteger = new Integer(10);		//een wrapper met inialisatie van 10,
													//hier wordt boxing gehanteerd een int wordt in een wrapper geplaatst
		Integer myInteger2 = 20;					// een wrapper met andere manier van inialisatie
		Integer myInteger3 = Integer.valueOf(10);	// een wrapper met valueof manier van inialisatie
		Integer myInteger4 = Integer.parseInt("3"); // een wrapper met parseInt van inialisatie dmv string
		
		//Integer zijn objecten en kunnen dus null zijn waarbij een int dit niet kan zijn.
		Integer myInteger5 = null;
		//int myInt2 = null;
		
		System.out.println("myInteger= " + myInteger );
		System.out.println("myInteger2= " + myInteger2 );
		System.out.println("myInteger3= " + myInteger3 );
		System.out.println("myInteger4= " + myInteger4 );
		System.out.println("myInteger5= " + myInteger5 );
		
		// int in een wrapper plaatsen > boxing
		// int uit een wrapper halen   > unboxing
		
		
		//converting wrapper to primitieve -> unboxing
		int myInt3 = myInteger3; //unboxing
		

	}

}
