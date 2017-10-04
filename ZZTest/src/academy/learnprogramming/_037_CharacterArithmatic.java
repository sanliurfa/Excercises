package academy.learnprogramming;

public class _037_CharacterArithmatic {

	public static void main(String[] args) {
		// char 0 - 65535
		char myCharA = 'A';
		char myCharNum = '1';
		
		System.out.println("myCharA= "+ myCharA);
		System.out.println("myCharA isLettter "+ Character.isLetter(myCharA));
		System.out.println("myCharA isDigit "+ Character.isDigit(myCharA));
		
		System.out.println("myCharNum= "+ myCharNum);
		System.out.println("myCharNum isLettter "+ Character.isLetter(myCharNum));
		System.out.println("myCharNum isDigit "+ Character.isDigit(myCharNum));

		//Exam questions
		
		char letter = 65; //A
		int myInt = letter + 3;
		char myNewLetter = (char)myInt;
		
		System.out.println("letter= "+ letter);
		System.out.println("myInt= "+ myInt);
		System.out.println("myNewLetter= "+ myNewLetter);
		
		// CHAR WORD AUTOMATISCH GECONVERTEERD NAAR INT, dus je moet het altijd casten naar char
		
		char myChar = 65; //A
		char newChar = (char)(myChar + 1);
		boolean b = newChar == 'B';
		boolean c = (newChar++ < 'D');
		
		System.out.println("myChar= " + myChar);
		System.out.println("newChar= "+ newChar);
		System.out.println("b= "+ b);
		System.out.println("c= "+ c);
		
		
	}

}
