package _037secondandminutes;

public class SecondAndMinutesChallenge {

	private static final String INVALID_MESSAGE = "Invalid values";
	static int totalHours = 0;
	static int totalMinutes = 0;
	static int totalSeconds = 0;

	public static void main(String[] args) {
		 getDurationString(61, 0);
		 
		 System.out.println(getTotalHours() + " hours " + getTotalMinutes() + " minutes " + getTotalSeconds() + " seconds" );
			
			
			
		 getDurationString(8000);

		System.out.println(getTotalHours() + " hours "+ getTotalMinutes() + " minutes " + getTotalSeconds() + " seconds" );
		
		

	}

	private static void getDurationString(int minutes, int seconds) {

		if (minutes < 0 || seconds < 0 || seconds > 59) {
			System.out.println(INVALID_MESSAGE);
		} else {
			totalSeconds = (minutes * 60) + seconds;
			totalHours = totalSeconds / 3600;
			totalSeconds = totalSeconds - (totalHours * 3600);
			if (totalSeconds >= 60) {
				totalMinutes = totalSeconds / 60;
				totalSeconds = totalSeconds - (totalMinutes * 60);
			} else {
				totalMinutes = 0;
			}
		}
		

	}
	
	
	private static void getDurationString(int seconds) {

		if (seconds <= 0) {
			System.out.println(INVALID_MESSAGE);
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

	/**
	 * @return the totalHours
	 */
	public static int getTotalHours() {
		return totalHours;
	}

	/**
	 * @param totalHours the totalHours to set
	 */
	public static void setTotalHours(int totalHours) {
		SecondAndMinutesChallenge.totalHours = totalHours;
	}

	/**
	 * @return the totalMinutes
	 */
	public static int getTotalMinutes() {
		return totalMinutes;
	}

	/**
	 * @param totalMinutes the totalMinutes to set
	 */
	public static void setTotalMinutes(int totalMinutes) {
		SecondAndMinutesChallenge.totalMinutes = totalMinutes;
	}

	/**
	 * @return the totalSeconds
	 */
	public static int getTotalSeconds() {
		return totalSeconds;
	}

	/**
	 * @param totalSeconds the totalSeconds to set
	 */
	public static void setTotalSeconds(int totalSeconds) {
		SecondAndMinutesChallenge.totalSeconds = totalSeconds;
	}


}
