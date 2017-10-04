package academy.learnprogramming;

public class _031_AssignmentOperators {

	public static void main(String[] args) {
		byte myByte = 127;
		byte mySecondByte = -128;
		
		System.out.println("myByte = "+ myByte);
		System.out.println("mySecondByte = "+ mySecondByte);
		
		//myByte = myByte + 1; --> Dit werkt niet omdat door + 1 de antwoord altijd een int is.
		myByte++; // dit werkt wel
		
		//mySecondByte = mySecondByte -1; --> Dit werkt niet omdat door - 1 de antwoord altijd een int is.
		mySecondByte--; // dit werkt wel
		
		System.out.println("myByte = "+ myByte);
		System.out.println("mySecondByte = "+ mySecondByte);

	}

}
