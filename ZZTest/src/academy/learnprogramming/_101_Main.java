package academy.learnprogramming;

public class _101_Main {

	public static void main(String[] args) {
		_101_Huskey huskey = new _101_Huskey(5);
		
		huskey.printDetails();
		
		
		_101_Dog dog = new _101_Dog(3);
		dog.setName("Rex");
		dog.printDetails();
		
		huskey.eat();
		
		System.out.println("avg= " + huskey.getAverageWeight());
		
		

	}

}
