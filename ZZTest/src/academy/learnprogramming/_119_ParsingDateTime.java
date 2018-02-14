package academy.learnprogramming;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class _119_ParsingDateTime {

	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
		LocalDate date = LocalDate.parse("02 15 2010", formatter);
		LocalTime time = LocalTime.parse("11:33");
		
		
		System.out.println(date);
		System.out.println(time);
		
		String text = date.format(formatter);
		System.out.println(text);
		
		LocalDate parsedDate = LocalDate.parse(text, formatter);
		System.out.println(parsedDate);
		
		// examen trick vragen
		LocalDate myDate = LocalDate.of(2014, Month.MAY, 5);
		String dateString = formatter.format(myDate);
		System.out.println(dateString);
		
		// opnieuw omzetten naar LocaDate en dagen erbij optellen.
		LocalDate anotherDate = LocalDate.parse(dateString, formatter);
		anotherDate.plusMonths(5).plusDays(5);
		System.out.println(formatter.format(anotherDate));		// Wat is hiet de resultaat?
		
		// omdat date immutable is en in regel 32 niet geinialitieerd word zal anotherDate gelijk zijn aan die van regel 31.

	}

}
