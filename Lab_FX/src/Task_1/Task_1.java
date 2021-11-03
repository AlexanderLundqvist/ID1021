package Task_1;

import java.util.Iterator;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*********************************** README ************************************
*
* Seminar FX - Task 1: Doubly linked list
* @author Alexander Lundqvist
* Created: 07-10-2021
*
* About this class:
* This class implements a doubly linked list with a sentinel element
*
* Based on:
* <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/LinkedQueue.java.html">Link</a>
*
* 
* Implement a double linked list with a sentinel element. The API should have methods to:
* 
* i) A method to create a new list instantiated with some type of elements 
* (data stored in the list) defined at the time the list is created
* 
* ii) A method to insert an element at the beginning of the list 
* 
* iii) A method to insert an element at the end of the list 
* 
* iv) A method to remove and return the first element in the list
* 
* v) A method to remove and return the last element of the list
* 
* vi) A method to insert elements ordered in ascending order in the list
* 
* vii) You should calculate the Big-Oh complexities for insertion and removal of elements
* 
* Limitations: You are not allowed to use extra references such as first/last to keep track of 
* where the list starts/ends. The total amount of lines of executable code 
* (statements such as if, for, while, new, method calls and assignments) for 
* the methods i - vi, should be 20-40 lines including lines of executable code 
* in methods called. This requires careful design of the methods and 
* "helper" methods.
* 
*******************************************************************************/

public class Task_1<Item extends Comparable<Item>>{
    private Node<Item> sentinel;

    // Helper node class to implement the linked list structure
    private class Node<Item> {
        private Item item;
        private Node<Item> previous_node;
        private Node<Item> next_node;
        
        public Node(Item item, Node previous, Node next) {
           this.item = item;
           this.previous_node = previous;
           this.next_node = next;
        }
    }
    
    /**
     * Default constructor. Initializes an empty list.
     */
    public Task_1() {
        // Only node we have to create and assign manually like this
        sentinel = new Node<>(null, null , null);
        sentinel.previous_node = sentinel;
        sentinel.next_node = sentinel;
    }
    
    /**
     * Adds an element to the start of the list. 
     * 
     * @param item the item to be added
     */
    public void pushToStart(Item item) {
        Node<Item> old_first = sentinel.next_node;
        Node<Item> new_first = new Node<>(item, sentinel, old_first);
        sentinel.next_node = new_first;
        old_first.previous_node = new_first;
    }
    
    /**
     * Adds an element to the end of the list.
     * 
     * @param item the item to be added
     */
    public void pushToEnd(Item item) {
        Node<Item> old_last = sentinel.previous_node;
        Node<Item> new_last = new Node<>(item, old_last, sentinel);
        sentinel.previous_node = new_last;
        old_last.next_node = new_last;
    }
    
    /**
     * Removes the first element in the list.
     * 
     * @return the item of the first element.
     */
    public Item popFromStart() {
        Node<Item> popped_node = sentinel.next_node;
        sentinel.next_node = popped_node.next_node;
        popped_node.next_node.previous_node = sentinel;
        popped_node = null;
        return sentinel.next_node.item;
    }
    
    /**
     * Removes the last element in the list.
     * 
     * @return the item of the last element.
     */
    public Item popFromEnd() {
        Node<Item> popped_node = sentinel.previous_node;
        sentinel.previous_node = popped_node.previous_node;
        popped_node.previous_node.next_node = sentinel;
        popped_node = null;
        return sentinel.previous_node.item;
    }
    
    /**
     * Adds an element to the list in ascending order.
     * 
     * @param item the item to be added
     */
    public void pushAscending(Item item) {
        if(isEmpty()) {
            pushToStart(item);
            return;
        }
        
        Node<Item> current = sentinel.next_node;
        
        // If the Integer is less than the argument then -1 is returned.
        // If the Integer is equal to the argument then 0 is returned.
        // If the Integer is greater than the argument then 1 is returned.
        while(item.compareTo(current.item) > 0) {
            // Check if we reached end of list
            if (current.next_node == sentinel) {
                pushToEnd(item);
                return;
            }
            current = current.next_node;
        }
        
        Node<Item> new_node = new Node<>(item, current.previous_node, current);
        current.previous_node.next_node = new_node;
        current.previous_node = new_node;
    }
    
    /**
     * Check if the list is empty
     * 
     * @return true if list is empty, else false
     */
    public boolean isEmpty() {
        return sentinel.next_node == sentinel;
    }
    
    /**
     * Prints out the current content of the list
     */
    public void listToString() {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        StringBuilder formatedString = new StringBuilder();
        formatedString.append("Sentinel -> ");
        Node current = sentinel.next_node;
        while (current != sentinel) {
            formatedString.append("[");
            formatedString.append(current.item);
            formatedString.append("] ");
            current = current.next_node;
        }       
        formatedString.append("-> Sentinel");
        System.out.println(formatedString.toString());   
    }

    
    /**
     * Main method with unit testing for the class. Enables user to manually
     * input entries into the list.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        Task_1 test = new Task_1();
          
        test.listToString();
        test.pushToStart(1);
        test.listToString();
        test.pushToStart(2);
        test.listToString();
        test.pushToStart(3);
        test.listToString();
        test.pushToStart(4);
        test.listToString();
        test.pushToStart(5);
        test.listToString();
        
        test.popFromStart();
        test.listToString();
        test.popFromStart();
        test.listToString();
        test.popFromStart();
        test.listToString();
        test.popFromStart();
        test.listToString();
        test.popFromStart();
        test.listToString();
        
        test.pushToEnd(1);
        test.listToString();
        test.pushToEnd(2);
        test.listToString();
        test.pushToEnd(3);
        test.listToString();
        test.pushToEnd(4);
        test.listToString();
        test.pushToEnd(5);
        test.listToString();
        
        test.popFromEnd();
        test.listToString();
        test.popFromEnd();
        test.listToString();
        test.popFromEnd();
        test.listToString();
        test.popFromEnd();
        test.listToString();
        test.popFromEnd();
        test.listToString();
        
        test.pushAscending(4);
        test.listToString();
        test.pushAscending(3);
        test.listToString();
        test.pushAscending(7);
        test.listToString();
        test.pushAscending(9);
        test.listToString();
        test.pushAscending(0);
        test.listToString();
        test.pushAscending(15);
        test.listToString();
        
    }
}
