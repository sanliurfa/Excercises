/**
 * 
 */
package lecture51transient;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ro-goki
 * 
 */
public class WriteObjects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Writing objects...");

		Person person = new Person(7, "Bob");
		person.setCount(88);
		

		try (FileOutputStream fo = new FileOutputStream("test2.ser")) {

			ObjectOutputStream os = new ObjectOutputStream(fo);

			os.writeObject(person);

			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
