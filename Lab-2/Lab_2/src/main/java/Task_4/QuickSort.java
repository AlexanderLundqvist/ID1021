package Task_4;

/*******************************************************************************
*
* Seminar 2 - Quick sort for task 4
* @author Alexander Lundqvist
* Created: 22-09-2021
*
* 
* This class implements quick sort.
* Based on <a href="https://algs4.cs.princeton.edu/23quicksort/Quick.java.html">Link</a>
* The sorting method only works for primitive integers.
*
*******************************************************************************/

import java.util.Scanner;

public class QuickSort {
    
     /**
     * The sorting function for the API. Provides easy function call for the client
     * Relies on auxiliary functions.
     * 
     * @param array is the array to be sorted
     */
    public static void quickSort(int[] array) {
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
        int i = low_index; // subarray low index
        int j = high_index + 1; // subarray high index
        int partitioning_element = array[low_index];    // Choosing left-most element as partitioning element
        
        // {3,4,1,5,2}
        // Partition the subarray  
        while (true) {
            
            // {3,4>,1,5,2}
            // Run until we find element greater than partitioning element   
            while (array[++i] < partitioning_element) {
                if (i == high_index) break; 
            }
            // {3,4>,1,5,2<}
            // Run until we find element less than partitioning element
            while (partitioning_element < array[--j]) {
                if (j == low_index) break;
            }
            
            // If the indexes cross, the subarray is sorted and is ready to swap
            // Partitioning elemet to final position
            if(i >= j) break;
            
            // {3,2*,1,5,4*}
            // Swap the elements found
            swap(array, i, j);
        }
        
        // Swap the partitioning element so it is at the end of the subarray
        swap(array, low_index, j);
        
        // Return the new partitioning index
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
            quickSort(array);
            toString(array);
            System.out.println();
        }
    }
}
