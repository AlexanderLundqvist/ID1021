package Task_1_2_7;
/*******************************************************************************
*
* Seminar 2 - Insertion sort for task 1,2 and 7
* @author Alexander Lundqvist
* Created: 16-09-2021
*
* 
* This class implements insertion sort that will be used for task 1, 2 and 7.
* Based on <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Insertion.java.html">Link</a>
* The sorting method only works for primitive integers.
*
* 
*
*******************************************************************************/

import java.util.*;

public class InsertionSort_Task_1_2_7 {
    
    /**
     * Insertion sort that sorts an integer array and counts the 
     * amount of swaps.
     * 
     * @param array is the array to be sorted
     * @return the swap count
     */
    public static int insertionSort(int[] array) {
        int swaps = 0;
        for (int i = 0; i < array.length; i++) { // i=0 will not execute
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    swap(array, j, j-1);
                    swaps++;
                } else {
                    break;
                }
                toString(array);
            }
        }
        return swaps;
    }
    
    /**
     * This function calculates the amount of required swaps
     * and prints the swaps BEFORE the array is sorted.
     * The inversions are not the actual operation. Instead it shows what other 
     * element that element i has to pass to get to the right position.
     * 
     * @param array the input array which will be examined
     */
    public static void printInversions(int[] array) {
        int inversions = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length ; j++){
                if(array[i] > array [j]){
                    System.out.println("[index: " + i + ", content: " + 
                                        array[i] + "], [index: " + j + 
                                        ", content: " + array[j] + "]");
                    inversions++;
                }
                else {
                    break;
                }
            }
        }
        System.out.println("Expected amount of inversions: " + inversions);
        System.out.println();
    }
    
    /**
     * Applies insertion sort in descending order on the array. Only works for
     * integer arrays.
     * 
     * @param array is the array to be sorted
     */
    public static int insertionSortDescending(int[] array) {
        negate(array);
        int swaps = insertionSort(array);
        negate(array);
        return swaps;
    }
    
    /**
     * Helper function to the descending sort. 
     * 
     * @param array is the array that will be negated
     */
    private static void negate(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = -array[i];
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
            
            // Task 2
            System.out.println("\nInversions in the array: ");
            printInversions(array);
            
            // Task 1
            System.out.println("\nSorting the array: ");
            int swaps = insertionSort(array);
            System.out.println("\nAmount of swaps: " + swaps);
            
            
            // Task 7
            System.out.println("\nReversing the array: ");
            swaps = insertionSortDescending(array);
            System.out.println("\nArray after sorting: ");
            toString(array);
            System.out.println("\nAmount of swaps: " + swaps);
            System.out.println("\n");
            
        }
    }
}

