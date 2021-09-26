package Task_5;

/*******************************************************************************
*
* Seminar 2 - Task 5
* @author Alexander Lundqvist
* Created: 22-09-2021
*
* 
* This class tests merge sort with different values of cutoff to insertion sort.
*
*
*******************************************************************************/

import static Task_5.MergeSortCutoff_Task_5.mergeSortX;
import java.util.Random;
import java.util.Scanner;

public class Task_5 {
    
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
        
        // Create random array1 to test
        Scanner input = new Scanner(System.in);
        int size = 0;
        int cutoff = 0;
        System.out.println("Input desired size of array: ");
        size = input.nextInt();
        System.out.println("Input cutoff value: ");
        cutoff = input.nextInt();
        int[] array1 = new int[size];
        
        // Populate with random numbers
        Random randomNumber = new Random();
        for (int i = 0; i < array1.length; i++) {
            array1[i] = randomNumber.nextInt(); 
        }
        
        // Make identical copies for equal testing
        int[] array2 = copyArray(array1);
        int[] array3 = copyArray(array1);
        
        // Insertion sort
        long start1 = System.currentTimeMillis();
        mergeSortX(array1, cutoff);
        long end1 = System.currentTimeMillis();
        long time1 = end1 - start1;
        
        // Merge sort
        long start2 = System.currentTimeMillis();
        mergeSortX(array2, cutoff);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - start2;
        
        // Quick sort
        long start3 = System.currentTimeMillis();
        mergeSortX(array3, cutoff);
        long end3 = System.currentTimeMillis();
        long time3 = end3 - start3;
                
        // Print time
        System.out.println();
        System.out.println("Execution time for randomized array with size " + size + " in milliseconds.");
        System.out.println();
        System.out.println("Cutoff value: " + cutoff);
        System.out.println("Time 1: " + time1);
        System.out.println("Time 2: " + time2);
        System.out.println("Time 3: " + time3);
        System.out.println();
    }
}
