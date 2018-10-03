package e007areacalc;

public class AreaCalculator {

	public static void main(String[] args) {
		
		System.out.println(area(5.0));
		System.out.println(area(-1));
		System.out.println(area(5.0 , 4.0));
		System.out.println(area(-1, 4.0));

	}
	
	public static double area(double radius) {
		double circleArea = 0;
		if(radius < 0) {
			return -1.0;
		}
		circleArea = Math.PI * radius * radius;
		return circleArea;
	}
	
	public static double area(double x, double y) {
		double rectangleArea = 0;
		if(x < 0 || y < 0) {
			return -1.0;
		}
		rectangleArea = x * y;
		return rectangleArea;
	}
	
	
		
	

}
