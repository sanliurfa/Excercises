/**
 * 
 */
package upcastingdowncasting;


class Machine {
	public void start(){
		System.out.println("Machine started");
	}
}

class Camera extends Machine {
	public void start(){
		System.out.println("Camera started");
	}
	
	public static void snap(){
		System.out.println("Photo taken");
	}
	
}



/**
 * @author ro-goki
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Machine machine1 = new Machine();
		Camera camera1 = new Camera();
		
		machine1.start();
		camera1.start();
		camera1.snap();
		
		//upcasting
		Machine machine2 = camera1; //polymorphism: new Camera(); dit is gelijk aan camera1.
		machine2.start(); //Hierbij roept het de start van CAMERA aan.
		// Maar machine2.snap() zal niet werken . 
		// Dit komt omdat het een machine2 aangemaakt wordt van een object Camera, maar omdat het type een Machine is, 
		// die zelf geen snap() heeft, kan het geen machine2.snap() aanroepen.
		
		
		//Downcasting
		Machine machine3 = new Camera();
		//Camera camera2 = machine3; dit is downcasting, maar hier wordt een foutmelding weergegeven maar omdat het een 
		// downcasting is van een type Machine variabele, wil java een goedkeuring aan de hand van een casting dus;
		Camera camera2 = (Camera)machine3;
		// en nu kan er wel een snap() opgevraagd worden omdat de variabele camera2 een type van Camere is.
		camera2.snap();
		
		
		Machine machine4 = new Machine();
		//Camera camera3 = (Camera)machine4; // ik wil hier een Machine variabele downcastin naar een Camera variabele.
		// Maar wanneer ik dit uitvoer krijg ik een runtime exception. 
		
		/* Conclusie: 
		 * 1. Upcasting gaat goed. Child object naar een variabele van het type Parent. Er hoeft niet gecast te worden.
		 * 2. Downcasting een child object van het type Parent; kan maar je moet specifiek casten.
		 * 	  Je krijgt dan ook alleen die methoden die de Parent ook heeft maar dan van de child.
		 * 3. Downcasting van een parent object van het type Parent gaat niet. Je krijgt dan een Runtime error.
		 * 
		 */
		
		

	}

}
