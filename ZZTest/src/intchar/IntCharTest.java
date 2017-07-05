package intchar;

public class IntCharTest {

	public void m(int a) {
		System.out.println("In int " + a);
	}

	public void m(char c) {
		System.out.println("In char " + c);
		;
	}

	public static void main(String[] args) {
		IntCharTest n = new IntCharTest();
		int a = 'a';
		char c = 70;
		n.m(a);
		n.m(c);
	}
}
