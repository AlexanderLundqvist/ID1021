/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task_5;

/*******************************************************************************
*
* Seminar 2 - Merge sort for task 5
* @author Alexander Lundqvist
* Created: 22-09-2021
*
* 
* This class implements merge sort with cutoff to insertion sort.
* Based on <a href="https://algs4.cs.princeton.edu/22mergesort/Merge.java.html">Link</a>
* and <a href="https://algs4.cs.princeton.edu/22mergesort/MergeX.java.html">Link</a>
* The sorting method only works for primitive integers.
*
*******************************************************************************/

import java.util.Random;
import java.util.Scanner;

public class MergeSortCutoff_Task_5 {
    private static final int CUTOFF_INDEX = 0;
    
    /**
     * The sorting function for the API. Provides easy function call for the client
     * Relies on auxiliary functions.
     * 
     * @param array is the array to be sorted
     */
    public static void mergeSortX(int[] array) {
        int[] aux = new int[array.length];
        sort(array, aux, 0, array.length-1); // Length-1 for last index
    }
    
    /**
     * This recursive function divides the array into several sub arrays that 
     * will be sorted and the recursively merged together.
     * 
     * @param array the sub array that will be sorted
     * @param aux auxiliary array to store the sorted result
     * @param low_index index of array
     * @param high_index index of array
     */
    private static void sort(int[] array, int[] aux, int low_index, int high_index) {
        if (high_index <= low_index) return;            // Base case for the recursive function
        if () {
            insertionSort(array, low_index, high_index);
        }
        int mid = low_index + (high_index-low_index)/2;     // Mid needs to be calculated like this to account for the right/end partial array      
        sort(array, aux, low_index, mid);                   // Sort first sub array
        sort(array, aux, mid+1, high_index);                // Sort second subarray
        merge(array, aux, low_index, mid, high_index);      // Merge the sorted subarrays
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
        int i = low_index;      //
        int j = mid_index + 1;  //
        for (int index = low_index; index <= high_index; index++) {
            if      (i > mid_index)     array[index] = aux[j++]; //
            else if (j > high_index)    array[index] = aux[i++]; //
            else if (aux[j] < aux[i])   array[index] = aux[j++]; //
            else                        array[index] = aux[i++]; //
        }
    }
    
    /**
     * Insertion sort that sorts an integer array.
     * 
     * @param array is the array to be sorted
     * @return the swap count
     */
    private static void insertionSort(int[] array, int low_index, int high_index) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    swap(array, j, j-1);
                } 
                else {
                    break;
                }
            }
        }
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
        
        /********* To verify algorithm **********/
        
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
            mergeSortX(array);
            toString(array);
            System.out.println();
        }
        
    }
}
