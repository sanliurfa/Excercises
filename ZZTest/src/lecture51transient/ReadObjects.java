/**
 * 
 */
package lecture51transient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author ro-goki
 *
 */
public class ReadObjects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Reading objects..... ");
		
		try(FileInputStream fi = new FileInputStream("test2.ser")){
			
			ObjectInputStream os = new ObjectInputStream(fi);
			
			Person person = (Person)os.readObject();
			
			System.out.println(person);

			
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
