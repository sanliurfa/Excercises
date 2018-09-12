package com.balazsholczer.solid;

public class _09_App {

	public static void main(String[] args) {
		_09_SorterManager sorterManager= new _09_SorterManager();
		sorterManager.sort(new _09_InsertionSort());

	}
	
	// Wanneer men een ander sort mechanise toevoegd zal men op verschillende
	// plekken aanpassingen moeten uitvoeren waardoor wij niet aan de 
	// Open Closed architectuur principes voldoen. Hier word geeist dat er uitgebreid mag worden maar
	// GEEN wijzigingen mogen doen.
	// Hierom kiezen we om de STRATEGY Pattern te gebruiken

}
