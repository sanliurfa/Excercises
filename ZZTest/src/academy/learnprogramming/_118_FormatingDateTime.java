package academy.learnprogramming;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class _118_FormatingDateTime {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2010, Month.APRIL, 15);
		LocalTime time = LocalTime.of(11, 22);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));	
		
		DateTimeFormatter shortFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter mediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		
		System.out.println(shortFormatter.format(dateTime));
		System.out.println(mediumFormatter.format(date));
//		System.out.println(shortFormatter.format(time));
		
		// je kan ook je eigen formatter maken aan de hand van een payyern
		DateTimeFormatter fornatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
		System.out.println(dateTime.format(fornatter));
		
		// Voor java 7 gebruikten we hiervoor de simpleDate format deze zit ook nog in javan 8
		
		SimpleDateFormat sf = new SimpleDateFormat("hh:mm");
		System.out.println(sf.format(new Date()));
		
		// Examen Trick:
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm");
		System.out.println(dtf.format(dateTime));
//		System.out.println(dtf.format(date));
		System.out.println(dtf.format(time));

	}

}
