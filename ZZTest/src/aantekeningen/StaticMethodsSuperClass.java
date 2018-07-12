package aantekeningen;

public class StaticMethodsSuperClass {

	public static void main(String[] args) {

		StaticMethods.method(10);
		StaticMethods.method(10.0);
		StaticMethodsSub.method(10.0);
		StaticMethods methods = new StaticMethodsSub();
		// Here the sub class method is not invoked
		methods.method(10);
	}
}

class StaticMethods {
	public static void method(int i) {
		System.out.println("Static int method");
	}

	public static void method(double i) {
		System.out.println("Static double method");
	}
}

class StaticMethodsSub extends StaticMethods {
	public static void method(int i) {
		System.out.println("Static int sub method");
	}

	public static void method(double i) {
		System.out.println("Static double sub method");
	}

}
