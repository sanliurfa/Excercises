/**
 * 
 */
package lecture50serializingarrays;

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
		
		Person [] people = {new Person(1, "Sue"),
		new Person(99, "Mike"),
		new Person(7, "Bob")};
		
		ArrayList<Person> peopleList = new ArrayList<Person>(Arrays.asList(people));
		
		
		try(FileOutputStream fo = new FileOutputStream("test.ser")){
			
			ObjectOutputStream os = new ObjectOutputStream(fo);
			
			os.writeObject(people);
			
			os.writeObject(peopleList);
			
			os.writeInt(peopleList.size());
			for(Person person : peopleList){
				os.writeObject(person);
			}
			
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
