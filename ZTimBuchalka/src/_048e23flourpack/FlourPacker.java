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

//public static boolean canPack(int bigCount, int smallCount, int goal) {
//    boolean canPack = false;
//    int big = bigCount*5; // 5 kilos per bag
//    int small = smallCount; // 1 kilo per bag
//    int total = big + small; // total kilo bags
//
//    if((goal > total) || goal <=0) canPack = false;
//    else {
//        if((goal%5 == 0) || (small >= goal)) canPack = true;
//        else {
//            while (goal-5 > 0) {
//                goal -= 5;
//                if (goal <= small) {
//                    canPack = true;
//                    break;
//                }
//            }
//        }
//    }
//    return canPack;
//}

