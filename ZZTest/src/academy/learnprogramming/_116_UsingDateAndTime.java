package academy.learnprogramming;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class _116_UsingDateAndTime {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2030, Month.JANUARY, 10);
		System.out.println(date);
		
		// omdat date net als String immutable is moeten we het opnieuw  re-assignen
		
		date = date.plusDays(5).plusMonths(2);
		System.out.println(date);
		
		// dit geldt ook voor tijd
		LocalTime time = LocalTime.of(10, 30);
		System.out.println(time);
		time = time.plusHours(2).plusMinutes(20);
		System.out.println(time);
		
		LocalDateTime localDateTime = LocalDateTime.of(date, time);
		System.out.println(localDateTime);
		localDateTime = localDateTime.minusHours(10).plusDays(2).plusWeeks(1);
		System.out.println(localDateTime);
		
		// before java 8
		
		Date myDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(myDate);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.MONTH, 2);			// De maand telling begint bij 0 dus januari is 0 en februari is 1 en maart is 2 enz!!!! 
		myDate = calendar.getTime();
		System.out.println(myDate);
		
		// exam tricks
		LocalDate ld = LocalDate.of(2010, Month.APRIL, 1);
		ld.plusDays(10);
		System.out.println(ld);							// hier vragen ze wat de uitkomst is van ld
		
		// uitkomst; ld blijft hetzelfde want het wordt niet ge-reassigned dus 2010-4-1
		
//		ld.plusMinutes(10);							// dit zal een Compilatie error geven omdat LocalDate GEEN time element heeft!
		
		LocalTime lt = LocalTime.of(12, 45);
//		lt.addDays(3);								// dit zal ook niet werken omdat de methode addDays niet bestaat vooral ook niet voor tijd!
													// er bestaat wel de plusTime methode maar geen add.
		
		
		
		
		

	}

}
