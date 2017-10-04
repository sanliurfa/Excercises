package academy.learnprogramming;

public class ObjectEquality {

	public static void main(String[] args) {
		// comparing objects (dmv wrapper)
		Integer myInteger = 127;
		Integer myAnotherInteger = 127;
		
		System.out.println(myInteger == myAnotherInteger);
		
		
		System.out.println("128 == 128: " + (128 == 128));
		
		myInteger = 128;
		myAnotherInteger = 128;
		
		
		System.out.println("myInteger= " + myInteger);
		System.out.println("myAnotherInteger= "+ myAnotherInteger);
		
		
		System.out.println(myInteger == myAnotherInteger);
		
		Integer int1 = new Integer(1);
		Integer int2 = new Integer(1);
		Integer int3 = 1;
		
		System.out.println("int1 == int2: " + (int1 == int2));
		System.out.println("int1 == int3: " + (int1 == int3));
		System.out.println("int2 == int3: " + (int2 == int3));
		
		
		System.out.println("int1 equals int2: " + (int1.equals(int2)));
		System.out.println("int1 equals int2: " + (int1.equals(int3)));
		System.out.println("int1 equals int2: " + (int2.equals(int3)));
		
		//Conclusie == vergelijkt of het dezelfde objecten zijn of hetzelfde reference heeft
		//			equals vergelijkt de data in die objecten of deze gelijk zijn
		// Als bewijs laten we hier de adress printen
		
		System.out.println("int1 hash= " + System.identityHashCode(int1));
		System.out.println("int2 hash= " + System.identityHashCode(int2));
		System.out.println("int3 hash= " + System.identityHashCode(int3));
		
		

	}

}
