package oefeningen;

/*
 * Wanneer je de onderstaande opstart met argumenten 1 2
 * Dan wordt dus [0] 1
 * en            [1] 2
 * i wordt dan 2
 * Wanneer deze dan wil printen met args[2] welke je niet hebt dan krijg je een
 * ArrayIndexOfBoundsException
 */

public class Oefening015IntegerParse {

	public static void main(String[] args) {
		int i = Integer.parseInt(args[1]);
		System.out.println(args[i]);
	}
}