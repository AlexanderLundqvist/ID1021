package Task_6;

/*******************************************************************************
*
* Seminar 2 - Task 6
* @author Alexander Lundqvist
* Created: 22-09-2021
*
* 
* This class compares quicksort to quicksort with median of three partitioning.
*
*
*******************************************************************************/

import static Task_6.QuickSortMedian_Task_6.quickSort_3;
import static Task_4.QuickSort.quickSort;
import java.util.Random;
import java.util.Scanner;

public class Task_6 {

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
        
        // Quicksort with pivot at left elemet
        long start1 = System.currentTimeMillis();
        quickSort(array1);
        long end1 = System.currentTimeMillis();
        long time1 = end1 - start1;
        
        // Median of three quicksort
        long start2 = System.currentTimeMillis();
        quickSort_3(array2);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - start2;
                
        // Print time
        System.out.println();
        System.out.println("Execution time for randomized array with size " + size + " in milliseconds.");
        System.out.println();
        System.out.println("Quicksort: " + time1);
        System.out.println("Median-of-three: " + time2);
        System.out.println();
    }

}
