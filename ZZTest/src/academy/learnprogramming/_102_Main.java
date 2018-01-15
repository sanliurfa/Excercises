package academy.learnprogramming;

public class _102_Main {

	public static void main(String[] args) {
		_102_Huskey huskey = new _102_Huskey(5);
		
		huskey.printDetails();
		
		
		_102_Dog dog = new _102_Dog(3);
		dog.setName("Rex");
		dog.printDetails();
		
		huskey.eat();
		
		System.out.println("avg= " + huskey.getAverageWeight());
		
		

	}

}
