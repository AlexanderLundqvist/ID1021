package Task_2;

/*********************************** README ************************************
*
* Seminar 3 - Task 2 Binary search symbol table (ordered array symbol table)
* @author Alexander Lundqvist
* Created: 30-09-2021
*
* 
* This class implements a binary search symbol table with minimal functionality.
* Error handling is not implemented for the most part.
* Based on:
* <a href="https://algs4.cs.princeton.edu/31elementary/BinarySearchST.java.html">Link</a>
*
* Use the first thousand words from the text to measure the running time of the 
* ordered array ST (also known as binary search symbol table, see algorithm 3.2 
* in the book (obs not chapter 3.2)). Use the FrequencyCounter from page 372 as 
* test program (you may need to change how you read the words if you do not use 
* the libraries from Sedgewick&Wayne). Show tables or graphs of your measurements.
* 
*******************************************************************************/

public class BinarySearchSymbolTableTask2<Key extends Comparable<Key>, Value> {
    private static final int DEFAULT_CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int size = 0;
    
    // Initializes an empty symbol table with default size
    public BinarySearchSymbolTableTask2(){
        keys   = (Key[]) new Comparable[DEFAULT_CAPACITY]; 
        values = (Value[]) new Object[DEFAULT_CAPACITY];
    }
    
    // Initializes an empty symbol table with specified capacity
    public BinarySearchSymbolTableTask2(int capacity){
        keys   = (Key[]) new Comparable[capacity]; 
        values = (Value[]) new Object[capacity];
    }
    
    public void put() {
        
    }
    
    public Value get(Key key) {
        
    }
    
    /**
     * This is the binary search function. It searches through
     * the ST to find how many keys that are smaller than the input key
     * @param key is the input key
     * @return the number of keys smaller than the input key
     */
    public int rank(Key key) {
        // Indexes for searching
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            
        }
        
        return low;
    }
    
    /**
     * Returns the largest key in the ST
     * @return the largest key in the ST
     */
    public Key max() {
        return keys[size-1];
    }
    
    /**
     * Returns the smallest key in the ST
     * @return  the smallest key in the ST
     */
    public Key min() {
        return keys[0];
    }
    
    /**
     * Searches the ST for the input key
     * @param key is the key to be searched for
     * @return if the key exists or not
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    
    /**
     * 
     * @param key is the key to delete
     */
    public void delete(Key key) {
        
    }
    
    /**
     * Checks the size of the symbol table
     * @return the size of the symbol table
     */
    public int size() {
        return size;
    }
    
    /**
     * Checks if symbol table is empty
     * @return boolean if symbol table is empty or not.
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    
    /**
     * Internal resizing function for the key and value arrays.
     * @param newCapacity is the new capacity for the ST
     */
    private void resize(int newCapacity) {
        Key[] newKeys     = (Key[]) new Comparable[newCapacity];
        Value[] newValues = (Value[]) new Object[newCapacity];
        // Copy old array elements to new ones
        for (int i = 0; i < size; i++) {
            newKeys[i]   = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }
    
    /**
     * Main class with unit tests for the methods.
     * @param args takes no input
     */
    public static void main(String[] args) {
        // Frequency counter
        // Take input from txt file
    }    
}
