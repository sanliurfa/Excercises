package puzzle;

import java.util.*;
import java.lang.Math;

public class Puzzle {
	private static Random rand = new Random();
	private static int tab[] = { 4, 7, 8, 10, 11, 6, 8, 14, 13, 12, 7, 3, 1 };
	private static boolean mutd;

	public static void main(String[] args) {
		byte[] chars = new byte[12];
		for (int i = 0; i < 12; i++) {
			chars[i] = (byte) rand.nextInt(9);
		}

		while (!mutd) {
			int s = 0;
			mutd = true;

			for (int i = 0; i < 12; i++) {
				int d1 = chars[i] + (i > 0 ? chars[i - 1] : 0);
				int d2 = chars[i] + (i < 11 ? chars[i + 1] : 0);
				d1 -= tab[i];
				d2 -= tab[i + 1];

				s += Math.abs(d1);
				s += Math.abs(d2);
				if (d1 != 0 || d2 != 0)
					chars[i] = mut(chars[i], d1 + d2);
			}
			if (rand.nextInt(100) == -1) {
				System.out.println(s);

				for (int i = 0; i < 12; i++)
					System.out.print(chars[i] + " ");
			}
		}

		for (int i = 0; i < 12; i++) {
			if (chars[i] > 3)
				chars[i] = (byte) ((chars[i] -= 2) * (chars[i] = 3) + 1);

			if (chars[i] == 7)
				chars[i] -= 33;
			System.out.print((char) (byte) (chars[i] + (Math.abs(chars[i]) >= 2 ? 98 : 32)));
		}
	}

	private static byte mut(byte val, int d) {
		mutd = false;
		if (d == 0)
			return (byte) Math.min(8, Math.max(0, (2 * rand.nextInt(2) - 1 + val)));
		else
			return (byte) Math.min(8, Math.max(0, (rand.nextInt(3) + (d < 0 ? -1 : -2) + val)));
	}
}
