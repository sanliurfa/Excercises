package parsefloatexception;

public class ParseFloat {

	public static void main(String[] args) {
		parseFloat("0.1");
	}

	public static float parseFloat(String s) {
		float f = 0.0f;
		try {
			f = Float.valueOf(s).floatValue();
			return f;
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid input " + s);
			f = Float.NaN;
			return f;
		} finally {
			System.out.println("finally");
		
		}
					
//		return f;				// Dit kan nooit uitgevoerd worden want na finally gebeurd er niets meer.
	
	}

}
