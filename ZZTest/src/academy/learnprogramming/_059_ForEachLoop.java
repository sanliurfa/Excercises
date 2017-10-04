package academy.learnprogramming;

import java.util.Arrays;
import java.util.Iterator;

public class _059_ForEachLoop {

	public static void main(String[] args) {
			String [] names = {"Jimmy", "Jobs", "Tom", "Anthony"};
			
			for (int i = 0; i < names.length; i++) {
				System.out.println("name " + names[i]) ;
			}
			
			// Als enhanced for loop of for-each loop
			
			for(String name : names){
				System.out.println("name " + name) ;     // hierbij hoef je geen rekening te houden met de index waarde  i !!
			}
			
			
			// binnen een for kan men niet een lokale variabele wijzigen
			
			for(String name : names){
				name = name+ " "+ name;
			}
			
			// wanneer dit nogmaals laat printen dan zal het nog steeds hetzelfde blijven
			
			for(String name : names){
				System.out.println("name " + name) ; 
			}
			
			// Laten we dit met een Stringbuilder proberen.
			StringBuilder [] builders = {
					new StringBuilder("For"),
					new StringBuilder("Loop")
			};
			
			for (StringBuilder builder : builders) {
				System.out.println(builder);
			}
			
			// maar met een StringBuilder kunnen we wel wijzigen aanmaken
			
			for (StringBuilder builder : builders) {
				builder.append("123");
			}
			
			for (StringBuilder builder : builders) {
				System.out.println(builder);
			}
			
			
			//Examen Valkuilen
			
			String pets = "Parrot";
			
//			for(String pet : pets){}									//Dit zal niet werken, omdat je niet kan ittereren over een String!!
																		// Het zou een array moeten zijn
			
			
//			for(int name : names);										// Dit zal niet werken omdat de array bestaat uit Strings en de itteratie een int is
			
			for(char c : pets.toCharArray()){							// Dit zal wel werken omdat je de String omzet tot een charArray!!
				System.out.println(c);
			}
			
			
			
	}
}
