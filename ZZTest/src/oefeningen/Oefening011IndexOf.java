package oefeningen;

public class Oefening011IndexOf {

	public static void main(String[] args) {
		String url="http://www.domain.com/index.html";
		if(url.indexOf("com")!=-1) //hier staat het woord com NIET NIET moet voorkomen (dus wel)
			System.out.println("Found");
	}

}
/*
 * Wat kan er bij de if ingevoerd worden?
 * url.indexOf("com")!=-1
 * url.indexOf("com")
 * url.indexOf("com")!==19
 * url.indexOf("com")!=false
 */
