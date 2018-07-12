package oefeningen;

class X {
	public void mX() {
		System.out.println("Xm1");
	}
}

class Y extends X {
	public void mX() {
		System.out.println("Xm2");
	}

	public void mY() {
		System.out.println("Ym");
	}
}

public class Oefening009Extends {

	public static void main(String[] args) {

		X xRef = new Y();
		Y yRef = (Y) xRef;
		yRef.mY();
		xRef.mX();
		
		X zRef = new X();
		zRef.mX();
		
		Y pRef = new Y();
		pRef.mX();
		pRef.mY();

	}

}
