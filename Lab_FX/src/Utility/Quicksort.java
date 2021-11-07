package Utility;

import edu.princeton.cs.algs4.StdRandom;

/*********************************** README ************************************
*
* Seminar FX - Quicksort
* @author Alexander Lundqvist
* Created: 06-11-2021
*
* About this class:
* This class implements two different ways of quicksort with cutoff to 
* insertion sort. 
*
* Based on:
* <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Quick.java.html">Link</a>
*
*******************************************************************************/

public class Quicksort {
    private final int CUTOFF;
    
    /**
     * Creates an instance of the quicksort object.
     * @param cutoff is the cutoff value
     */
    public Quicksort(int cutoff) {
        this.CUTOFF = cutoff;
    }
    
    /**
     * The quicksort that uses median-of-three partitioning.
     * @param array is the array to be sorted
     */
    public void quickSortMedian(int[] array) {
        sortMedian(array, 0, array.length-1);
    }
    
    /**
     * The quicksort that uses shuffling of the input
     * @param array 
     */
    public void quickSortShuffle(int[] array) {
        StdRandom.shuffle(array);
        sort(array, 0, array.length-1);
    }
    
    /**
     * Sorts the array recursivly by partitioning the array around a
     * pivot/partitioning element and also using the median-of-three
     * partitioning method.
     * @param array is the array to be sorted
     * @param low_index is the low index of the array
     * @param high_index is the high index of the array
     */
    private void sortMedian(int[] array, int low_index, int high_index) {
        if (high_index <= low_index) return; // Base case for recursive function
        
        // Check if the subarray is the desired size for cutting of to insertion sort
        if (high_index <= low_index + CUTOFF) {
            insertionsort(array, low_index, high_index + 1);
            return;
        }
        
        // Creating a median of three as partitioning element
        int mid_index = low_index + (high_index - low_index + 1)/2;
        int median = median(array, low_index, mid_index, high_index);
        swap(array, median, low_index); // Replace lowest element with the median element
        
        // Create the partitioning element that will divide the array
        int partitioning_index = partition(array, low_index, high_index);
        
        // Call the function again for each subarray
        sortMedian(array, low_index, partitioning_index-1);
        sortMedian(array, partitioning_index+1, high_index);
        
    }
    
    /**
     * Sorts the array recursivly by partitioning the array around a
     * pivot/partitioning element.
     * @param array is the array to be sorted
     * @param low_index is the low index of the array
     * @param high_index is the high index of the array
     */
    private void sort(int[] array, int low_index, int high_index) {
        if (high_index <= low_index) return; // Base case for recursive function
        
        // Check if the subarray is the desired size for cutting of to insertion sort
        if (high_index <= low_index + CUTOFF) {
            insertionsort(array, low_index, high_index + 1);
            return;
        }
        
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
     * @param array is the array to be sorted
     * @param low_index is the low index of the array
     * @param high_index is the high index of the array
     * @return the new partitioning element
     */
    private int partition(int[] array, int low_index, int high_index) {
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
     * Swaps place with two elements in the array. 
     */
    private void swap(int[] array, int i, int j) {
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
    
    /**
     * Helper function to find the median between 3 elements in a subarray
     */
    private int median(int[] array, int low_index, int mid_index, int high_index) {
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
     * Helper method for the main sorting methods. Insertion sort
     * for the cutoff.
     * @param array the array to be sorted
     * @param low_index the low index of array
     * @param high_index the high index of array  
     */
    private void insertionsort(int[] array, int low_index, int high_index) {
        for (int i = low_index; i < high_index; i++) {
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
     * Checks if the array is sorted.
     * @param array the array
     * @return false if not sorted
     */
    public boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++)
            if (array[i] < array[i-1]) return false;
        return true;
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
    
    public static void main(String[] args) {
        int[] array1 = {5,3,14,2,66,7,8,76,99,123,0,23,91,60,18,37,8};
        int[] array2 = {5,3,14,2,66,7,8,76,99,123,0,23,91,60,18,37,8};

        
        Quicksort test = new Quicksort(3);
        
        System.out.println("Before sorting");
        test.toString(array1);
        
        test.quickSortMedian(array1);
        
        System.out.println("After sorting");
        if (test.isSorted(array1)) test.toString(array1);
        else System.out.println("Not sorted!");
        test.toString(array1);

        
        System.out.println();
        
        System.out.println("Before sorting");
        test.toString(array2);
        
        test.quickSortShuffle(array2);
        
        System.out.println("After sorting");
        if (test.isSorted(array2)) test.toString(array2);
        else System.out.println("Not sorted!");
        test.toString(array2);

    }
}
