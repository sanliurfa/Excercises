package academy.learnprogramming;

public class _102_Rabbit extends _102_Animal{
	public _102_Rabbit() {
//		super;							// Dit is een examen truk om je in verwarring te brengen omdat dit een compilatie error
										// geeft. super; verwacht een methode achter super, en je doet ook geen aanrope naar de 
										// super constructor super();
		
//		super().setAge(3);				// Dit zal ook niet compileren omdat je een aanroep doet naar een super constructor en 
										// daarna ook nog een andere methode setAge(3)
		
		super();						// Je kan wel een in twee aparte lijnen aanroepen, dus eerst een CALL naar super() en 
		super.setAge(3);				// daarna de super.setAge op 3 zetten.
		this.setAge(3);					// Je hoeft niet eens de parent setAge op te vragen want deze class heeft het overerft 
										// en kan ook met this.setAge
		setAge(3);						// of setAge(3) te doen.
	}
	
	
	public _102_Rabbit(int age) {
//		this(age);						// dit geeft een compilatie error omdat het zichzelf aanroept met this en gaat hiermee 
										// oneindig loopen.
		
		super(3);						// LET OP; Je kan GEEN twee calls hebben, dus NOOIT this() en  daarna super(). omdat deze calls
										// de eerste aanroep moeten zijn. Je kan dus een van beide gebruiken en niet allebei in een methode
		
	}

}
