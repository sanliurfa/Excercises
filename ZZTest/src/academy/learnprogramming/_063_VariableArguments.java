package academy.learnprogramming;

import java.util.Arrays;

public class _063_VariableArguments {

//	public static void main(String[] args) {
//		
//	}
	
	public static void main(String... args){
		System.out.println(args.length);
		
		print(args);
		print("Java");
		print("this", "is", "my", "string", "array");
		print("variabel", "arguments", "are", "nice", "and", "useful", "feature");
	}
	
	
	private static void print(String... myArguments){
		System.out.println(Arrays.toString(myArguments));
	}

}
