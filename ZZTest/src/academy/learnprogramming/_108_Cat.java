package academy.learnprogramming;

//public class _108_Cat extends _108_Animal implements _108_Walk, _108_Run{
	public class _108_Cat extends _108_Animal implements _108_Run{	
	
	// wanneer je twee interfaces moet implementeren die hetzelfde methoden hebben, dan zal er een compilatie fout worden veroorzaakt
	// Je kan dit oplossen door de interfaces van elkaar te extenden
	// maar dan hoeft de class Cat maar een interface te implementeren
	
	@Override
	public int getSpeed() {
		
		return 15;
	}

}
