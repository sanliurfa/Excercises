package arraysofemptystring;

public class ArraysOfEmptyString {

	public static void main(String[] args) {
		String [] arrays = new String[5];
		arrays[3]="nummer drie";
		
		for(String array : arrays) {
			System.out.println(array); // De resultaat van lege Array vanStrings is null want het zijn objecten!!!!
			
		}
		System.out.println("De resultaat van lege Array vanStrings is null want het zijn objecten!!!!");
	}

}
