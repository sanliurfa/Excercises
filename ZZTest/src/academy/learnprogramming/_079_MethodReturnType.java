package academy.learnprogramming;

public class _079_MethodReturnType {

	public void jump() {};
	public void jump1() {
		return;				//Dit is redundant, dus niet nodig omdat de return type niet retourneert.
	};
	
	
	public String jump2 () {
		return "";			// Dit retourneert een lege String
	};
	
//	public String jump3 () {
//							// Dit compileert niet omdat er geen return is.
//	};	
	
//	public jump4() {};		// Dit compileert niet omdat er geen return TYPE aanwezig is.

	String jump6(int a) {
		if(a == 5) {
			return "";
		}
		
		return "";  		// Zonder deze return statement zou wanneer de if gedeelte een false oplevert, er geen return type meer zijn
							// hierom moet deze return er aanwezig zijn anders levert het een compilatie fout op.
	}
	
	int getInt() {
		return 9;
	}
	
	
	int getLong() {
		return (int)9L;			// Dit zal niet compileren wanneer er niet gecast wordt. omdat de return type een int is en er wordt een long geretourneert.
							// Het kan niet automatisch omgezet worden naar een int.
	}
	
	boolean isTrue() {
//		return 5 < 15;
		return 5 == 5;		// Omdat dit altijd boolean opleverd is het correct.
	}
	
	
	
	
	public static void main(String[] args) {
		
		

	}

}
