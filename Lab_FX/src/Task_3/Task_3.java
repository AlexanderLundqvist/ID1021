package Task_3;

import Utility.*;

/*********************************** README ************************************
*
* Seminar FX - Sorting tuples
* @author Alexander Lundqvist
* Created: 07-10-2021
*
* About this class:
* This class provides methods for sorting a list of <string, integer> pairs in
* both alphabetical and ascending order. The sorting algorithm implemented is
* a simple merge sort.
* 
*******************************************************************************/

public class Task_3 {
    private final int amount;
    private Pair[] pairs;
    private int size;
    
    // Default constructor
    public Task_3(int amount) {
        this.amount = amount;
        this.pairs = new Pair[amount];
        this.size = 0;
    }
    
    /**
     * Adds a single <String, integer> pair into the list
     * @param string the string
     * @param integer the integer
     */
    public void addPair(String string, int integer) {
        pairs[size] = new Pair(string, integer);
        size++;
    }
    
    /**
     * Adds multiple <String, integer> pairs to the list
     * @param strings the string array
     * @param integers the integer array 
     */
    public void addPairs(String[] strings, int[] integers) {
        for(int i = 0; i < strings.length; i++) {
            pairs[size] = new Pair(strings[i], integers[i]);
            size++;
        }
    }
    
    /**
     * Helper function that returns the size of the pairs list.
     * @return the size
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Sorts the pair list in both algorithmical and numerical order by applying
     * insertion sort in two passes. 
     */
    public void sort() {
        // First pass sorts in numerical order
        for (int i = 0; i < pairs.length; i++) {
            for (int j = i; j > 0; j--) {
                if (pairs[j].getInteger() < pairs[j-1].getInteger()) {
                    swap(pairs, j, j-1);
                } 
                else {
                    break;
                }
            }
        }
        
        // Second pass sorts by alphabetical order
        for (int i = 0; i < pairs.length; i++) { 
            for (int j = i; j > 0; j--) {
                if (pairs[j].getString().compareTo(pairs[j-1].getString()) < 0) {
                    swap(pairs, j, j-1);
                } 
                else {
                    break;
                }
            }
        }
    }
    
    /**
     * Swaps two pairs 
     * @param pairs the list of pairs
     * @param i the first index
     * @param j the second index
     */
    private void swap(Pair[] pairs, int i, int j) {
        Pair temp = pairs[i];
        pairs[i] = pairs[j];
        pairs[j] = temp;
    }
    
    /**
     * Prints the pair list in a readable format.
     */
    public void printList() {
        for(int i = 0; i < pairs.length; i++) {
            pairs[i].print();
        }
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        int AMOUNT = 10;
        long SEED = 100;
        Task_3 test1 = new Task_3(6);
        
        // Testing for manual input
        test1.addPair("B", 47);
        test1.addPair("K", 97);
        test1.addPair("A", 12);
        test1.addPair("B", 567);
        test1.addPair("A", 32);
        test1.addPair("K", 4);
        System.out.println("List before sorting");
        test1.printList();
        System.out.println();
        
        // Sort then print
        System.out.println("List after sorting");
        test1.sort();
        test1.printList();
        System.out.println();

        // Testing for randomized <String, integer> pairs
        RandomKeyValue randomizer = new RandomKeyValue(AMOUNT, SEED);
        Task_3 test2 = new Task_3(AMOUNT);
        // Create the pair list from randomizer
        test2.addPairs(randomizer.randomizeString(), randomizer.randomizeInt());
        System.out.println("List before sorting");
        test2.printList(); // Print list first to see initial list
        System.out.println();
        
        // Sort then print
        System.out.println("List before sorting");
        test2.sort();
        test2.printList();
        System.out.println();        
    }
}
