package statictest;

public class StaticExample {
	public static void main(String args[]) {
		StaticMethods.method(10);
		StaticMethods.method(10.0);
		StaticMethodsSub.method(10.0);
		StaticMethods methods = new StaticMethodsSub();
		//Here the sub class method is not invoked
		methods.method(10);
		StaticMethods instanceMethod = new MethodsSub();
		instanceMethod.method(30);
	}
}
class StaticMethods{
	public static void method(int i){
		System.out.println("Static int method " + i);
	}
	public static void method(double i){
		System.out.println("Static double method " + i);
	}	
}
class StaticMethodsSub extends StaticMethods{
	public static void method(int i){
		System.out.println("Static int sub method " + i);
	}
	public static void method(double i){
		System.out.println("Static double sub method " + i);
	}
}

class MethodsSub extends StaticMethods{
	public void method1(int i) {
		System.out.println();
	}
}