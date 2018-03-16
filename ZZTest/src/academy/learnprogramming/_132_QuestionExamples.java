package academy.learnprogramming;

public class _132_QuestionExamples {

}

// 1. 
// What is the result of the following class?

//1. import java.util.function.*;
//2.
//3. public class Cat {
//4.  int age;
//5.	public static void main(String[] args) {
//6. 		Cat c1 = new Cat;
//7.		c1.age= 1;
//8. 		check(c1, c -> c.age < 5);
//9. 	}
//10.   private static void check(Cat cat, Predicate<Cat> pred) {
//11.  String result = pred.test(cat) ? "match" : "not match";
//12. System.out.print(result);
//13.  }}

// A. match
// B. not match
// C. Compiler error in line 8.
// D. Compiler error in line 10.
// E. Compiler error in line 11.
// F. A runtime exception is thrown

// Mijn antwoord:  
// Juiste antwoord: A 
// 					
//	

//2. 
//What is the result of the following code?

//1. interface Jump{
//2. boolean isTooHigh(int height, int limit);
//3. }
//4.  
//5. public class Jumper{
//6. public static void main(string[] args){
//7. check((h, l) -> h.append(l).isEmpty(), 5);
//8. } 
//9. private static void check(Jump Jump, int height) {
//10. if (jump.istTooHigh(height, 10))
//11.  System.out.println("too high");
//12. else
//13.  System.out.println("ok");
//13.  }
//14. }

//A. ok
//B. too high
//C. Compiler error in line 7.
//D. Compiler error in line 10.
//E. Compiler error on a different line.
//F. A runtime exception is thrown

//Mijn antwoord:  
//Juiste antwoord: A 
//					
//	
