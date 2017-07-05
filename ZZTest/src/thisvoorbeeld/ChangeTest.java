package thisvoorbeeld;

public class ChangeTest {
	private int myValue = 0;

	public void showOne(int myValue) {
		myValue = myValue;
		System.out.println("lokale showOne myValue is " + myValue);
	}

	public void showTwo(int myValue) {
		this.myValue = myValue;
		System.out.println("lokale showTwo myValue is " + this.myValue);
	}

	public static void main(String[] args) {
		ChangeTest ct = new ChangeTest();
		ct.showTwo(200);
		System.out.println(ct.myValue);
		ct.showOne(100);
		System.out.println(ct.myValue);
	}
}
