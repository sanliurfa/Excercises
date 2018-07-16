package naam;

public class SplitNaam {

	public static void main(String[] args) {
		String fullName = "Jansen - Berendsen";
		
		SplitNaam testNaam = new SplitNaam();
		String firstName = getFirstName(fullName);
		String lastName = getLastName(fullName);

		
		System.out.println(firstName + " - " + lastName);
	}
	
	
	private static String getFirstName(String fullName) {
	    int index = fullName.lastIndexOf("-");
	    if (index > -1) {
	        return fullName.substring(0, index);
	    }
	    return fullName;
	}

	private static String getLastName(String fullName) {
	    int index = fullName.lastIndexOf("-");
	    if (index > -1) {
	        return fullName.substring(index + 1 , fullName.length());
	    }
	    return "";
	}

}


