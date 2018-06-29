package sort;

/**
 * This class holds reference of array,
 * which has to be sorted.
 * And performs Bubble sorting in java
 */
class BubbleSortArray {
    
    private int[] ar;
    private int index; //holds current position of array, by default it is initialized with 0
    
    /**
     * Constructor for initializing Array
     */
    public BubbleSortArray(int maxSize) // constructor
    {
           ar = new int[maxSize]; // creation of array
           index = 0;
    }
 
    /**
     * This method inserts elements in Array.
     */
    public void insert(int value) {
           ar[index++] = value; // increment the current index
    }
 
    /**
     * This method Sort Array using Bubble Sort
     */
    public void bubbleSort(){
           int outer, innner;
           for (outer = index - 1; outer > 0; outer--) // outer loop (in backward direction)
                  for (innner = 0; innner < outer; innner++)// inner loop (in forward direction)
                        if (ar[innner] > ar[innner + 1]) // out of order?
                               swap(innner, innner + 1); // swap them
    } //End bubble sort method
    
 
    /**
     * This method swaps two elements in Array
     */
    private void swap(int pos1, int pos2) {
           int temp = ar[pos1];
           ar[pos1] = ar[pos2];
           ar[pos2] = temp;
    }
    
 
    /**
     * This method Display Array
     */
    public void display() {
           for (int i = 0; i < index; i++)
                  System.out.print(ar[i] + " ");
           System.out.println("");
    }
 
 
}
 
