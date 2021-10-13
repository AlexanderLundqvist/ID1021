package Utility;
import edu.princeton.cs.algs4.Queue;

/*********************************** README ************************************
*
* Seminar 4 - Symbol table
* @author Alexander Lundqvist
* Created: 08-10-2021
*
* About this class:
*
*
* Based on:
* <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/ST.java.html">Link</a>
* <a href="https://algs4.cs.princeton.edu/31elementary/BinarySearchST.java.html">Link</a>
*
*******************************************************************************/

public class SymbolTable<Key extends Comparable<Key>, Value> {
    private static final int DEFAULT_CAPACITY = 2;
    private Key[] keys; // Ordered array with keys
    private Value[] values; // Values associated with these keys
    private int size = 0; // Size of the symbol table or how many key-value pairs
    
    // Default constructor
    public SymbolTable() {
        keys   = (Key[]) new Comparable[DEFAULT_CAPACITY];
        values = (Value[]) new Object[DEFAULT_CAPACITY];
    }
    
    // Initializes an empty symbol table with specified capacity
    public SymbolTable(int capacity){
        keys   = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }
    
     /**
     * Inserts a new key-value pair into the ST.
     * @param key new key
     * @param value new value
     */
    public void put(Key key, Value value) {
        // null value indicates that we want to delete the key value pair from the ST
        if (value == null) {
            delete(key);
            return;
        }

        // What pontential rank the key has
        int i = rank(key);

        // If key is already in table, replace the old value with the new
        if (i < size && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        // Resize if size has reached capacity
        if (size == keys.length) resize(2*keys.length);

        // Insert the new key-value pair
        for (int j = size; j > i; j--) { // Gå från högsta key
            keys[j]   = keys[j-1]; // Kopiera värden ett steg åt höger
            values[j] = values[j-1];
        }
        keys[i] = key; // Nu är platsenrna för key, value paret "ledig"
        values[i] = value; // dvs de innehåller en duplicate som kan ersättas
        size++;
    }

    /**
     * Retrieves the value associated with the input key.
     * @param key is the input key
     * @return the value associated with the key
     */
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }
    /*
    "The heart of the implementation is the rank() method, which returns the
    number of keys smaller than a given key.

    For get(), the rank tells us precisely where the key is to be found if it
    is in the table (and, if it is not there, that it is not in the table).

    For put(), the rank tells us precisely where to update the value when the
    key is in the table, and precisely where to put the key when the key is not
    in the table.

    We move all larger keys over one position to make room
    (working from back to front) and insert the given key and value into the
    proper positions in their respective arrays."
    */
    public int rank(Key key) {
        // Indexes for searching
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;                  // Find middle of array
            int comparisonAnswer = key.compareTo(keys[mid]); // a<b -> negative; a==b -> 0; a>b -> positive:
            if (comparisonAnswer < 0) {                      // If less than mid, then we continue searching in left sub array
                high = mid - 1;                              // Mid becomes the new high index
            }
            else if (comparisonAnswer > 0) {                 // If greater than mid, then we continue searching in right sub array
                low = mid + 1;                               // Mid becomes new low index
            }
            else                                             // If answer is 0, then the key is found
                return mid;                                  // Mid then gives all keys less than input key
        }
        return low; 
    }            
    
    /**
     * Returns the largest key in the ST
     * 
     * @return the largest key in the ST
     */
    public Key max() {
        return keys[size-1];
    }

    /**
     * Returns the smallest key in the ST
     * 
     * @return  the smallest key in the ST
     */
    public Key min() {
        return keys[0];
    }

    /**
     * Searches the ST for the input key
     * 
     * @param key is the key to be searched for
     * @return if the key exists or not
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * Deletes a specific entry in the symbol table with a given key
     * 
     * @param key is the key to delete
     */
    public void delete(Key key) {
        if (isEmpty()) return;

        // Compute the rank of the key we want to delete
        int i = rank(key);

        // If the key doesn't exist, exit
        if (i == size || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < size-1; j++)  {
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }

        size--;
        keys[size] = null;
        values[size] = null;

        // Resize if full
        if (size > 0 && size == keys.length/4) resize(keys.length/2);

    }

    /**
     * Checks the size of the symbol table
     * 
     * @return the size of the symbol table
     */
    public int size() {
        return size;
    }

    /**
     * Checks if symbol table is empty
     * 
     * @return boolean if symbol table is empty or not.
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Internal resizing function for the key and value arrays.
     * 
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
     * Returns all the keys as an Iterable.
     * @return an iterator that can iterate through the keys in the ST.
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    /**
     * Returns all keys in this symbol table in the given range,
     * as an Iterable.
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return all keys between endpoints
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>(); // Implementeras med en fifo kö
        if (lo.compareTo(hi) > 0) return queue; // negativt intervall
        for (int i = rank(lo); i < rank(hi); i++) 
            queue.enqueue(keys[i]); 
        if (contains(hi)) queue.enqueue(keys[rank(hi)]);
        return queue;
    }
    
    public static void main(String[] args) {
        // No unit test here, see task 2 in lab 3
    }
}
