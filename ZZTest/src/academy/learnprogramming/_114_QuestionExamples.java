package academy.learnprogramming;

public class _114_QuestionExamples {
	
	// 1.
	//	What modifier are implicitly applied to all interface methods? (Choose all that apply)
	//	A. protected
	// 	B. public
	//	C. static
	//	D. void
	//	E. abstract
	//	F. default
	
	//	Mijn antwoord: B, E
	//	Juiste antwoord: B > sinds java 8 kan een interface ook default zijn dus de enige correcte antwoord is B
	//                       interface moet altijd ppublic zijn.
	
	
	// 2.
	//	What is the output of the following code?
	//
	// 1: class Animal{
	// 2: public Animal (int age){
	// 3: System.out.print("Animal");
	// 4: }
	// 5: }
	// 6: public class Horse extends Animal {
	// 7: public Horse() {
	// 8: System.out.print("Horse");
	// 9: }
	// 10: public static void main(String[] args){
	// 11: new Animal(5);
	// 12: }
	// 13: }
	//
	//	A. Horse
	// 	B. Animal
	//	C. HorseAnimal
	//	D. Animal Horse
	//	E. the code will note compile because of line 8
	//	F. the code will note compile because of line 11
	
	//	Mijn antwoord: B 
	//	Juiste antwoord: E > omdat in line 8 een no-argument constructor aanwezig moet er ook een no-argument 
	//                       constructor in de parent class aanwezig zijn. Hier is in de parent class allleen maar
	//                       een int argument constructor.
	
	// 3.
	//	Wich of the following statement can inserted in the blank line so the code will compile 
	//  succesfully? (Choose all that apply)
	//
	// 1: public interface CanHop {}
	// 2: public class Frog implements CanHop{
	// 3:  public static void main(String[] args){
	// 4: ___________ frog = new TurtleFrog();
	// 5: }
	// 6: {
	// 7: public class CrazyFrog extends Frog{}
	// 8: public class TurtleFrog extends Frog{}
	//
	//	A. Frog
	// 	B. TurtleFrog
	//	C. BrazilianHornedFrog
	//	D. CanHop
	//	E. Object
	//	F. Long
	
	//	Mijn antwoord: A, D en E 
	//	Juiste antwoord: A, B, D en E > A: omdat TurtleFrog een child is van Frog  
	//                                  B: omdat een TurtleFrog een TurtleFrog is
	//                                  D: omdat Frog de interface CanHop erft, krijgt de TurtleFrog dit ook
	//                                  E: omdat elke class een Object erft.

	// 4.
	//	choose the correct statement about the following code 
	//  
	//
	// 1: interface Shell {
	// 2: abstract int getNumberOfSections();
	// 3:  }
	// 4: abstract class Insect implements Shell{
	// 5:  abstract int getNumberOfLegs();
	// 6: }
	// 7: public class Beetle extends Insect {
	// 8: int getNumberOfLegs() { return 6;}
	// 9: }
	//
	//	A. It compiles and runs without issues
	// 	B. The code will not compile of line 2
	//	C. The code will not compile of line 4
	//	D. The code will not compile of line 7
	//	E. It compiles but throws an exception at runtime
	//	
	
	//	Mijn antwoord: D 
	//	Juiste antwoord: D > hier moet de eerste concrete class alle abstracte methoden maken, deze dot hetniet voor   
	//                       de interfce methode getNumberOfSections. De abstrac class Insect hoeft niet een methode 
    //                       van de methode te maken omdat het zelf abstract is. De eerste concrete class moet dit doen
	
	// 5.
	//	Wich of the following statements abut polymorphism are true? (Choose all that apply)
	//	A. A reference to an Object may be cast to a subclass of the object without an explicit cast
	// 	B. If a method takes a superclass of three objects, than any of those classes may be passed as a parameter
	//     to the method
	//	C. A method that takes a parameter with Java.lang.Object will take any reference
	//	D. all cast exceptions can be detected at compile-time.
	//	E. By defining a public instance method in the superclass, you guarentee that the specific method will be 
	//	   called in the parent class at runtime.
	
	//	Mijn antwoord: A,B,C D
	//	Juiste antwoord: B, C > A is niet correct omdat je moet expleciet casten wanneer je verwijst naar een methode 
	//                          van een subclass, anders weet de compiler niet welje subclass je bedoeld.
	//                          Qnneer we naar boven gaan in de hierarchie dan is een expleciet cast niet nodig,
	//                          maar wanneer naar beneden gaan in de hierarchie dan hebben we wel een expleciet cast nodig.
	//                          D is niet correct omdat sommige cast excepties tijdens het compileren voortkomen en sommigen
	//                          niet.
	//                          	

