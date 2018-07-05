package oca2018;

public class BoleaanParse {

	public static void main(String[] args) {

		System.out.println("Boolean.parseBoolean(null):" + Boolean.parseBoolean(null));
		System.out.println("Boolean.parseBoolean(\"True\"):" + Boolean.parseBoolean("True"));
		System.out.println("Boolean.parseBoolean(\"false\"):" + Boolean.parseBoolean("false"));
		System.out.println("Boolean.parseBoolean(\"yes\"):" + Boolean.parseBoolean("yes"));
//		System.out.println("Boolean.parseBoolean(null):" + Boolean.parseBoolean(0)); // Je kan geen int in een boleaan parsen
		
		System.out.println();
		
	    System.out.println("Boolean.valueOf(null):" + Boolean.valueOf(null));
	    System.out.println("Boolean.valueOf(\"True\"):" + Boolean.valueOf("True"));
	    System.out.println("Boolean.valueOf(\"false\"):" + Boolean.valueOf("false"));
	    System.out.println("Boolean.valueOf(\"yes\"):" + Boolean.valueOf("yes"));
	    
	    System.out.println();
	    
	    System.out.println("Boolean.getBoolean(null):" + Boolean.getBoolean(null));
	    System.out.println("Boolean.getBoolean(\"True\"):" + Boolean.getBoolean("True"));
	    // set system property
	    System.setProperty("booleanProp", "true");
	    System.out.println("System.setProperty(\"booleanProp\", \"true\"):" + Boolean.getBoolean("booleanProp"));

	    System.setProperty("booleanProp", "TrUe");
	    System.out.println("System.setProperty(\"booleanProp\", \"TrUe\"):" + Boolean.getBoolean("booleanProp"));

	    System.setProperty("booleanProp", "false");
	    System.out.println("System.setProperty(\"booleanProp\", \"false\"):" + Boolean.getBoolean("booleanProp"));
		
	}
}
