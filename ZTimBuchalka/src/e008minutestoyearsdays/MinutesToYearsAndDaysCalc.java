package e008minutestoyearsdays;

public class MinutesToYearsAndDaysCalc {

	public static void main(String[] args) {
		printYearsAndDays(1051200);

	}
	
	
	public static void printYearsAndDays(long minutes) {
		
		long years = 0;
		long days = 0;
		long hours = 0;
		
		
		if (minutes< 0) {
			System.out.println("Invalid Value");
		}
		
		years = minutes % 525600;
		System.out.println(years);
		
	}
	

}