	// 6.
	//	choose the correct statement about the following code. 
	//  
	//
	// 1: public interface Herbivore {
	// 2: int amount = 10;
	// 3: public static void eatPlant();
	// 4: public int chew(){
	// 5: return 13;
	// 6: }
	// 7: }
	//
	//	A. It compiles and runs without issues
	// 	B. The code will not compile of line 2
	//	C. The code will not compile of line 2
	//	D. The code will not compile of line 4
	//	E. The code will not compile of line 2 and 3
	//	F. The code will not compile of line 3 and 4
	
	//	Mijn antwoord: A
	//	Juiste antwoord: F > lijn 3 is niet correct omdat het aangegeven is als static maar het heeft geen body.   
	//                       lijn 4 is niet correct hier heeft het wel een body maar in dit geval geen static of default 
    //                       keyword.
	
	// 7.
	//	Which of the following statements are true for both abstract classes and interfaces? (Choose all that apply)
	//	A. All methods within them are assumed to be abstract.
	// 	B. Both can contain public static final variables.
	//	C. Both can be extended using the extends keyword
	//	D. Both can contain default methods.
	//	E. Both can contain static methods. 
	//	F. Neither can be instantiated directly
	//  G. Both inherit java.lang.Object
	
	//	Mijn antwoord: B, C, E, F G
	//	Juiste antwoord: B, C, E, F > A: Abstract class kan concrete methoden bevatten. 
	//                          B: Vanaf jaa 8 kan er ook mehoden in interface bevatten deze zijn public static en final
	//                          C: Beiden kunnen extend worden (true)
	//                          D: Alleen interface kan een default waarde bevatten (false)
	//                          E: Beiden kunnen static zijn (true)
	//                          F: Beiden moeten een subclass hebben om geinstantieerd te kunnn worden
	//                          G: omdat interface multiple overerving kan hebben kan het niet van java.lang.Object geerft worden
	//							   Muliple overerving laat java,lang,Object niet toe.
	
	// 8.
	//	What is the output of the following code 
	//  
	//
	// 1: public abstract class Whale {
	// 2: public abstract void dive() {};
	// 3: public static void main (String[] args){
	// 4: Whale whale = new Orca();
	// 5: whale.dive();
	// 6: }
	// 7: }
	// 8: Class Orca extends Whale{
	// 9: public void dive(int depth){ System.out.println("Orca diving");}
	// 10: }
	//
	//	A. Orca diving
	// 	B. The code will not compile of line 2
	//	C. The code will not compile of line 8
	//	D. The code will not compile of line 9
	//	E. The outcome cannot be determined from the code provided.
	
	//	Mijn antwoord: D
	//	Juiste antwoord: B > Abstract methodes kunnen geen body hebbem. in lijn heeft heeft het dit wel.
	
	// 9.
	//	What is the output of the following code 
	//  
	//
	// 1: abstract class Reptile {
	// 2: public final void layEggs() { System.out.println("Reptile laying eggs");
	// 3: public static void main (String[] args){
	// 4: Reptile reptile = new Lizard();
	// 5: reptile.layEggs();
	// 6: }
	// 7: }
	// 8: public class Lizard extends Reptile{
	// 9: public void layEggs() { System.out.println("Lizard laying eggs");}
	// 10: }
	//
	//	A. Reptile laying eggs
	// 	B. Lizard laying eggs
	//	C. The code will not compile of line 4
	//	D. The code will not compile of line 5
	//	E. The code will not compile of line 9
	
	//	Mijn antwoord: C
	//	Juiste antwoord: E > the methode layEggs is al final en kan dus niet in lijn 9 opnieuw gedefinieerd worden 
	//                       Let hier vooral op in de examen.
	
	// 10.
	//	What is the output of the following code (choose all that apply) 
	//  
	//
	// 1: interface Fish {
	// 2: public default getNumberOfGills(int input) { return 2;}
	// 3: }
	// 4: public class ClownFish implements Fish{
	// 5: public String getNumberOfGills() { return 4;}
	// 6: public String getNumberOfGills(int input) { return 6;}
	// 7: public static void main (String[] args){
	// 8: System.out.println(new ClownFish.getNumberOfGills(-1));
	// 9: }
	// 10: }
	//
	//	A. 2
	// 	B. 4
	//	C. 6
	//	D. The code will not compile of line 5
	//	E. The code will not compile of line 6
    //	F. The code will not compile of line 8
	
	//	Mijn antwoord: C
	//	Juiste antwoord: E > in lijn 6 will men de interface methode overriden maar de return types komen niet overeen 
	//                       In de interface is de return type een int terwijl in de Class ClownFish dit een String is.
	//                       Lijn 5 werkt wel want dat is een overloading en geen overriding zie de parameters.
	
}
