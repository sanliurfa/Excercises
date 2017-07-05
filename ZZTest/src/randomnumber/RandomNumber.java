package randomnumber;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		
		RandomNumber random = new RandomNumber();		
		int randomGetal = random.gen();
		System.out.println(randomGetal);

	}
	
	public int gen() {
	    Random r = new Random(System.currentTimeMillis());
	    return 1000000000 + r.nextInt(2000000000);
	}

}
