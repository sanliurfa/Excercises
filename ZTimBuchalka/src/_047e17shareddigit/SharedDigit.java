package _047e17shareddigit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedDigit {

	public static void main(String[] args) {
		System.out.println(hasSharedDigit(12, 23));
		System.out.println(hasSharedDigit(9, 99));
		System.out.println(hasSharedDigit(15, 55));
		System.out.println(hasSharedDigit(15, 15));
	}
	
	
	public static boolean hasSharedDigit(int number1, int number2) {
		
		if (number1 < 10 || number2 < 10 || number1 > 99 || number2 > 99) {
			return false;
		}
		
		

//		
//		
		
		int firstDigit1 = 0;
		int firstDigit2 = 0;
		int lastDigit1 = number1 % 10;
		int lastDigit2 = number2 % 10;
		int [] list1 = new int[10];
		int [] list2 = new int[10];
		 
		
		
		
		for (int i = 0, j = 0; i < number1 ; i/=10, j++) {
			firstDigit1 = number1 % 10;
			list1[j]=firstDigit1;
			number1 /= 10;
		}
		
		for (int i = 0, j = 0; i < number2 ; i/=10, j++) {
			firstDigit2 = number2 % 10;
			list2[j]=firstDigit2;
			number2 /= 10;
		}
		

	    if (list1==list2)
	        return true;
	    if (list1==null || list2==null)
	        return false;

	    int length = list1.length;
	    if (list2.length != length)
	        return false;

	    for (int i=0; i<length; i++) {
	        Object o1 = list1[i];
	        Object o2 = list2[i];
	        if (!(o1==null ? o2==null : o1.equals(o2)))
	            return false;
	    }

	    return true;
//		
//		
//		if (Arrays.equals(list1, list2)) {
//			return true;
//		}
//		return false;
//		
	}

}
