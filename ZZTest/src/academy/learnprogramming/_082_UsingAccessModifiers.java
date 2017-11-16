package academy.learnprogramming;

import academy.learnprogramming.common.Common;

public class _082_UsingAccessModifiers {

	public static void main(String[] args) {
		Common common = new Common();
		common.publicPrint();
//		common.protectedPrint();			//compileer fout omdat het in een andere package bevind
//		common.defaultPrint();				//compileer fout omdat het in een andere package bevind
//		common.privatePrint();				//compileer fout omdat het in een andere package bevind
		
		System.out.println("publicNumber = "+ common.publicNumber);
//		System.out.println("protectedNumber = "+ common.protectedNumber); // Dit zal niet werken omdat de field in een ander package bevind
//		System.out.println("defaultNumber = "+ common.defaultNumber);		// Dit zal niet werken omdat de field in een ander package bevind
//		System.out.println("privateNumber = "+ common.privateNumber);		// Dit zal niet werken omdat de field in een ander package bevind
	}

}
