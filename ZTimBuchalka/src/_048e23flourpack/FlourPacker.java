package _048e23flourpack;

public class FlourPacker {

	public static void main(String[] args) {
		System.out.println(canPack(1, 0, 4));
		System.out.println(canPack(1, 0, 5));
		System.out.println(canPack(0, 5, 4));
		System.out.println(canPack(2, 2, 12));
		System.out.println(canPack(-3, 2, 12));
		

	}
	
	public static boolean canPack(int bigCount, int smallCount, int goal) {
		if (bigCount < 0 || smallCount < 0 || goal < 0) {
			return false;
		}
		
		int sumBigCount = bigCount * 5;
		int sumSmallCount = smallCount * 1;
		
		if ((sumBigCount + sumSmallCount) > goal) {
			return false;
		}
		
		int neededBigCount = goal%5;
		int neededSmallCount = goal - neededBigCount;
		
		if ((neededBigCount + neededSmallCount) != goal) {
			return true;
		}
		
		
		
		return false;
		
		
		
	}

}
