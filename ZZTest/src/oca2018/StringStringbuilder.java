package oca2018;

public class StringStringbuilder {

	public static void main(String[] args) {
		String string= "DitIsEen String";
		StringBuilder sb = new StringBuilder();
		sb.append("DitIsEen Stringbuiler");
		
		System.out.println("concat "+ string.concat("concat"));
		System.out.println("índexof " + string.indexOf('s'));  // index of indexeert beginnend met 0
		
	}

}
