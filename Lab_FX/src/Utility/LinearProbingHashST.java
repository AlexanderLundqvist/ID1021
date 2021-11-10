package Utility;

import edu.princeton.cs.algs4.Queue;

/*********************************** README ************************************
*
* Seminar FX - Linear probing hash symbol table 
* @author Alexander Lundqvist
* Created: 10-11-2021
*
* About this class:
* This class implements linear probing hash table.
*
* Based on:
* <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/LinearProbingHashST.java.html">Link</a>
*
*******************************************************************************/

public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4; // must be a power of 2

    private int amountOfPairs;  // number of key-value pairs            
    private int tableSize;      // hash table size                      
    private Key[] keys;         // the keys
    private Value[] values;     // the values


    /**
     * Initializes an empty symbol table.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }
    
    public Key[] getKeys() {
        return this.keys;
    }
    
    public Value[] getValues() {
        return this.values;
    }
    
    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(int capacity) {
        tableSize = capacity;
        amountOfPairs = 0;
        keys = (Key[])      new Object[tableSize];
        values = (Value[])  new Object[tableSize];
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
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    
    // hash function for keys - returns value between 0 and m-1 (assumes m is a power of 2)
    // (from Java 7 implementation, protects against poor quality hashCode() implementations)
    private int hash(Key key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (tableSize-1);
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < tableSize; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys            = temp.keys;
        values          = temp.values;
        tableSize       = temp.tableSize;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (amountOfPairs >= tableSize/2) resize(2*tableSize);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % tableSize) {
            if (keys[i].equals(key)) {
                values[i] = val;
                return;
            }
        }
        keys[i] = key;
        values[i] = val;
        amountOfPairs++;
    }

    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value associated with {@code key};
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % tableSize)
            if (keys[i].equals(key))
                return values[i];
        return null;
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     */
    public void delete(Key key) {
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % tableSize;
        }

        // delete key and associated value
        keys[i] = null;
        values[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % tableSize;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = values[i];
            keys[i] = null;
            values[i] = null;
            amountOfPairs--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % tableSize;
        }

        amountOfPairs--;

        // halves size of array if it's 12.5% full or less
        if (amountOfPairs > 0 && amountOfPairs <= tableSize/8) resize(tableSize/2);
    }

    /**
     * Returns all keys in this symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < tableSize; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }

    /**
     * Main method.
     * 
     * @param args takes no arguments
     */
    public static void main(String[] args) { 
        
    }
}
