/**
 * 
 */

/**
 * @author ro-goki
 *
 */
public class MyLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] sa = {"tom","jerry"};
		for (int i = 0; i < 3; i++) {
			for (String s: sa){
				System.out.println(i+" "+s);
				if (i == 1)break;
			}
			
		}

	}

}
