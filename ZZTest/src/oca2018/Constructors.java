package oca2018;


class Primate {
	  public Primate() {
	    System.out.println("Primate");
	  }
	}
	class Ape extends Primate {
	  public Ape() {
	    System.out.println("Ape");
	  }
	}



public class Constructors extends Ape{
	
	public Constructors(){
		System.out.println("Constructors");
	}

	public static void main(String[] args) {
				new Constructors();
	}

}
