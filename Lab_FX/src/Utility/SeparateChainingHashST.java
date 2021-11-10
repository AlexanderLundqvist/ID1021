package Utility;
import edu.princeton.cs.algs4.Queue;

/*********************************** README ************************************
*
* Seminar FX - Separate chaining hash symbol table
* @author Alexander Lundqvist
* Created: 10-11-2021
*
* About this class:
* This class implements a hash symbol table with separate chaining
*
* Based on:
* <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/SeparateChainingHashST.java.html">Link</a>
*
*******************************************************************************/

public class SeparateChainingHashST<Key, Value> {
    
    private static final int DEFAULT_CAPACITY = 4;          // Default capacity
    private int amountOfPairs;                              // number of key-value pairs            N
    private int tableSize;                                  // hash table size                      M
    private SequentialSearchST<Key, Value>[] symbolTables;  // array of linked-list symbol tables    
    
    
    /**
     * Default constructor
     */
    public SeparateChainingHashST() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with specified number of chains chains.
     * @param tableSize the initial number of chains
     */
    public SeparateChainingHashST(int tableSize) {
        this.tableSize = tableSize;
        symbolTables = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[tableSize];
        for (int i = 0; i < tableSize; i++)
            symbolTables[i] = new SequentialSearchST<Key, Value>();
    } 

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < tableSize; i++) {
            for (Key key : symbolTables[i].keys()) {
                temp.put(key, symbolTables[i].get(key));
            }
        }
        this.tableSize  = temp.tableSize;
        this.amountOfPairs  = temp.amountOfPairs;
        this.symbolTables = temp.symbolTables;
    }

    // hash function for keys - returns value between 0 and m-1
    private int hashTextbook(Key key) {
        return (key.hashCode() & 0x7fffffff) % tableSize;
    }

    // hash function for keys - returns value between 0 and m-1 (assumes m is a power of 2)
    // (from Java 7 implementation, protects against poor quality hashCode() implementations)
    private int hash(Key key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (tableSize-1);
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return amountOfPairs;
    } 

    /**
     * Returns true if this symbol table is empty.
     *
     * @return true if this symbol table is empty, else false
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return true if this symbol table contains the key, else false

     */
    public boolean contains(Key key) {
        return get(key) != null;
    } 

    /**
     * Returns the value associated with the specified key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the key in the symbol table;
     */
    public Value get(Key key) {
        int i = hash(key);
        return symbolTables[i].get(key);
    } 

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is null.
     *
     * @param  key the key
     * @param  val the value
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if average length of list >= 10
        if (amountOfPairs >= 10*tableSize) resize(2*tableSize);

        int i = hash(key);
        if (!symbolTables[i].contains(key)) amountOfPairs++;
        symbolTables[i].put(key, val);
    } 

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     */
    public void delete(Key key) {
        int i = hash(key);
        if (symbolTables[i].contains(key)) amountOfPairs--;
        symbolTables[i].delete(key);

        // halve table size if average length of list <= 2
        if (tableSize > DEFAULT_CAPACITY && amountOfPairs <= 2*tableSize) resize(tableSize/2);
    } 

    /**
     * Returns all keys in the symbol table as an iterable.
     * @return all keys
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < tableSize; i++) {
            for (Key key : symbolTables[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }

    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        
    }
}
