package Task_1;

/*******************************************************************************
*
* Seminar 2 - Basic insertion sort class
* @author Alexander Lundqvist
* Created: 16-09-2021
*
* 
* This class implements insertion sort that will be used in later tasks.
* Based on <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Insertion.java.html">Link</a>
* 
* About algorithm
* 
* Comparable
*
*******************************************************************************/

import java.util.*;
import java.util.Comparator; // For comparing objects

public class InsertionSort {
    
    
    
    /**
     * Auxiliary function that formats the array into a readable format with
     * formatting specified in the lab pm.
     * @param array is the array to be sorted
     */
    public static void toString(Comparable[] array) {
        int comma = 1;
        System.out.println();
        System.out.print("Content of array: {");
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
        Integer[] testInt = {5, 4, 3, 2, 1};
        
        toString(testInt);
    }
}
