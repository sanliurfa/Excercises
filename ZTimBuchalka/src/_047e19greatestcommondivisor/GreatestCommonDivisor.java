package _047e19greatestcommondivisor;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		System.out.println(getGreatestCommonDivisor(25, 15));
	}

	public static int getGreatestCommonDivisor(int first, int second) {

		if (first < 10 || second < 10)
			return -1;

		if (first < second) {									// wanneer de eerste param kleiner is dan de tweede
			for (int i = first; i > 0; i--) {					// vanaf de eerste en tel terug
				if ((first % i == 0) && (second % i == 0))		// hoogste deelbare waarbij er niets overblijft moet gelijke waarde
																// hebben aan de tweede.
					return i;
			}
		} else {
			for (int i = second; i > 0; i--) {
				if ((first % i == 0) && (second % i == 0))
					return i;
			}
		}
		return -1;
	}

}
