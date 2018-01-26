package academy.learnprogramming;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

public class _117_UsingPeriod {

	public static void main(String[] args) {
		LocalDate start = LocalDate.of(2017, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(2017, 4, 30);
		cleanAnimalCage(start, end);
		


		// start.toEpochDay(); // numbers of days since January 1 1970

		Period period = Period.ofWeeks(1);
		System.out.println(start.plus(period));
		System.out.println(LocalDateTime.now().plus(period));
		// System.out.println(LocalTime.now().plus(period)); // Dit geeft een runtime
		// error omdat LocalTime geen Dat bevat zodat period of week
		// erbij verwerkt kan worden

		Period yearAndMonth = Period.ofYears(1).ofMonths(1);
		System.out.println(yearAndMonth); // dit geeft alleen de maand omdat period altijd naar de laatste opgegeven
											// waarde kijkt!!!

		// Dit moet je oplossen door een andere notatie voor period kiezen
		Period yearAndMonth1 = Period.of(1, 1, 0);
		System.out.println(yearAndMonth1);
		
		
		cleanAnimalCage(start, end, period);

	}

	public static void cleanAnimalCage(LocalDate start, LocalDate end) {
		while (start.isBefore(end)) {
			System.out.println("Need to clean the cage on date " + start);
			start = start.plusMonths(1); // adding 1 month
		}
	}

	public static void cleanAnimalCage(LocalDate start, LocalDate end, Period period) {
		while (start.isBefore(end)) {
			System.out.println("Need to clean the cage on date " + start);
			start = start.plus(period);

		}
	}
	
	

}
