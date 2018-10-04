package e008minutestoyearsdays;

public class MinutesToYearsAndDaysCalc {

	public static void main(String[] args) {
		printYearsAndDays(-561600);

	}
	
	
	public static void printYearsAndDays(long minutes) {
		
		long years = 0;


		long remainingDays = 0;
		
		if (minutes< 0) {
			System.out.println("Invalid Value");
		} else {
		
		years = minutes / 525600;

		remainingDays = (minutes - (years*525600)) / 1440;

		System.out.println(minutes + " min = " +years +  " y and " + remainingDays + " d");
		} 
	}
	

}
