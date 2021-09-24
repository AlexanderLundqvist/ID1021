package Task_4;

/*******************************************************************************
*
* Seminar 2 - Merge sort for task 4
* @author Alexander Lundqvist
* Created: 22-09-2021
*
* 
* This class implements merge sort with top down implementation.
* Based on <a href="https://algs4.cs.princeton.edu/22mergesort/Merge.java.html">Link</a>
* and <a href="https://algs4.cs.princeton.edu/22mergesort/MergeX.java.html">Link</a>
* The sorting method only works for primitive integers.
*
* 
* 
*
*******************************************************************************/

import java.util.Scanner;

public class MergeSort {
    
    /**
     * The sorting function for the API. Provides easy function call for the client
     * Relies on auxiliary functions.
     * 
     * @param array is the array to be sorted
     */
    public static void sort(int[] array) {
        int[] aux = new int[array.length];
        sort(array, aux, 0, array.length-1); // Length-1 for last index
    }
    
    /**
     * This recursive function divides the array into several sub arrays that 
     * will be sorted and the recursively merged together.
     * 
     * @param array the sub array that will be sorted
     * @param aux auxiliary array to store the sorted result
     * @param low index of array
     * @param high index of array
     */
    private static void sort(int[] array, int[] aux, int low, int high) {
        if (high <= low) return;            // Base case for the recursive function
        int mid = low + (high-low)/2;       // Mid needs to be calculated like this to account for the right/end partial array
        sort(array, aux, low, mid);         // Sort first sub array
        sort(array, aux, mid+1, high);      // Sort second subarray
        merge(array, aux, low, mid, high);  // Merge the sorted subarrays
    }
    
    /**
     * This function merges to sorted arrays together.
     * 
     * @param array sub array to merge into auxiliary array
     * @param aux auxiliary array with results
     * @param low_index index of array
     * @param mid_index index of array
     * @param high_index index of array 
     */
    private static void merge(int[] array, int[] aux, int low_index, int mid_index, int high_index) {
        
        // Copy the input array into auxiliary for the sorting process
        for (int index = low_index; index <= high_index; index++) {
            aux[index] = array[index];
        }
        
        // Need explanation
        int i = low_index;
        int j = mid_index + 1;
        for (int index = low_index; index <= high_index; index++) {
            if      (i > mid_index)     array[index] = aux[j++]; //
            else if (j > high_index)    array[index] = aux[i++]; //
            else if (aux[j] < aux[i])   array[index] = aux[j++]; //
            else                        array[index] = aux[i++]; //
        }
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
        
        /*
        int[] test = {5,4,3,2,1};
        toString(test);
        sort(test);
        toString(test);
        */
        
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
            sort(array);
            toString(array);
        }
        
    }
}
