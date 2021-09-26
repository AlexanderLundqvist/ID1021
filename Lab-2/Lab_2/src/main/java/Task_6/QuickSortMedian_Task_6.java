package Task_6;

import java.util.Scanner;

/*******************************************************************************
*
* Seminar 2 - Task 6
* @author Alexander Lundqvist
* Created: 22-09-2021
*
* 
* This class implements quicksort with median-of-three partitioning.
* Based on <a href="https://algs4.cs.princeton.edu/23quicksort/QuickBars.java.html">Link</a>
* The sorting method only works for primitive integers. 
*
*
*******************************************************************************/

public class QuickSortMedian_Task_6 {
    
    /**
     * The sorting function for the API. Provides easy function call for the client
     * Relies on auxiliary functions.
     * 
     * @param array is the array to be sorted
     */
    public static void quickSort_3(int[] array) {
        sort(array, 0, array.length-1);
    } 
    
    /**
     * Sorts the array recursivly by partitioning the array around a
     * pivot/partitioning element.
     * 
     * @param array is the array to be sorted
     * @param low_index is the low index of the array
     * @param high_index is the high index of the array
     */
    private static void sort(int[] array, int low_index, int high_index) {
        if (high_index <= low_index) return; // Base case for recursive function
        
        // Creating a median of three as partitioning element
        int mid_index = low_index + (high_index - low_index + 1)/2;
        int median = median(array, low_index, mid_index, high_index);
        swap(array, median, low_index); // Replace lowest element with the median element
        
        // Create the partitioning element that will divide the array
        int partitioning_index = partition(array, low_index, high_index);
        
        // Call the function again for each subarray
        sort(array, low_index, partitioning_index-1);
        sort(array, partitioning_index+1, high_index);
        
    }
    
    /**
     * Partitions the input array into two arrays with one containing elements
     * less than the partitioning element and one containing elements greater
     * than the partitioning element.
     * 
     * @param array is the array to be sorted
     * @param low_index is the low index of the array
     * @param high_index is the high index of the array
     * @return the new partitioning element
     */
    private static int partition(int[] array, int low_index, int high_index) {
        int i = low_index;
        int j = high_index + 1;
        int partitioning_element = array[low_index];
        
        while (true) {
            
            while (array[++i] < partitioning_element) {
                if (i == high_index) break; 
            }
            
            while (partitioning_element < array[--j]) {
                if (j == low_index) break;
            }
            
            if(i >= j) break;
            
            swap(array, i, j);
        }
        
        swap(array, low_index, j);
        
        return j;
    }
    
    /**
     * Helper function for easier understanding of sorting code.
     * Swaps place with two elements in the array. 
     */
    private static void swap(int[] array, int i, int j) {
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
    
    /** (3,1,2)
     * Helper function to find the median between 3 elements
     */
    private static int median(int[] array, int low_index, int mid_index, int high_index) {
        int low = array[low_index];
        int mid = array[mid_index];
        int high = array[high_index];
        
        if ((low < mid && mid < high) || (high < mid && mid < low)) {
            return mid_index;
        }
        
        else if ((mid < low && low < high || high < low && low < mid)) {
            return low_index;
        }
        else return high_index;
    }
    
    /**
     * Auxiliary function that formats the array into a readable format with
     * formatting specified in the lab pm.
     * 
     * @param array is the array to be sorted
     */
    public static void toString(int[] array) {
        int comma = 1;
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
            if (comma++ < array.length) {
                System.out.print(", ");
            }
        }
        System.out.print("}");
        System.out.println();
    }
    
    /**
     * Main class with unit tests for the algorithm class.
     * 
     * @param args takes no input
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // Define array size
        while (true) {
            int size = 0;
            System.out.println("Size of array: ");
            try {
                size = input.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input!");
                break;
            }
            int[] array = new int[size];
            
            // Populate the array with user input
            System.out.println("\nInput array elements: ");
            for (int i = 0; i < size; i++) {
                try {
                    array[i] = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Wrong input!");
                    break;
                }
            }
            
            System.out.println("\nArray before sorting: ");
            toString(array);
            
            System.out.println("\nArray after sorting: ");
            quickSort_3(array);
            toString(array);
            System.out.println();
        }
    }
}
