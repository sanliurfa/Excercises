/**
 * 
 */
package datesandtimes;

import java.time.*;

/**
 * @author ro-goki
 *
 */
public class DateAndTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now()); 
		
		LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
		LocalDate date2 = LocalDate.of(2015, 1, 20);
		
		System.out.println(date1);
		System.out.println(date2);
		
		LocalTime time1 =  LocalTime.of(6, 15);               // hour and minute 
		LocalTime time2 =  LocalTime.of(6, 15, 30);          // + seconds 
		LocalTime time3 =  LocalTime.of(6, 15, 30, 200);     // + nanoseconds 
		
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time3);
		
		LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30); 
		LocalDateTime dateTime2 = LocalDateTime.of(date1, time1); 
		
		System.out.println(dateTime1);
		System.out.println(dateTime2);
		
		//The date and time classes are immutable. We need to remember to assign the results of these methods to a reference variable so they are not lost.
		
		LocalDate date = LocalDate.of(2014, Month.JANUARY, 20); 
		System.out.println(date);          // 2014-01-20 
		date = date.plusDays(2); 
		System.out.println(date);          // 2014-01-22 
		date = date.plusWeeks(1); 
		System.out.println(date);          // 2014-01-29 
		date = date.plusMonths(1); 
		System.out.println(date);          // 2014-02-28 
		date = date.plusYears(5); 
		System.out.println(date);          // 2019-02-28 
		
		//To subtract date
		
		LocalDate date3 = LocalDate.of(2020, Month.JANUARY, 20); 
		LocalTime time = LocalTime.of(5, 15); 
		LocalDateTime dateTime = LocalDateTime.of(date3, time); 
		System.out.println(dateTime);          // 2020-01-20T05:15 
		dateTime = dateTime.minusDays(1); 
		System.out.println(dateTime);          // 2020-01-19T05:15 
		dateTime = dateTime.minusHours(10); 
		System.out.println(dateTime);          // 2020-01-18T19:15 
		dateTime = dateTime.minusSeconds(30); 
		System.out.println(dateTime);          // 2020-01-18T19:14:30 
		
		//Or chained
		LocalDate date4 = LocalDate.of(2020, Month.JANUARY, 20); 
		LocalTime time4 = LocalTime.of(5, 15); 
		LocalDateTime dateTime4 = LocalDateTime.of(date4, time4).minusDays(1).minusHours(10).minusSeconds(30); 
		System.out.println(dateTime4);
		
		//Wat print de volgende stuk?
		LocalDate date5 = LocalDate.of(2020, Month.JANUARY, 20); 
		date5.plusDays(10); 
		System.out.println(date5);
		
		//Vergeet niet dat LocalDate immutable is!!
		
		
//****** PERIOD  ******//
		
		// Er zijn vijf manieren om een period class te creeren.
		Period annually = Period.ofYears(1);               // every 1 year 
		Period quarterly = Period.ofMonths(3);               // every 3 months 
		Period everyThreeWeeks = Period.ofWeeks(3);          // every 3 weeks 
		Period everyOtherDay = Period.ofDays(2);          // every 2 days 
		Period everyYearAndAWeek = Period.of(1, 0, 7);          // every year and 7 days 
		
		/*
		 * There's one catch. You cannot chain methods when creating a Period. 
		 * The following code looks like it is equivalent to the everyYearAndAWeek example, but it's not. 
		 * Only the last method is used because the Period.ofXXX methods are static methods.
		 */
		
		Period wrong = Period.ofYears(1).ofWeeks(1);          // every week 
		
		//Voorbeeld voor het gebruik van Period:
		
		LocalDate date6 = LocalDate.of(2015, 1, 20); 
		LocalTime time6 = LocalTime.of(6, 15); 
		LocalDateTime dateTime6 = LocalDateTime.of(date6, time6); 
		Period period = Period.ofMonths(1); 
		System.out.println(date6.plus(period));          // 2015-02-20 
		System.out.println(dateTime6.plus(period));          // 2015-02-20T06:15 
//		System.out.println(time6.plus(period));   // UnsupportedTemporalTypeException want period is een maand en geen tijd.


	}

}
