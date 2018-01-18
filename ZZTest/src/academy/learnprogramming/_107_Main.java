package academy.learnprogramming;

public class _107_Main {

	public static void main(String[] args) {
		_107_Huskey huskey = new _107_Huskey(5);
		
		huskey.printDetails();
		
		
		_107_Dog dog = new _107_Dog(3);
		dog.setName("Rex");
		dog.printDetails();
		
		huskey.eat();
		
		System.out.println("avg= " + huskey.getAverageWeight());
		System.out.println("tail length= "+ huskey.getTailLength());
		
		huskey.run(10);
		
		_107_Bear bear = new _107_Bear();
		bear.setName("Jimmy");
		bear.setAge(10);
		bear.eatMeat();
		bear.eatPlants();
		bear.printDetails();
		
		

	}

}
