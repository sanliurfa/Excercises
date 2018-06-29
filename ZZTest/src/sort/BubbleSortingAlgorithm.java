package sort;

/**
 * Main class - Which will call BubbleSorting class
 */
public class BubbleSortingAlgorithm {
    public static void main(String[] args) {
           
           int maxSize = 10; // initial size of Array
           
           BubbleSortArray bubbleSortArray =
                        new BubbleSortArray(maxSize); // creation of array
           
           bubbleSortArray.insert(21);
           bubbleSortArray.insert(1);
           bubbleSortArray.insert(31);
           bubbleSortArray.insert(51);
           bubbleSortArray.insert(41);
           bubbleSortArray.insert(91);
           bubbleSortArray.insert(61);
           bubbleSortArray.insert(32);
           bubbleSortArray.insert(36);
           bubbleSortArray.insert(93);
    
           System.out.print("Display Array elements before bubble sorting: ");
           bubbleSortArray.display(); // display Array elements before sorting
           
           bubbleSortArray.bubbleSort(); // bubble sort the array
           
           System.out.print("Display Array elements after bubble sorting: ");
           bubbleSortArray.display(); // display Array elements after sorting
    }
}
 
/** OUTPUT
 
Display Array elements before bubble sorting: 21 1 31 51 41 91 61 32 36 93
Display Array elements after bubble sorting: 1 21 31 32 36 41 51 61 91 93
 
*/

