package codeeroefening.leapyear;

public class LeapYear {

	public static void main(String[] args) {
		System.out.println(isLeapYear(-1600));
		System.out.println(-1600 % 4);
		System.out.println(-1600 % 400);
		System.out.println(-1600 % 100);
		System.out.println(isLeapYear(1600));
		System.out.println(1600 % 4);
		System.out.println(1600 % 400);
		System.out.println(1600 % 100);		
		System.out.println(isLeapYear(2017));
		System.out.println(2017 % 4);
		System.out.println(2017 % 400);
		System.out.println(2017 % 100);	
		System.out.println(isLeapYear(2000));
		System.out.println(2000 % 4);
		System.out.println(2000 % 400);
		System.out.println(2000 % 100);	
		System.out.println(isLeapYear(1924));
		System.out.println(1924 % 4);
		System.out.println(1924 % 400);
		System.out.println(1924 % 100);
		
		

	}

	public static boolean isLeapYear(int year) {

		if (year >= 1 && year <= 9999) {
			if ((year % 4 == 0 & year % 100 != 0 )| year % 400 == 0 ) {
				return true;

			}

		}
		return false;
	}

}
