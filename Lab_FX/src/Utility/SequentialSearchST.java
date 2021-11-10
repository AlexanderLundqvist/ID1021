package Utility;

import edu.princeton.cs.algs4.Queue;

/*********************************** README ************************************
*
* Title placeholder
* @author Alexander Lundqvist
* Created: 10-11-2021
*
* About this class:
* This class implements a basic symbol table which allows for sequential searching.
* 
*
* Based on:
* <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/SequentialSearchST.java.html">Link</a>
*
*******************************************************************************/

public class SequentialSearchST<Key, Value> {
    private int size;           // number of key-value pairs
    private Node first;         // the linked list of key-value pairs

    // Helper node class to implement the linked list structure
    private class Node {
        private Key key;
        private Value value;
        private Node nextNode;

        public Node(Key key, Value value, Node nextNode)  {
            this.key  = key;
            this.value  = value;
            this.nextNode = nextNode;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public SequentialSearchST() {
    }
    
    /**
     * Returns the amount of key-value pairs in the table.
     * @return the amount of key-value pairs
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Checks if the symbol table is empty
     * @return true if empty, else false
     */
    public boolean isEmpty() {
        return (size() == 0);
    }
    
    /**
     * Finds out if a certain key exists in the table
     * @param key the key
     * @return true if key exists, else false
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    
    /**
     * Finds and returns the value of a given key
     * @param key the key
     * @return the value
     */
    public Value get(Key key) {
        for (Node current = first; current != null; current = current.nextNode) {
            if (key.equals(current.key))
                return current.value;
        }
        return null;
    }
    
    /**
     * Inserts a new key-value pair into the table
     * @param key
     * @param value 
     */
    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
            return;
        }

        for (Node current = first; current != null; current = current.nextNode) {
            if (key.equals(current.key)) {
                current.value = value;
                return;
            }
        }
        
        first = new Node(key, value, first);
        size++;
    }
    
    /**
     * Removes a key-value pair from the table
     * @param key 
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        first = delete(first, key);
    }
    
    
    private Node delete(Node first, Key key) {
        if (key.equals(first.key)) {
            size--;
            return first.nextNode;
        }
        
        first.nextNode = delete(first.nextNode, key);
        return first;
    }


    /**
     * Returns all keys in the symbol table as an iterable.
     * @return all keys in the symbol table
     */
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node current = first; current != null; current = current.nextNode)
            queue.enqueue(current.key);
        return queue;
    }
    
    /**
     * Prints the list
     */
    public void print() {
        for (Node current = first; current != null; current = current.nextNode) {
            System.out.println(current.key + " " + current.value);
        }
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        SequentialSearchST test = new SequentialSearchST();
        
        // Add
        test.put("A",2);
        test.put("B",44);
        test.put("C",154);
        
        // Display
        test.print();
        
        // Delete
        test.delete("B");
        
        System.out.println("");
        test.print();
    }
}
