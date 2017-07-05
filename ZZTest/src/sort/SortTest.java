/**
 * 
 */
package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author ro-goki
 *
 */
public class SortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Date> datums = new ArrayList<>();

		sorteer(datums);
	}

	public static void sorteer(List<Date> datums) {
		Collections.sort(datums, new Comparator<Date>() {
			@Override
			public int compare(Date datum1, Date datum2) {
				return (int) Math.signum(datum1.getTime() - datum2.getTime());
			}
		});
	}

	public static void test() {

	}
}