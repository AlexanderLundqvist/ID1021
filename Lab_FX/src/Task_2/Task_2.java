package Task_2;

import Utility.*;
import java.util.Scanner;

/*********************************** README ************************************
*
* Task 2 - Quicksort with cutoff
* @author Alexander Lundqvist
* Created: 07-10-2021
*
* About this class:
* This class uses two versions of Quicksort with cutoff to Insertionsort and 
* randomized input to measure execution time of the algorithms.
*
* Based on:
* <a href="">Link</a>
*
* i) Compare/evaluate the execution time of two versions of Quicksort with 
* cutoff to Insertionsort. The versions should use shuffling of the input vs. 
* median-of-three without shuffling. The input should be integer values. 
* Use input that is sorted and random. Vary the input sizes from 100 to 1000000 
* elements with integer values uniformly distributed in the interval [0, 100000] 
* and [0,100] respectively. Make sure your results are statistically 
* significant. The program should take the number of integers N in the input 
* as parameter by the command line arguments (argv). 
* ii) You should be able to show (think graphs) and explain your results. 
* For this experiment you need to use a random number generator and run experiments.
* 
*******************************************************************************/

public class Task_2 {
    
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
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        // Testing for hardcoded variables
        int[] test = {2, 54, 7, 6, 345, 11, 0, 5, 13, 107, 1}; 
        
        long start1 = System.currentTimeMillis();
        quickSort(test);
        long end1 = System.currentTimeMillis();
        long time1 = end1 - start1;
        
        
        // Testing with user input
        Scanner input = new Scanner(System.in);
        int size;
        int max;
        Long seed;
        
        System.out.println("Input desired size of array: ");
        size = input.nextInt();
        int[] array1 = new int[size];
        
        System.out.println("Input max value of individual element: ");
        max = input.nextInt();
        
        System.out.println("Input desired size of array: ");
        seed = input.nextLong();
    }
}
