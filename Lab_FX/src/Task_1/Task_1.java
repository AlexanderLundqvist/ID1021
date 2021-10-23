package Task_1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*********************************** README ************************************
*
* Seminar FX - Task 1
* @author Alexander Lundqvist
* Created: 07-10-2021
*
* About this class:
*
*
* Based on:
* <a href="">Link</a>
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

public class Task_1<Item> implements Iterable<Item>{
    private Node<Item> sentinel = null;
    int size;
    
    // Helper node class to implement the linked list structure
    private class Node<Item> {
        private Item item;
        private Node<Item> previous_node;
        private Node<Item> next_node;
    }
    
    /**
     * i) A method to create a new list instantiated with some type of elements 
     *    (data stored in the list) defined at the time the list is created
     */
    public Task_1() {
        sentinel.previous_node = sentinel;
        sentinel.next_node = sentinel;
        size = 0;
    }
    
    public void pushToStart(Item item) {
        
    }
    
    public void pushToEnd(Item item, boolean choice) {
        Node<Item> old_last = sentinel.previous_node;
        Node<Item> new_last = new Node<>();
        new_last.item = item;
        new_last.next_node = null;
        new_last.previous_node = old_last;
        old_last.next_node = new_last;
        size++; 
    }
    
    public Item popFromStart() {
        return sentinel.next_node.item;
    }
    
    public Item popFromEnd() {
        return sentinel.previous_node.item;
    }
    
    // A method to insert elements ordered in ascending order in the list
    
    public void listToString() {
        
    }
    
    @Override
    public Iterator<Item> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Main method with unit testing for the class. Enables user to manually
     * input entries into the list.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        
    }
}
