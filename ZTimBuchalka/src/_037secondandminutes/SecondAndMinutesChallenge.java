package _037secondandminutes;

public class SecondAndMinutesChallenge {

	static int totalHours = 0;
	static int totalMinutes = 0;
	static int totalSeconds = 0;

	public static void main(String[] args) {
	//	getDurationString(125, 4);
		getDurationString(200);

		System.out.println(totalHours + " hours");
		System.out.println(totalMinutes + " minutes");
		System.out.println(totalSeconds + " seconds");

	}

	public static int getDurationString(int minutes, int seconds) {

		if (minutes < 0 || seconds <= 0 || seconds > 59) {
			System.out.println("Invalid values");
		} else {
			totalSeconds = (minutes * 60) + seconds;
			totalHours = totalSeconds / 3600;
			totalSeconds = totalSeconds - (totalHours * 3600);
			if (totalSeconds > 60) {
				totalMinutes = totalSeconds / 60;
				totalSeconds = totalSeconds - (totalMinutes * 60);
			} else {
				totalMinutes = 0;
			}

		}
		return (totalHours, totalMinutes, totalSeconds);

	}

	public static int getDurationString(int seconds) {
		
		if (seconds <= 0 ) {
			System.out.println("Invalid values");
		} else {
				totalHours = seconds / 3600;
				totalSeconds = seconds - (totalHours * 3600);
				if (totalSeconds > 60) {
					totalMinutes = totalSeconds / 60;
					totalSeconds = totalSeconds - (totalMinutes * 60);
				} else {
				totalMinutes = 0;
				}

		}
		
	}
}
	
	
		
	


