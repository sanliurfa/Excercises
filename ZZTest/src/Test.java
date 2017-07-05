
public class Test {
	
	public static void testInts(Integer obj, int var){
		obj = var++;
		obj++;
	}
	
	public static void testGetal(Getal g, int val) {
		g.plus1();
		val = val + 1;
	}
	
	
	public static void main(String[] args){
//		 Integer val1 = new Integer(5);
//         int val2 = 9;
//         testInts(val1++, ++val2);
//         System.out.println(val1+" "+val2);

        Getal getal1 = new Getal(8);
        Getal getal2 = new Getal(8);
        getal1.plus1();
        getal2.plus1();
        System.out.println(getal1.getWaarde() + " " + getal2.getWaarde());
        System.out.println(getal1.getStatischeWaarde() + " " + getal2.getStatischeWaarde());
	}
	
	public static class Getal {
		int waarde;
		static int statischeWaarde;
		public Getal(int waarde)
		{
			this.waarde = waarde;
			this.statischeWaarde = waarde;
		}
		
		public void plus1() {
			waarde++;
			statischeWaarde++;
		}
		
		public int getWaarde() {
			return waarde;
		}
		
		public int getStatischeWaarde() {
			return statischeWaarde;
		}
	}

}
