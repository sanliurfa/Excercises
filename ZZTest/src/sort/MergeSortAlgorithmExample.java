package sort;


/**
 *  write a program to do Merge Sort of array in java.
 */
public class MergeSortAlgorithmExample {
 
    static int[] ar = { 54, 13, 24, 19, 11, 3, 71, 8 };
    
    /**
     * Main method which calls merge sort in java
     * @param args
     */
    public static void main(String[] args) {
           
           System.out.print("Display array before Merge sorting: "  );
           for (int i = 0; i < ar.length; i++)
                  System.out.print(ar[i] +" ");
           
           int[] ar2 = new int[ar.length];
           mergeSort(ar2, 0, ar.length - 1);
           
           System.out.print("\nDisplay array after Merge sort: "  );
           for (int i = 0; i < ar.length; i++)
                  System.out.print(ar[i] +" ");
            
    }
 
    /*
     * method performs merge sort in java.
     */
    static void mergeSort(int[] workSpace, int lowerBound, int upperBound) {
 
           if (lowerBound == upperBound){
                  return;    //no need to sort further.
           }else {    // finding mid point
                  int midPoint = (lowerBound + upperBound) / 2;
                  mergeSort(workSpace, lowerBound, midPoint); // sorting low half
                  mergeSort(workSpace, midPoint + 1, upperBound); // sort upper half
                  merging(workSpace, lowerBound, midPoint + 1, upperBound);//merging them
           }
    }
    
    
    static void merging(int[] ar2, int low, int high, int upperBound) {
           
           int midPoint = high - 1;
           int lowerBound = low;
           int n = upperBound - lowerBound + 1;
           int i = 0;
           
           while (low <= midPoint && high <= upperBound)
                  if (ar[low] < ar[high])
                        ar2[i++] = ar[low++];
                  else
                        ar2[i++] = ar[high++];
           
           while (low <= midPoint)
                  ar2[i++] = ar[low++];
           
           while (high <= upperBound)
                  ar2[i++] = ar[high++];
           
           for (i = 0; i < n; i++)
                  ar[lowerBound + i] = ar2[i];
           
    }
}
/*OUTPUT
 
Display array before Merge sorting: 54 13 24 19 11 3 71 8
Display array after Merge sort: 3 8 11 13 19 24 54 71
 
*/
