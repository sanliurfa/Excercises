package floatvalueof;

public class FloatValueOf {

	public static void main(String[] args) {
		Float f = null;
		try {
			f = Float.valueOf("12.3");
			String s = f.toString();
			int i = Integer.parseInt(s);         // Hier kan een string (Object) niet ge-parsed worden naar een primitive int
			System.out.println("" + i);
		} catch (Exception e) {
			System.out.println("trouble : " + f);
		}
	}

}
