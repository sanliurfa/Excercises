package _035methodoverloading;

public class FeetAndInches {

	public static void main(String[] args) {
		System.out.println(calcFeetAndInchesToCentimeters(13, 1));

	}
	
	
	public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
		 if (feet >= 0 & inches >= 0 & inches <= 12) {
			 double totalInches = inches + (feet / 12);
			 double cm = totalInches * 2.54;
			 return cm;
		 }
		return -1;
	}
	
	public static double calcFeetAndInchesToCentimeters(double inches) {
		 if (inches >= 0 & inches <= 12) {
			 double totalInches = inches;
			 double cm = totalInches * 2.54;
			 return cm;
		 }
		return -1;
	}	
	

}
