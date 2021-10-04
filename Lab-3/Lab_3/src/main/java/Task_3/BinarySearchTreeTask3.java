package Task_3;

import Task_2.BinarySearchSymbolTableTask2;
import Utility.Queue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*********************************** README ************************************
*
* Seminar 3 - Task 2 Binary search tree
* @author Alexander Lundqvist
* Created: 30-09-2021
*
* 
* This class implements a binary search tree with minimal functionality.
* Error handling is not implemented for the most part.
* Based on:
* <a href="https://algs4.cs.princeton.edu/31elementary/BinarySearchST.java.html">Link</a>
* <a href="https://algs4.cs.princeton.edu/31elementary/FrequencyCounter.java.html">Link</a>
* 
*******************************************************************************/

public class BinarySearchTreeTask3<Key extends Comparable<Key>, Value> {
    private Node root;             // Root node of the tree
    
    // Node helper class for BST
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    
    // Initialize empty search tree
    public BinarySearchTreeTask3() {
    }
    
    /**
     * 
     * @param key the input key
     * @return true if key exists in the tree, else false
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    
    /**
     * 
     * @return true if the tree is empty
     */
    public boolean isEmpty() {
        return (size() == 0);
    }
    
    public int size() {
        return size(root);
    }
    
    private int size(Node node) {
        if (node == null) return 0;
        else return node.size;
    }
    
    /**
     * Inserts a new key-value pair into the tree
     * @param key the input key
     * @param value the value
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value value){
        if (node == null) return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if      (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else    node.val = value;
        return node;
    }
    
    /**
     * Returns the value associated with the input key
     * @param key the input key
     * @return the value associated with key
     */
    public Value get(Key key) {
        return get(root, key);
    }
    
    private Value get(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if      (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else              return node.val;
    }
    
    
    
    /**
     * Returns all keys as an Iterable
     * @return all the keys in the tree
     */
    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue<Key>();
        return keys(min(), max());
    }
    
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 
    
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    }
    
    public Key min() {
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

    public Key max() {
        return max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    }
    /**
     * Main class with testing by frequency counter.
     * @param args takes no input
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        File theText = new File("filteredtext.txt");
        Scanner reader = new Scanner(theText);
     
        // Setup for the test
        BinarySearchTreeTask3<String, Integer> searchTree = new BinarySearchTreeTask3<String, Integer>();
        int MAX_WORDS;
        int minlen = 3; 
        int distinct = 0;
        int words = 0;

        System.out.println("Enter how many words to process: ");
        MAX_WORDS = input.nextInt();

        //System.out.println("Enter minimum length for words: ");
        //minlen = input.nextInt();

        // Build the ST and compute frequency counts
        long startBuild = System.currentTimeMillis();
        while ((reader.hasNext()) && (words < MAX_WORDS)) {
            String key = (reader.next()).toLowerCase(); // To avoid duplicates
            if (key.length() < minlen) continue;
            words++;
            if (searchTree.contains(key)) {
                searchTree.put(key, searchTree.get(key) + 1);
            }
            else {
                searchTree.put(key, 1);
                distinct++;
            }
        }
        long stopBuild = System.currentTimeMillis();
        long elapsedTimeBuild = stopBuild - startBuild;

        // Find a key with the highest frequency count
        long startSearch = System.currentTimeMillis();
        String max = "";
        searchTree.put(max, 0);
        for (String word : searchTree.keys()) {
            if (searchTree.get(word) > searchTree.get(max))
                max = word;
        }
        long stopSearch = System.currentTimeMillis();
        long elapsedTimeSearch = stopSearch - startSearch;

        // Print out result
        System.out.println("*********************************** RESULT **********************************");
        System.out.println("Most frequent word is {" + max + "} with a count of " + searchTree.get(max));
        System.out.println("Distinct words  = " + distinct);
        System.out.println("Amount of words = " + words);
        System.out.println("Build time      = " + elapsedTimeBuild + " ms");
        System.out.println("Search time     = " + elapsedTimeSearch + " ms");
        System.out.println("*****************************************************************************\n");

        searchTree = null; // Clean up memory      
    } 
}
