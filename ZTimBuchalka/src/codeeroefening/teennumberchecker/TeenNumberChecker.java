package codeeroefening.teennumberchecker;

public class TeenNumberChecker {

	public static void main(String[] args) {
		System.out.println(hasTeen(9, 99, 19));
		System.out.println(hasTeen(23, 15, 42));
		System.out.println(hasTeen(22, 23, 24));

	}
	
	public static boolean hasTeen(int param1, int param2, int param3) {
		int [] list = new int[3];
		list[0]= param1;
		list[1]= param2;
		list[2]= param3;
		
		for (int i : list) {
			if(i >= 13) {
				if(i <= 19) {
					return true;
				}
			}
		}
		return false;
	}

}
