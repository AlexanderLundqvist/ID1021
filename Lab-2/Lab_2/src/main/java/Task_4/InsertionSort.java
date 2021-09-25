package Task_4;

/*******************************************************************************
*
* Seminar 2 - Insertion sort for task 4
* @author Alexander Lundqvist
* Created: 22-09-2021
*
* 
* This class implements insertion sort that will be used in later tasks.
* Based on <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Insertion.java.html">Link</a>
* The sorting method only works for primitive integers.
*
*******************************************************************************/

import java.util.Scanner;

public class InsertionSort {
    
    /**
     * Insertion sort that sorts an integer array.
     * 
     * @param array is the array to be sorted
     * @return the swap count
     */
    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) { // i=0 will not execute
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
            insertionSort(array);
            toString(array);
            System.out.println();
        }
    }
}
