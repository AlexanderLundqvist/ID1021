package Task_1_2_7;
/*******************************************************************************
*
* Seminar 2 - Insertion sort for task 1,2 and 7
* @author Alexander Lundqvist
* Created: 16-09-2021
*
* 
* This class implements insertion sort that will be used in later tasks.
* Based on <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Insertion.java.html">Link</a>
* The sorting method only works for primitive integers.
*
* 
* About algorithm
* 
*
*******************************************************************************/

import java.util.*;

public class InsertionSort {
    
    /**
     * Insertion sort that sorts an integer array and counts the 
     * amount of swaps.
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
     * @param array the input array which will be examined
     * 
     * System.out.println("[index: " + indexPointer + ", content: " + 
                                        array[indexPointer] + "], [index: " + j + 
                                        ", content: " + array[j] + "]");
     */
    public static void printInversions(int[] array) {
        int inversions = 0;
        int indexPointerPrev, indexPointerNext;
        for (int i = 0; i < array.length; i++) {
            c = i;
            indexPointerNext = i + 1;
            while (indexPointerNext > 0) {
                if (array[indexPointerNext] < array[indexPointerPrev]) {
                    System.out.println("[index: " + indexPointerNext + ", content: " + 
                                        array[indexPointerNext] + "], [index: " + indexPointerPrev + 
                                        ", content: " + array[indexPointerPrev] + "]");
                    inversions++;
                    indexPointerPrev--;
                    indexPointerNext--;
                } 
                else {
                    break;
                } 
            }
        }
        System.out.println("Expected amount of inversions: " + inversions);
    }
    
    /**
     * Applies insertion sort in descending order on the array.
     * @param array is the array to be sorted
     */
    public static void insertionSortDescending(int[] array) {
        
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
     * @param args takes no input
     */
    public static void main(String[] args) {
        int[] test = {5, 4, 3, 2, 1}; // For quick testing                
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
            System.out.println("\n");
        }
    }
}

