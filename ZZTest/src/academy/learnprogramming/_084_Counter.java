package academy.learnprogramming;

public class _084_Counter {
	
	public static int count;
	public int anotherCount;
	
	public _084_Counter() {
		count++;
		anotherCount++;
	}
	

	public static void main(String[] args) {
		System.out.println("De beginwaarde is nu "+ count);
		_084_Counter one = new _084_Counter();
		System.out.println("De waarde is nu "+ count);
		_084_Counter two = new _084_Counter();
		System.out.println("De waarde is nu "+ count);
		_084_Counter three = new _084_Counter();
		System.out.println("De waarde is nu "+ count);
		_084_Counter four = new _084_Counter();
		
		
		
		// Wat wordt de waarde van count en anotherCount?
		
		System.out.println("count is " + count);				
		System.out.println("one count is " + one.count);		
		System.out.println("two count is " + two.count);		
		System.out.println("three count is " + three.count);			
		System.out.println("four count is " + four.count);		
		
		
		// Omdat het hier over dezelfde count gaat, allemaal over de static count, wordt dus de waarde iedere keer opgeteld.
		// dus wanneer als laatst alle waarden geprint moet worden is het dus dezelfde waarde namleijk vier.
		
		System.out.println("one anotherCount is " + one.anotherCount);		
		System.out.println("two anotherCount is " + two.anotherCount);		
		System.out.println("three anotherCount is " + three.anotherCount);			
		System.out.println("four anotherCount is " + four.anotherCount);	

	}

}
