package voorbeeld2;

public class Voorbeeld001ArrayForLoop {

	public static void main(String[] args) {
//		int[][] matrix = new int[5][4]; 
//		for(int i=0;i<5; i++) matrix[i][1] = 1;

		int i = 0;
		int[] iA = { 10, 20 };
		iA[i] = i = 30;
		System.out.println("" + iA[0] + " " + iA[1] + "  " + i);


	}

}
