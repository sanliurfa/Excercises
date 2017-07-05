/**
 * 
 */
package lambdas2example;

/**
 * @author ro-goki
 *
 */
public class RunnableTest {
	public static void main(String[] args) {

		System.out.println("=== RunnableTest ===");

		// Anonymous Runnable
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello world one!");
			}
		};

		// Lambda Runnable
		Runnable r2 = () -> System.out.println("Hello world two!");
			// er zit geen parameter, print Hello world two, en returneerd niets terug.
		
		// Run em!
		r1.run();
		r2.run();

	}
}
