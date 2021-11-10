package Task_4;

import Utility.SequentialSearchST;
import java.util.Scanner;

/*********************************** README ************************************
*
* Seminar FX - Task 4: k:th most common word
* @author Alexander Lundqvist
* Created: 07-10-2021
*
* About this class:
* This class implements a hash table with separate chaining. It is primarily used
* for finding frequencies of specified words in a given text file. 
*
* Based on:
* <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/SeparateChainingHashST.java.html">Link</a>
*
* Implement a program which takes as input a text file and allows the user to 
* repeatedly ask questions: 
* i) Which is the k:th most common word
* ii) Which are the k:th to the k+n:th most common words
* Use https://introcs.cs.princeton.edu/java/data/leipzig/leipzig1m.txt  as input. 
* The time to build the index must not exceed four minutes.
* 
*******************************************************************************/

public class Task_4<Key, Value> {
    private static final int DEFAULT_CAPACITY = 4;          // Default capacity
    private int amountOfPairs;                              // number of key-value pairs
    private int tableSize;                                  // hash table size
    private SequentialSearchST<Key, Value>[] symbolTables;  // array of linked-list symbol tables    
    
    
    public Task_4() {
        
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        Task_4 hashTable = new Task_4();

        
        // Simple test. The frequencies in test.txt has been verified with other
        // software.
        String PATH = "test.txt";
        String DELIMITER = " ";
        
        // Find 3 different frequencies
        //
        //
        //
        
        
//        String PATH = "test.txt";
//        String DELIMITER = " ";
        Scanner input = new Scanner(System.in);
        int choice;
        int size = 5;
        
        // Infinite loop to examine different frequencies. No error handling.
        while (true) {
            System.out.println("Hash table has been constructed!");
            System.out.println("Hash table size is " + size);
            System.out.println("Input any positive integer in the interval [1, " +  size + "] to find the k:th most common word");
            System.out.println("");
            choice = input.nextInt();
            //System.out.println("The " + choice + " most common word is: " + souhashTable.find(choice));
        }
        
    }
}
