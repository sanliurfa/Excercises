package academy.learnprogramming;

public class _091_QuestionsExamples {

	// 1.
	//	Wich of the following can fill in the blanks in this code to make it compile? Choose all that apply.
	//	A. default
	// 	B. final
	//	C. private
	//	D. Public
	//	E. String
	//	F. abc.
	
	//	Mijn antwoord: B, C, D
	//	Juiste antwoord: B en C > methodes hebben geen public wel classes
	
	
	// 2.
	//	Wich of the following compile? Choose all that apply.
	//	A. final static void jump4() {}
	// 	B. public final int void() {}
	//	C. private void int jump() {}
	//	D. static final void jump3() {}
	//	E. void final method() {}
	//	F. void public method() {}
	
	//	Mijn antwoord: A, D, 
	//	Juiste antwoord: A en D
	
	// 3.
	//	Wich of the following compile? Choose all that apply.
	//	A. public void runA() {return;}
	// 	B. public void runB() {return null;}
	//	C. public void runC() {}
	//	D. public int runD() {return 9;}
	//	E. public int runE() {return 9.0;}
	//	F. public int runF() {return;}
	//	G. public int runG() {return null;}
	
	//	Mijn antwoord: C, D, F
	//	Juiste antwoord: A, C en D > Bij void mag je returnen zolang het geen waarde bevat. null is ook een waarde. G, F> er wordt een int gevraagd leeg, null
	//								en 9.0 zijn geen int's.
	
	// 4.
	//	Wich of the following compile? Choose all that apply.
	//	A. public void runA() {int... nums}
	// 	B. public void runB() {String values, int... nums}
	//	C. public void runC() {int... nums, String values}
	//	D. public int runD() {String... values, int... nums}
	//	E. public int runE() {String[] values, ...int nums}
	//	F. public int runF() {String... values, int[] nums}
	//	G. public int runG() {String[] values, int[] nums}
	
	//	Mijn antwoord: A, B, en G
	//	Juiste antwoord: A, B en G > C en F zijn fout omdat varargs altijd als laatste parameter moeten voorkomen. D is fout omdat er maar een varargs
	//								parameter aanwezig mag zijn. E is fout omdat de puntjes achter de tyoe moet staan.
		
	// 5.  ???????????????????????????????
	//	Given the following method, wich of the method calls return 2? (Choose all that apply)
	//	public int count(boolean b, boolean... b2){
	//		return b2.length;
	//	}
	//
	//	A. count();
	// 	B. count(true);
	//	C. count(true, true);
	//	D. coutn(true, true, true);
	//	E. coutn(true, {true});
	//	F. coutn(true, {true, true});
	//	G. count(true, new boolean[2]);
	
	//	Mijn antwoord: C, E
	//	Juiste antwoord: D, G > 
	//								
		
	// 6.  
	//	What is the result of the following statement?
	//	public class Test{
	//  	public void print(byte x) {System.out.println("byte");}
	//		public void print(int x) {System.out.println("int");}
	//		public void print(float x) {System.out.println("float");}
	//		public void print(Object x) {System.out.println("Object");}
	//		public static void main(String[] args){
	//			Test t = new Test();
	//			short s = 123;
	//			t.print(s);
	//			t.print(true);
	//			t.print(6.789);
	//			}
	//		}
	//	A. bytefloatObject
	// 	B. intfloatObject
	//	C. byteObjectfloat
	//	D. intObjectfloat
	//	E. intObjectObject
	//	F. byteObjectObject
	
	//	Mijn antwoord: 
	//	Juiste antwoord: E 
	//		
	
	// 7.  
	//	Wich are true of the following code? Choose all that apply.
	//	public class Rope{
	//  	public static void swing() {System.out.println("swing");}
	//		public void climb() {System.out.println("climb");}
	//		public static void play() {swing(); climb();}
	//		public static void main(String[] args){
	//			Rope rope = new Rope();
	//			rope.play();
	//			Rope rope2 = null;
	//			rope2.play();
	//			}
	//		}
	//	A. the code compiles as is
	// 	B. There is exactly one compiler error in the code
	//	C. There are exactlu two compiler errors in the code
	//	D. if the line with compile errors are removed, the output is climb climb.
	//	E. if the line with compile errors are removed, the output is swing swing.
	//	F. if the line with compile errors are removed, the code throws a NullPointerException.
	
	//	Mijn antwoord: 
	//	Juiste antwoord: B en E > lijn 107 alleen een static methode kan een static methode aanroepen en geen instance methoden.
	//	
	
	// 8.  
	//	How many compiler errors are in the following code?
	//	public class RopeSwing{
	//  	private static final String leftRope;
	//  	private static final String rightRope;
	//  	private static final String bench;
	//  	private static final String String name = "name";
	//		static { leftRope = "left"; rightRope = right";}
	//		static { name = "name"; rightRope = "right"}
	//		public static void main(String[] args){
	//			bench = "bench";
	//			}
	//		}
	//	A. 0
	// 	B. 1
	//	C. 2
	//	D. 3
	//	E. 4
	//	F. 5
	
	//	Mijn antwoord: 2
	//	Juiste antwoord: 4 > final static variabelen moeten een keer geinitialiseerd worden, of op dezelfde lijn of in een een static blok. 
	//						 lijn 131 bench wordt in beide gevallen niet geinialiceerd.	
	//						in lijn 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
