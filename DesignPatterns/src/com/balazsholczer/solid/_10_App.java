package com.balazsholczer.solid;

public class _10_App {

	public static void main(String[] args) {
		_10_SorterManager sorterManager= new _10_SorterManager();
		sorterManager.sort(new _10_QuickSort());

	}
	
	// Wanneer men een ander sort mechanise toevoegd zal men op verschillende
	// plekken aanpassingen moeten uitvoeren waardoor wij niet aan de 
	// Open Closed architectuur principes voldoen. Hier word geeist dat er uitgebreid mag worden maar
	// GEEN wijzigingen mogen doen.
	// Hierom kiezen we om de STRATEGY Pattern te gebruiken.
	// Wanneer we de strategy pattern toepassen dan voldoe je aan de open closed principle.

}
