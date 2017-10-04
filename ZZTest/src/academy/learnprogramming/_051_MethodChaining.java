package academy.learnprogramming;

public class _051_MethodChaining {

	public static void main(String[] args) {
		String start= " Java ";
		
		// Eerst trimmen
		String trimmed = start.trim();
		System.out.println("trimmed= " + trimmed);
		
		// Hierna kleine letters
		String lowerCase = trimmed.toLowerCase();
		System.out.println("lowercase= " + lowerCase);
		
		// eerste letter weer hoofdletter en resultaat tonen
		String result = lowerCase.replace("j", "J");
		System.out.println("result= " + result);
		
		// Je kan dit alles in een regel chainen
		String anotherResult = " Java ".trim().toLowerCase().replace('j', 'J');
		System.out.println("anotherResult= " + anotherResult);
		System.out.println(result.equals(anotherResult));
		
		
		String a = "abc";
		String b = a.toUpperCase(); // string is immutable dus dit is een nieuwe string
		String c = b.replace('B', 'b').replace('C', 'c');
		System.out.println("a= "+ a);
		System.out.println("b= "+ b);
		System.out.println("c= "+ c);
		
		if (a.equalsIgnoreCase(b)){
			System.out.println("Strings are equal");
		}
		
		if(a.toLowerCase().trim().equals(b.toLowerCase().trim())){
			System.out.println("Equal");
		}
	}

}
