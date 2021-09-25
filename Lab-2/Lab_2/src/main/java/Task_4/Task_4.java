package Task_4;

/*******************************************************************************
*
* Seminar 2 - Task 4
* @author Alexander Lundqvist
* Created: 22-09-2021
*
* 
* This class tests computing time for different sorting methods.
*
*
*******************************************************************************/

import static Task_4.InsertionSort.insertionSort;
import static Task_4.MergeSort.mergeSort;
import static Task_4.QuickSort.quickSort;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Task_4 {
    
    /**
     * Makes a copy of the original array.
     * 
     * @param sourceArray is the array that will be duplicated
     * @return the duplicated array
     */
    private static int[] copyArray(int[] sourceArray) {
        int[] copyArray = new int[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++) {
            copyArray[i] = sourceArray[i];
        }
        return copyArray;
    }
    
    /**
     * Main class for testing the different sorting algorithms.
     * 
     * @param args takes no input
     */
    public static void main(String[] args) {
        
        // Create random array to test
        Scanner input = new Scanner(System.in);
        int size = 0;
        System.out.println("Input desired size of array: ");
        size = input.nextInt();          
        int[] array1 = new int[size];
        
        // Populate with random numbers
        Random randomNumber = new Random();
        for (int i = 0; i < array1.length; i++) {
            array1[i] = randomNumber.nextInt(); 
        }
        
        // Make identical copies for equal testing
        int[] array2 = copyArray(array1);
        int[] array3 = copyArray(array1);
        
        /*************** Test methods *****************/
        
        // Insertion sort
        long start1 = System.currentTimeMillis();
        insertionSort(array1);
        long end1 = System.currentTimeMillis();
        long time1 = end1 - start1;
        
        // Merge sort
        long start2 = System.currentTimeMillis();
        mergeSort(array2);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - start2;
        
        // Quick sort
        long start3 = System.currentTimeMillis();
        quickSort(array3);
        long end3 = System.currentTimeMillis();
        long time3 = end3 - start3;
        
        
        // Print time
        System.out.println();
        System.out.println("Execution time for randomized array with size " + size + " in milliseconds.");
        System.out.println();
        System.out.println("Insertion sort: " + time1);
        System.out.println("Merge sort: " + time2);
        System.out.println("Quick sort: " + time3);
        System.out.println();
    }
}
