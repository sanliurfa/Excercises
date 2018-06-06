package academy.learnprogramming;

public class _128_ExamQuestionsExceptions {

	public static void main(String[] args) {
		
		// 1.
		// Wich of the following statements are true? (Choose all that apply)
		
		// A. Runtime exceptions are the same thing as checked exceptions.
		// B. Runtime exceptions are the same thing as unchecked exceptions.
		// C. You can declare only checked exceptions.
		// D. You can declare only unchecked exceptions.
		// E. You can handle only Exception subclasses.
		
		// Mijn antwoord:  B
		// Juite antwoord: B
		
		
		// 2.
		// Which of the following pairs fill in the blanks to make this code compile? (Choose all that apply)
		
		// 7: public void myMethod() _____ Exception {
		// 8: ____________ Exception();
		// 9: }
		
		
		// A. On line 7, fill in throw
		// B. On line 7, fill in throws
		// C. On line 8, fill in throw
		// D. On line 8, fill in throw new
		// E. On line 8, fill in throws
		// F. On line 8, fill in throws new
		
		// Mijn antwoord:  B, C
		// Juite antwoord: B, D

		
		// 3.
		// Which exception will the following throw? 
		
		// 7: Object obj = new Integer(3);
		// 8: String str = (String) obj;
		// 9: System.out.println(str);
		
		
		// A. ArrayIndexOutOfBoundsexception
		// B. ClassCastException
		// C. IllegalArgumentException
		// D. NumberFormatException
		// E. None of the above
		
		// Mijn antwoord:  E
		// Juite antwoord: B in regel 2 probeert men een Integer te casten naar een String
		//					Maar String extends niet van een integer dus kan men heet niet casten.
		
		// 4.
		// What will happen if you add te statement System.out.println(5/0); to a working main method? 
		
		// A. It will not compile
		// B. it will not run
		// C. It will run and throw an ArithmeticException
		// D. It will run and throw an IllegalArgumentException
		// E. None of the above
		
		// Mijn antwoord:  C
		// Juite antwoord: C
		//					
				
		// 5.
//		public class AnotherClass {
//			public void go() {
//				System.out.println("A");
//				try {
//					stop();
//				} catch (ArithmaticException e) {
//					System.out.println("B");
//				} finally {
//					System.out.println("C");
//				}
//				System.out.println("D");
//			}
//
//			public void stop() {
//				System.out.println("E");
//				Object x = null;
//				x.toString();
//				System.out.println("F");
//			}
//			public static void main(String[] args) {
//				new AnotherClass().go();
//			}
//			}
		
		// A. AE
		// B. AEBCD
		// C. AEC
		// D. AECD
		// E. No output appears other than the stack trace
		
		// Mijn antwoord:  B
		// Juite antwoord: C in Object x = null en x.toString() geeft het een nullpointerException en geen Arithmaticexception
		// 					finally word alrijd uitgevoerd en de rest niet dus de uitkomst word dan AEC
		//	
		
		
		
		// 6.
		// What is the output of the following snippet, assuming a  and b are both 0?
//		3: try {
//		4:	return a/b;
//		5: } catch (RuntimeException e){
//		6:	return -1;
//		7: } catch (ArithmeticException e) {
//		8: 	return 0;
//		9: } finally {
//		10:	System.out.println("done");
//		11: }
		// A. -1
		// B. 0
		// C. done-1
		// D. done0
		// E. The code does not compile
		// F. An uncaught exception is thrown. 
		
		// Mijn antwoord:  B
		// Juite antwoord: E ArithmaticException is een child class van Runtimeexception
		//					 Waardoor het niet compileert, de volgordr van catch moest andersom zijn.
		
		// 7.
		// What is the output of the following program?
//		1. public class Computer{
//		2. public void start() {
//		3.		try {
//		4.			System.out.println("Starting up ");
//		5.			throw new Exception();
//		6.		} catch (Exception e) {
//		7.			System.out.println("Problem ");
//		8.			System.exit(0);
//		9.		} finally {
//		10.			System.out.println("shutting down ");
//		11.		}
//		12.	}
//		13.	public static void main (String[] args) {
//		14.		new Computer().start();
//		15.	} }
		// A. Starting up
		// B. Starting up Problem
		// C. Starting up Problem Shutting down
		// D. Starting up Shutting down
		// E. The code does not compile
		// F. An uncaught exception is thrown. 
		
		// Mijn antwoord:  B
		// Juite antwoord: 
		//					
		
		// 8.
		// What is the output of the following program?
//		1. public class Cat{
//		2. public String name;
//		3. public void run() {
//		4. System.out.print("1");		
//		5.		try {
//		6.			System.out.print("2");
//		7.			name.toString();
//		8.			System.out.print("3");		
//		9.		} catch (NullPointerException e) {
//		10.			System.out.println("4");
//		11.			throw e;
//		12.		} 
//		13.			System.out.print("5");
//		14.		}
//		15.	public static void main (String[] args) {
//		16.		Cat jerry = new Cat();
//		17:		jerry.run();
//		18:		Sytem.out.print("6");		
//		19.	} }
		// A. 1
		// B. 2
		// C. 3
		// D. 4
		// E. 5
		// F. 6
		// G. The stack trace for a NullPointerException
		// Mijn antwoord:  124 A,B,D 
		// Juite antwoord: A,B,D en G
		//			
		
		// 9. Wich of the following statements are true? (Choose all that apply)
		// A. You can declare a method with Exception as the return type.
		// B. You can declare any subclass of Error in the throws part of a method declaration.
		// C. You can declare any subclass of Exception in the throws part of a method declaration.
		// D. You can declare any subclass of Object in the throws part of a method declaration.
		// E. You can declare any subclass of RuntimeException in the throws part of a method declaration.		
		// Mijn antwoord: A
		// Juite antwoord: A, B, C, E
		//			
		
		// 10. Wich of the following are unchecked  exceptions? (Choose all that apply)
		// A. ArrayIndexOutOfBoundsException
		// B. IllegalArgumentException
		// C. IOException
		// D. NumberFormatException
		// E. Any exception that extends RuntimeException
		// F. Any exception that extends Exception
		// Mijn antwoord: A, B, C, E
		// Juite antwoord: A, B, D, E
		//		
		
	}
	

	
	

}


