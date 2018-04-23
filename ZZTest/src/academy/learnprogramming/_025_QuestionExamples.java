package academy.learnprogramming;

public class _025_QuestionExamples {
	
	// 1. Wich off the following are valid java Identifiers? (Choose all that apply)
	// 
	// A. A$B
	// B. _hello
	// C. false
	// D. java.util
	// E. Public
	// F. 19_abs
	
	// Mijn antwoord: A, B. 
	// Juiste antwoord: A, B en E > E is goed omdat Public met een hoofdletter geen keyword is. Public met een kleine
	//                              daarintegen wel. D is Niet goed omdat er een punt in zit.
	//
	
	
	// 2. Wich off the following are true? (Choose all that apply)
	// 
	// 4: short myPets= 5;
	// 5: int myNumber= 5.6;
	// 6: String theString= "Scruffy";
	// 7: myPets.length();
	// 8: myNumber.length();
	// 9: theString.length();
	//
	// A. Line 4 generates a compile error
	// B. Line 5 generates a compile error
	// C. Line 6 generates a compile error
	// D. Line 7 generates a compile error
	// E. Line 8 generates a compile error
	// F. Line 9 generates a compile error
	// G. The code compile as is
	
	// Mijn antwoord: B. 
	// Juiste antwoord: B, D, en E > D, E > Je kan geen methode aanroepen van een variabele met Primitives
	//                               String is een object, hierdoor kan je length wel aanroepen
	
	//	
	
	// 3. What is the output off the following program?
	// 
	// class WaterTank {
	//  private String brand;
	//  private boolean empty;
	// 
	// public static void main(String[] args){
	//  WaterTank wb = new WaterTank();
	//  System.out.print("Empty= " wb.empty); //prints false
    //  System.out.print("Brand= " wb.brand); //prints null
	//
	// A. Line 6 generates a compile error
	// B. Line 7 generates a compile error
	// C. There is no output
	// D. Empty = false, Brand = null
	// E. Empty = false, Brand = 
	// F. Empty = null, Brand = null
	
	// Mijn antwoord: E. 
	// Juiste antwoord: D > Alle objecten hebben de default waarde van null, String is een object dus krijgt het null.
	//	
	
	// 4. Wich off the following are legal entry points that can be run from the command line? (Choose all that apply)
	// 
	// A. private static void main(String[] args)
	// B. public static final main(String[] args)
	// C. public void main(String[] args)
	// D. public static void test(String[] args)
	// E. public static void main(String[] args)
	// F. public static main(String[] args)
	// G. None of the above
	
	// Mijn antwoord: E
	// Juiste antwoord: E >
	//                     
	//
		
	// 5. Given the following classes, what is the maximum numbers of imports that can 
	//    be removed and have the code still compile?
	// 
	// package company; public class Employee{}
	// package company;
	// import java.lang.*;
	// import java.lang.System;
	// import company.Employee;
	// import company.*;
	// public class Company{
	//  public void print(Employee employee) {
	//  System.out.printnl(employee);}}
	//
	// A. 0
	// B. 2
	// C. 3
	// D. 4
	// E. Does not compile 
	
	// Mijn antwoord: D
	// Juiste antwoord: E > Beide classes zitten in de zelfde package dus er hoft geen import uitgevoerd te worden.
	//	                    java.lang wordt automatisch geimporteerd
		
	// 6. Wich off the following are true? (Choose all that apply)
	// 
	// A. A local variabele off the type boolean defaults to null.
	// B. A local variabele off the type float defaults to 0.
	// C. A local variabele off the type Object defaults to null.
	// D. A local variabele off the type boolean defaults to false.
	// E. A local variabele off the type boolean defaults to true.
	// F. A local variabele off the type float defaults to 0.0.
	// G. None of the above
	
	// Mijn antwoord: C, D, F
	// Juiste antwoord: G > Een local variabele moet altijd geinitialiseerd worden en heeft dus geen default waarde!!!!
	//                     
	//	

	// 7. Given the following class, which of the following lines of code can replace INSERT CODE HERE 
	//    to make the code compile? (Choose all that apply)
	// 
	// public class Price{
	// public void addmission() {
	// INSERT CODE HERE
	//  System.out.printnl(amount);
	// }}
	//
	// A. int amount = 9L;
	// B. int amount = 0b101;
	// C. int amount = 0xE;
	// D. double amount = 0xE;
	// E. double amount = 1_2_.0_0;
	// F. int amount = 1_2_;
	// G. None of the above
	
	// Mijn antwoord: B, D, E, F
	// Juiste antwoord: B, C, D > B is goed 0b is een prefix voor binary number
	//                            C is goed 0x is een prefix voor hexadecimale numbers hierdoor is D ook goed
	//                            E is fout omdat er een ondescoor voor een punt wordt gebruikt.
	//	                          F is niet goed omdat undescoor is de laatste character, dit mag niet.
	
	// 8.. Wich off the following are true statements? (Choose all that apply)
	// 
	// A. Java allows operator overloading
	// B. Java code compiled on windows can run on linux
	// C. Java has pointers to specific locations in memory
	// D. Java is procedural language
	// E. Java is an object oriented language
	// F. Java is a functional programming language
	
	// Mijn antwoord: E
	// Juiste antwoord: B, E > B> wanneer eenmaal gecomileerd is kan het op alle platformen gedraaid worden.
	//                     
	//	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
