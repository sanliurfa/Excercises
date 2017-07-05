/**
 * 
 */
package lector46innerclass;

/**
 * @author ro-goki
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Robot robot = new Robot(7);
		robot.start();
		
	//	Robot.Brain brain = robot.new Brain();
	//	brain.think();
		
		Robot.Battery battery = new Robot.Battery();
		battery.charge();
		

	}

}
