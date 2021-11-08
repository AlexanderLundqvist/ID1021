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
* cutoff to Insertionsort. 
* The versions should use shuffling of the input vs. 
* median-of-three without shuffling. 
* The input should be integer values. 
* Use input that is sorted and random. 
* Vary the input sizes from 100 to 1000000 
* elements with integer values uniformly distributed in the interval [0, 100000] 
* and [0,100] respectively. Make sure your results are statistically 
* significant. 
* The program should take the number of integers N in the input 
* as parameter by the command line arguments (argv). 
* ii) You should be able to show (think graphs) and explain your results. 
* For this experiment you need to use a random number generator and run experiments.
* 
*******************************************************************************/

public class Task_2 {
    
    /**
     * Makes a copy of the original array.
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
     * Creates an array sorted in ascending order where the numbers correspond 
     * to the array index. I.e 1,2,3...n.
     * @param size the size of the array
     * @return the sorted array
     */
    private static int[] populate(int size) {
        int[] sortedArray = new int[size];
        for (int i = 1; i < size - 1; i++)
            sortedArray[i] = i;
        return sortedArray;
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
//        Quicksort sorting = new Quicksort(0);
        
        // testing for randomized array
//        int[] test = {2, 54, 7, 6, 345, 11, 0, 5, 13, 107, 1}; 
        
//        long start = System.currentTimeMillis();
//        sorting.quickSortMedian(test);
//        long end = System.currentTimeMillis();
//        long time = end - start;
        
        
        // Testing with user input
        Scanner input = new Scanner(System.in);
        int cutoff = 10;
        int size;
        int max;
        Long seed;
        
        System.out.println("Testing quicksort with shuffling\n");
        
        System.out.println("Input desired size of array: ");
        size = input.nextInt();
        int[] unsortedArray = new int[size];
        int[] sortedArray = populate(size);
        
//        System.out.println("Input desired cutoff value: ");
//        cutoff = input.nextInt();
        
        System.out.println("Input randomizer seed: ");
        seed = input.nextLong();
        
        System.out.println("Input max value of any element: ");
        max = input.nextInt();
        
        RandomKeyValue randomizer = new RandomKeyValue(size, seed);
        unsortedArray = randomizer.randomizeInt(max, size);
        
        Quicksort sorting = new Quicksort(10);
        
        long start1 = System.currentTimeMillis();
        sorting.quickSortMedian(unsortedArray);
        long end1 = System.currentTimeMillis();
        long time1 = end1 - start1;

        long start2 = System.currentTimeMillis();
        sorting.quickSortShuffle(sortedArray);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - start2;
        
        System.out.println();
        System.out.println("Input max value of any element: " + time1);
        System.out.println("Input max value of any element: " + time2);
    }
}
