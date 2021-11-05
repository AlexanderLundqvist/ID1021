package Task_3;

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
* Based on:
* <a href="">Link</a>
*
* Implement a program which can sort input consisting of: <string, integer>
* The input should be of the format:
* 6
* B 47
* K 97
* A 12
* B 567
* A 32
* K 4
*
* The result of the sorting should be sorted by the string and then by the integer associated with the string:
*
* A 12
* A 32
* B 47
* B 567
* K 4
* K 97
*
* The program should read the input from stdin with the number of tuples to 
* sort (N) first followed by the tuples to sort. You should also write a program 
* to generate the input. That program should take the number of tuples and a 
* random number seed as inputs from the command line arguments (argv).
* 
*******************************************************************************/

public class Task_3<Pair extends Comparable<Pair>> {
    private final int amount;
    private String[] strings;
    private int[] integers;
    private Pair[] pairs;
    private int size;
    
    // Default constructor
    public Task_3(int amount) {
        this.amount = amount;
        this.pairs = (Pair[]) new Comparable[amount];
        this.size = 0;
    }
    
    private class Pair {
        private String string;
        private int integer;
        
        public Pair(String string, int integer) {
            this.string = string;
            this.integer = integer;
        }
        
        public void print() {
            System.out.println(this.string + " " + this.integer);
        }
    }
    
    public void addPair(String string, int integer) {
        pairs[size] = new Pair(string, integer);
        size++;
    }
    
    public int size() {
        return this.size;
    }
    
    public void sort() {
        
    }
    
    public void printList() {
        
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     * 
     * B 47
     * K 97
     * A 12
     * B 567
     * A 32
     * K 4
     */    
    public static void main(String[] args) {
        Task_3 test = new Task_3(6);
        
        test.addPair("B", 47);
        test.addPair("K", 97);
        test.addPair("A", 12);
        test.addPair("B", 567);
        test.addPair("A", 32);
        test.addPair("K", 4);
    }
}
