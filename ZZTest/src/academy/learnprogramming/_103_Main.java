package academy.learnprogramming;

public class _103_Main {

	public static void main(String[] args) {
		_103_Huskey huskey = new _103_Huskey(5);
		
		huskey.printDetails();
		
		
		_103_Dog dog = new _103_Dog(3);
		dog.setName("Rex");
		dog.printDetails();
		
		huskey.eat();
		
		System.out.println("avg= " + huskey.getAverageWeight());
		
		

	}

}
