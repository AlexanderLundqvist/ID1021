package Task_4;

import Utility.LinearProbingHashST;
import Utility.Pair;
import Utility.Quicksort;
import Utility.SequentialSearchST;
import edu.princeton.cs.algs4.Queue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*********************************** README ************************************
*
* Seminar FX - Task 4: k:th most common word
* @author Alexander Lundqvist
* Created: 07-10-2021
*
* About this class:
* This class reads a textfile and and counts the frequency of every unique word.
* It then lets the user ask questions such as "Which is the k:th most common word"
* and "Which are the k:th to the k+n:th most common words".
*
* Implement a program which takes as input a text file and allows the user to 
* repeatedly ask questions: 
* i) Which is the k:th most common word
* ii) Which are the k:th to the k+n:th most common words
* Use https://introcs.cs.princeton.edu/java/data/leipzig/leipzig1m.txt  as input. 
* The time to build the index must not exceed four minutes.
* 
*******************************************************************************/

public class Task_4 {
    
    /**
     * Insertion sort on two arrays
     * @param strings the array
     * @param integers the array 
     */
    public static void sort(String[] strings, Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (integers[j].intValue() < integers[j-1].intValue()) {
                    swap(strings, integers, j, j-1);
                } 
                else {
                    break;
                }
            }
        }
    }
    
    /**
     * Swaps places between two indexes in two arrays simultaneously
     * @param strings the array
     * @param integers the array
     * @param i the index
     * @param j the index
     */
    public static void swap(String[] strings, Integer[] integers, int i, int j) {
        int temp = integers[i];
        integers[i] = integers[j];
        integers[j] = temp;
        
        String tempString = strings[i];
        strings[i] = strings[j];
        strings[j] = tempString;
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) throws FileNotFoundException {
        // Test with reduced file
        // Verified with other software
        // 1:st common word = the (25)
        // 4:th common word = to (14)
        // 7th common word = said (6)
        String PATH = "test.txt";
        
        // Execute with correct file
        // String PATH = "leipzig1m.txt";
        Scanner reader = new Scanner(new File(PATH));
        reader.useDelimiter(" +");
        LinearProbingHashST<String, Integer> hashTable = new LinearProbingHashST<>();
        
        int minlen           = 0;
        int distinct         = 0;
        int amountOfWords    = 0;
        
        // Build the hash table
        long start = System.nanoTime();
        while (reader.hasNext()) {
            String word = reader.next().toLowerCase();
            if (hashTable.contains(word)) {
                hashTable.put(word, (hashTable.get(word) + 1));
                amountOfWords++;
            }
            else {
                hashTable.put(word, 1);
                amountOfWords++;
                distinct++;
            }
        }
        
        System.out.println(distinct);
        System.out.println(amountOfWords);
        if(hashTable.contains("the")) System.out.println("HEJ");
        
        // Get the keys and values for sorting
        Object[] temp = hashTable.getKeys();
        String[] words = new String[temp.length];
        for (int i = 0; i < temp.length; i++) {
            words[i]  = (String) temp[i];
        }
        
        Object[] tempFreq = hashTable.getValues();
        Integer[] frequencies = new Integer[tempFreq.length];
        for (int i = 0; i < tempFreq.length; i++) {
            frequencies[i]  = (Integer) tempFreq[i];
        }
        sort(words, frequencies);
        
        long end = System.nanoTime();
        System.out.println("Time to build index = " + (end-start));
        
        // Continous loop that lets the user find frequencies
//        Scanner input = new Scanner(System.in);
//        int run = 1;
//        while (run != 0) {
//            int choice;
//            System.out.println("The table has " + distinct + " unique words");
//            System.out.println("1 for single word, 2 for multiple words");
//            choice = input.nextInt();
//            switch (choice) {
//                case 1:
//                    System.out.println("Enter the k:th most common word of you choice");
//                    int k = input.nextInt();
//                    System.out.println("The " + k + ":th most common word is " +  words[words.length - k]); // Due to ascending order in array
//                    System.out.println("\nEnter 0 to end program");
//                    run = input.nextInt();
//                    break;
//                    
//                case 2:
//                    System.out.println("Enter the k:th to k+n:th most common words of you choice");
//                    int kth = input.nextInt();
//                    int knth = input.nextInt();
//                    for (int i = kth; kth < knth; kth++) {
//                        // PRint
//                    }
//                    System.out.println("\nEnter 0 to end program");
//                    run = input.nextInt();
//                    break;
//            }
//        }
    }
}
