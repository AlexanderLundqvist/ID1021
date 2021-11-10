package Utility;

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
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        SequentialSearchST test = new SequentialSearchST();
    }
}
