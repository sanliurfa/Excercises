package academy.learnprogramming;

import java.time.LocalDate;
import java.time.*;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class _120_ExamQuestions {

	public static void main(String[] args) {
		
		// 1.
		// WHich of the following van be inserted into the blank to create a 
		// date of Juni 21, 2012?  (Choose all that apply)
		//	A. new LocalDate(2012, 5, 21);
		// 	B. new LocalDate(2012, 6, 21);
		//	C. LocalDate.of(2012, 5, 21)
		//	D. LocalDate.of(2012, 6, 21)
		//	E. LocalDate.of(2012, CALENDER.JUNE, 21)
		//	F. LocalDate.of(2012, MONTH.JUNE, 21)
		
		// Mijn antwoord: D en F
		// Juiste Antwoord: D en F
		
		//2.
		// What is the output of the following code 
//		LocalDate date = LocalDate.parse("2020-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
//		date.plusDays(2);
//		date.plusHours(3);
//		System.out.println(date.getYear()+ " "+ date.getMonthValue()+ " "+date.getDayOfMonth());
		//	A. 2020 APRIL 2
		// 	B. 2020 APRIL 30
		//	C. 2020 MAY 2
		//	D. The code does not compile
		//	E. A runtime exception is thrown
		
		// Mijn antwoord: D
		// Juiste Antwoord: D
		
		
		// 3.
		// What is the output of the following code 
//		LocalDate date = LocalDate.of(2020, Month.APRIL, 40);
//		System.out.println(date.getYear()+" "+ date.getMonth()+ "" + date.getDayOfMonth());	
		//	A. 2020 APRIL 4
		// 	B. 2020 APRIL 30
		//	C. 2020 MAY 10
		//	D. Another date
		//	E. The code does not compile
		//	F. A runtime exception is thrown
		
		// Mijn antwoord: F omdat de dag niet 40 kan zijn
		// Juiste Antwoord: F
		
		
		// 4.
		// What is the output of the following code 
//		LocalDate date = LocalDate.of(2028, Month.APRIL, 30);
//		date.plusDays(2);
//		date.plusYears(3);
//		System.out.println(date.getYear()+" "+ date.getMonth()+ "" + date.getDayOfMonth());	
		//	A. 2028 APRIL 2
		// 	B. 2028 APRIL 30
		//	C. 2028 MAY 2
		//	D. 2031 APRIL 2
		//	E. 2031 APRIL 30
		//  F. 2031 MAY 2
		//	G. A runtime exception is thrown
		
		// Mijn antwoord: B 
		// Juiste Antwoord: B
		
		// 5.
		// What is the output of the following code 
//		LocalDate d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
//		Period p = Period.of(1, 2, 3);
//		d = d.minus(p);
//		DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
//		System.out.println(d.format(f);	
		//	A. 3/7/14 11:22 AM
		// 	B. 5/10/15 11:22 AM
		//	C. 3/7/14
		//	D. 5/10/15
		//	E. 11:22
		//  F. the code does not compile
		//	G. A runtime exception is thrown
		
		// Mijn antwoord: A
		// Juiste Antwoord: E omdat de formatter alleen de LocelizeTime betreft
		//					laat het ook alleen de tijd zien. Het formateert alleen de tijd.
				
		// 6.
		// What is the output of the following code 
//		LocalDateTime d = LocalDateTime.of(2017, 5, 10, 11, 22, 33);
//		@SuppressWarnings("static-access")
//		Period p = Period.ofDays(1).ofYears(2);
//		d = d.minus(p);
//		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
//		System.out.println(f.format(d));	
		//	A. 5/9/15 11:22 AM
		// 	B. 5/10/15 11:22 AM
		//	C. 5/9/17
		//	D. 5/10/16
		//  E. the code does not compile
		//	F. A runtime exception is thrown
		
		// Mijn antwoord: F
		// Juiste Antwoord: B Period doet niet aan chaining dus het trekt hier alleen twee jaar eraf  
		//					
				
						
		
		
	}

}
