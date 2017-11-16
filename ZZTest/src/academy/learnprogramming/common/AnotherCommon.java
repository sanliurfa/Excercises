package academy.learnprogramming.common;

public class AnotherCommon {

	public static void main(String[] args) {
		Common common = new Common();
		common.publicPrint();
		common.protectedPrint();
		common.defaultPrint();
//		common.privatePrint();				// Dit zal niet werken omdat het in een andere class bevindt en private is.
		
		
		System.out.println("publicNumber = "+ common.publicNumber);
		System.out.println("protectedNumber = "+ common.protectedNumber);
		System.out.println("defaultNumber = "+ common.defaultNumber);
//		System.out.println("privateNumber = "+ common.privateNumber); // Dit zal niet werken omdat het private is
	}

}
