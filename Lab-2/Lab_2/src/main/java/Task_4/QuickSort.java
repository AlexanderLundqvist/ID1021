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
    public static void sort(int[] array) {
        
    } 
    
    /**
     * 
     * @param array
     * @param low_index
     * @param high_index 
     */
    private static void sort(int[] array, int low_index, int high_index) {
        
    }
    
    /**
     * 
     * @param array
     * @param low_index
     * @param high_index 
     */
    private static void partition(int[] array, int low_index, int high_index) {
        
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
            sort(array);
            toString(array);
        }
    }
}
