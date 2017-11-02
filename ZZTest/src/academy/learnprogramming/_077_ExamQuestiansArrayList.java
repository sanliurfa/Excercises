package academy.learnprogramming;

public class _077_ExamQuestiansArrayList {

	public static void main(String[] args) {
		// Which of the compile when replacing line 8? (Choose all that apply)
		/**
		 * 7: ArrayList I = new ArrayList();
		 * 8: // Insert code here
		 *
		 * A. int length = I.capacity;
		 * B. int length = I.capacity();
		 * C. int length = I.length;
		 * D. int length = I.length();
		 * E. int length = I.size;
		 * F. int length = I.size();
		 * G. None of the above
		 * 
		 * Mijn antwoord: B, F 
		 * Juist antwoord: F => ArrayList kent alleen de methode size()
		 */
		
		/**
		 * Wich of the following is true
		 * 
		 * A. An array has a fixed size
		 * B. An ArrayList has a fixed size
		 * C. An array allows multiple dimensions
		 * D. An array is ordered
		 * E. An ArrayList is ordered
		 * F. An array is immutable
		 * G. An ArrayList is immutable
		 * 
		 * Mijn antwoord: A, C
		 * Juist antwoord: A, C, D, E =>  D en E zijn juist omdat ordered betekent dat de elementen op volgorde staan als wanneer
		 * 								  zij ingevoerd zijn.
		 */
		
		/**
		 * Which of the following are true (choose all that apply)
		 * 
		 * A. Two arrays with the same content are equal
		 * B. Two Arraylists with the same content are equal
		 * C. If you call remove(o) using an ArrayList object, it will compile successfully
		 * D. If you call remove(o) using an ArrayList object, it will run successfully
		 * E. None of the above
		 * 
		 *  Mijn antwoord: C, D
		 *  Juist Antwoord: B, C => ?? B ArrayLists heeft een equal methode terwijl bij array de gelijkheid moet aangtoond worden door == operater
		 *  						   C De compiler kan alleen onder runtime vaststellen dat een Arraylist leeg is.
		 *  
		 */
		
		/**
		 * What is the result of the following statement
		 * 6:  List<String> list = new ArrayList<String>();
		 * 7:  list.add("one");
		 * 8:  list.add("two");
		 * 9:  list.add(7);
		 * 10: for(String s : list) System.out.print(S);
		 * 
		 * A. onetwo
		 * B. onetwo7
		 * C. onetwo followed by an exception
		 * D. Compiler error on line 9
		 * E. Compiler errror on line 10
		 * 
		 * Mijn antwoord: C
		 * Juist antwoord: D Voordat het in runtime komt moet het compileren, Bij het compileren krijgt het een exception in regel 9.
		 */
		
		/**
		 * What is the result of the following statement
		 * 3:  List<Integer> nums = new ArrayList<>();
		 * 4:  list.add(4);
		 * 5:  list.add(5);
		 * 6:  list.set(1, 6);
		 * 7: nums.remove(o);
		 * 8: for(Integer v : nums)System.out.print(v);
		 * 
		 * 
		 * A. 4
		 * B. 5
		 * C. 6
		 * D. 46
		 * E. 45
		 * F. An exception is thrown
		 * G. The code does not compile
		 * 
		 * Mijn antwoord: C
		 * Juist antwoord: C
		 */
		
		/**
		 * What is the result of the following statement
		 * 
		 * 4:  List<Integer> list= Arrays.asList(10, 4, -1, 5);
		 * 5:  Collection.sort(list);
		 * 6:  Integer array[] = list.toArray(new Integer[4]);
		 * 7:  System.out.println(array[0]); 
		 * 
		 * A. -1
		 * B. 10
		 * C. Compile error on line 4
		 * D. Compile error on line 5
		 * E. Compile error on line 6
		 * F. An exception is thrown
		 * G. The code does not compile
		 * 
		 * Mijn antwoord: A
		 * Juist antwoord: A
		 */

		/**
		 * What is the result of the following statement
		 * 
		 * 6:  String[] names = {"Tommy", "Mike", "Anthony"};
		 * 7:  List<String> list = names.asList();
		 * 8:  list.set(0, "Tom");
		 * 9:  System.out.println(names[0]); 
		 * 
		 * A. Tom
		 * B. Tommy
		 * C. Compile error on line 7
		 * D. Compile error on line 8
		 * E. An exception is thrown
		 * 
		 * Mijn antwoord: A
		 * Juist antwoord: C => names wordt als een Array aangemaakt. Array heeft geen methode asList();
		 */		
		
		/**
		 * What is the result of the following statement
		 * 
		 * 6:  List<String> one = new ArrayList<String>();
		 * 7:  one.add("abc");
		 * 8:  List<String> two = new ArrayList<String>();
		 * 9:  one.add("abc");
		 * 10: if(one == two)
		 * 11: System.out.println("A");
		 * 12: else if (one.equals(two))
		 * 13: System.out.println("B");
		 * 14: else  System.out.println("C");
		 * 
		 * A. A
		 * B. B
		 * C. C
		 * D. An exception is thrown
		 * E. The code doesn't compile
		 * 
		 * Mijn antwoord: B
		 * Juist antwoord: B
		 */	
		
		/**
		 * Which of the following are true statement about the following code? (Choose all that apply)
		 * 
		 * 4:  List<Integer> ages = new ArrayList<>();
		 * 5:  ages.add(Integer.parseInt("5");
		 * 6:  ages.add(Integer.valueOf("6");
		 * 7:  ages.add(7);
		 * 8:  ages.add(null);
		 * 9:  for (int age : ages) System.out.print(age);

		 * 
		 * A. The code compiles 
		 * B. The code throws a runtime exception
		 * C. Exactly one of the add statement uses autoboxing
		 * D. Exactly two of the add statement use autoboxing
		 * E. Exactly three of the add statement use autoboxing
		 * 
		 * Mijn antwoord: B
		 * Juist antwoord: A, B en D => 5, 6 en 7 gebruikt autoboxing. parseInt converteerd een waarde naar een integer primitive, valueOf
		 * 								converteert een waarde naar een Wrapper. 
		 * 								In regel 9 wordt een loop gebruikt en hierin wordt eer unboxing toegepast, dus het automatisch
		 * 								omzetten van een wrapper naar een int, alleen een null waarde kan niet ge-unboxed worden! Hier geeft het een 
		 * 								exception. 
		 */	
		
		/**
		 * What is the output of the following code?
		 * 
		 * 1:  import java.util.*;
		 * 2:  class JavaList{
		 * 3:  public static void main(String args[]){
		 * 4:  ArrayList<String> myList = new ArrayList<>();
		 * 5:  myList.add("one");
		 * 6:  myList.add("Two");
		 * 7:  System.out.println(myList.contains(new String("One")));
		 * 8:  System.out.println(myList.IndexOf("Two"));
		 * 9:  myList.clear();
		 * 10: System.out.println(myList);
		 * 11: System.out.println(myList.get(1)));}}
		 * 
		 * A. Line 7 prints true
		 * B. Line 7 prints false
		 * C. Line 8 prints -1
		 * D. Line 8 prints 1
		 * E. Line 9 removes all elements of the list myList
		 * F. Line 9 sets the list myList to null
		 * G. Line 10 prints null
		 * H. Line prints []
		 * I. Line 10 prints a value similar to ArrayList@16356
		 * K. Line 11 throws an exception
		 * Line 11 prints null
		 * 
		 * Mijn antwoord: B
		 * Juist antwoord: A, B en D => 5, 6 en 7 gebruikt autoboxing. parseInt converteerd een waarde naar een integer primitive, valueOf
		 * 								converteert een waarde naar een Wrapper. 
		 * 								In regel 9 wordt een loop gebruikt en hierin wordt eer unboxing toegepast, dus het automatisch
		 * 								omzetten van een wrapper naar een int, alleen een null waarde kan niet ge-unboxed worden! Hier geeft het een 
		 * 								exception. 
		 */	
		

	}

}
