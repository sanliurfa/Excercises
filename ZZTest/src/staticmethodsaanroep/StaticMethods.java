package staticmethodsaanroep;

 class StaticMethods2 {
	 
    static void one() {				// statische methode
       two();
       StaticMethods2.two();
//       three();						// FOUT: je kan niet vanuit een statische methode een NIET statische methode aanroepen!!
//       StaticMethods2.four();		// FOUT: je kan niet vanuit een statische methode een NIET statische methode aanroepen!!
     }
    
    
    static void two() { }			// statische methode
    
    
       void three() { 				// geen statische methode
      one();
      StaticMethods2.two();			// Je kan WEL vanuit een niet statische methode een statische methode aanroepen, wel op een statische wijze 
      two();
      
      four();
//      StaticMethods2.four();		// FOUT: vanuit een niet statiche methode kan je een ander niet statische methode aanroepen,
      								// maar NIET op een statishe wijze
      four();						// Dit kan dus wel
      
    }
    void four() { }					// geen statische methode
 }

// Which three lines are illegal?
 
 
 // Antwoord regels 8 en 9; three() en Staticmethod2.four
 // en regel 22 
