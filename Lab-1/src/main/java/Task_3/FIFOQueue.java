/*
 * Implement a generic iterable FIFO-queue based on a double linked circular 
 * list (see the pdf in the module Course litterature for a description of 
 * double linked circular lists). You should print the content of the list 
 * after each insertion/deletion of an element.
 *
 */
package Task_3;

/*******************************************************************************
*
* Seminar 1 - task 2
* @author Alexander Lundqvist
* Created: 30-08-2021
*
* 
* This class implements a generic iterable FIFO-queue based on a double linked 
* circular list.
*
*******************************************************************************/

import Task_2.LIFOStack;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FIFOQueue<Item> implements Iterable<Item>{
    private Node<Item> sentinel_first;        // Sentinel element after "sentinel_first item"
    private Node<Item> sentinel_last;         // Sentinel element before "sentinel_first item"
    private int size;                            // number of items in the queue
    
    /**
     * Constructor for the FIFOQueue. Only called once.
     */
    public FIFOQueue() {
        sentinel_first = new Node<>();
        sentinel_last = new Node<>();
        sentinel_first.next_node = sentinel_last;
        sentinel_last.previous_node = sentinel_first;
    }
    
    /**
    * Helper node class to implement the linked list structure
    */
    private class Node<Item> {
        private Item item;
        private Node<Item> next_node;
        private Node<Item> previous_node;
    }
    
    /**
     * Inserts a new item into the queue
     * @param item is the item to queue
     */
    public void enqueue(Item item) {
        Node<Item> old_last = sentinel_last.previous_node;
        Node<Item> new_last = new Node<>();
        new_last.item = item;
        new_last.next_node = sentinel_last;
        new_last.previous_node = old_last;
        sentinel_last.previous_node = new_last;
        old_last.next_node = new_last;
        size++;
        queueToString();
    }
        
    /**
     * Removes an element from the queue according to the FIFO policy
     * @return the dequed element
     */
    public Item dequeue() {
        Node<Item> first_in = sentinel_first.next_node;
        sentinel_first.next_node = first_in.next_node;
        sentinel_first.next_node.previous_node = sentinel_first;
        first_in.next_node = null;      // Removing old references
        first_in.previous_node = null;  // Removing old references
        size--;
        queueToString();
        return first_in.item;
    }
    
    /**
     * Auxillary function of the ADT. Checks if queue is empty.
     * @return true or false depending if the queue is empty 
     */
    public boolean isEmpty() {
        return (size() == 0);
    }
    
    /**
     * Function that gives the length of the queue
     * @return the length of the current_node queue
     */
    public int size() {
        return size;
    }
    
    
    /**
     * toString function that formats the queue into readable format. Includes
     * explanation on how the list is circular with the sentinel element.
     */
    public void queueToString() {
        StringBuilder formatedString = new StringBuilder();
        int counter = 0;
        formatedString.append("Sentinel -> {");
        for (Item item : this) {
            counter++;
            if (item != null) {
                formatedString.append("[");
                formatedString.append(item);
                formatedString.append("]");
                if (counter <= size) {
                    formatedString.append(","); 
                }
            }
        }
        formatedString.append("} -> Sentinel");
        System.out.println(formatedString.toString());   
    }
    
    /**
     * Main method to test the functionality of the queue. Can only
     * test for char input to the queue.
     * @param args takes no argument
     */
    public static void main(String[] args) {
        
        FIFOQueue queue = new FIFOQueue();
        
        // Hardcoded operations for easy testing
        /*
        queue.enqueue('H');
        queue.enqueue('e');
        queue.enqueue('l');
        queue.enqueue('l');
        queue.enqueue('o');

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
  
        queue.enqueue('W');
        queue.enqueue('o');
        queue.enqueue('r');
        queue.enqueue('l');
        queue.enqueue('d');
        
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); 
        */
        int choice = 0;
        while (true) {
            System.out.println();
            System.out.println("****** Testing interface for the ADT ******");
            System.out.println("Choose an option:");
            System.out.println("1. Queue a char.");
            System.out.println("2. Dequeue.");
            System.out.println("3. Exit.");
            System.out.println();
            Scanner input = new Scanner(System.in);
            System.out.println("Choice: ");
            
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input!");
                break;
            }
            
            System.out.println();
            if (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("Not a valid choice, try again!");
                continue;
            }
            else if (choice == 3) {
                break;
            }
            else {
                switch (choice) {
                    case 1:
                        System.out.println("input a char: ");
                        try {
                            char item = input.next().charAt(0);
                            queue.enqueue(item);
                        break;
                        } catch (Exception e) {
                            System.out.println("Wrong input!");
                            break;
                        }
                    case 2:
                        if (queue.isEmpty()) {
                            System.out.println("Queue is empty!");
                        }
                        else {
                            queue.dequeue();
                        }
                        break;
                }
            }
        } 
        System.out.println();
        
    }    
    
    /**
     * Returns an iterator for the queue ADT
     * 
     * @return an iterator that can iterate through the queue
     */
    public Iterator<Item> iterator() {
        return new DoublyLinkedIterator(sentinel_first);
    }
    
    /**
     * Helper class that implements iteration over the queue by 
     * utilizing the built in iterator interface in Java
     */
    private class DoublyLinkedIterator implements Iterator<Item> {
        private Node<Item> current_node;

        private DoublyLinkedIterator(Node<Item> node) {
            current_node = node;
        }
        
        @Override
        public boolean hasNext() {
            return current_node != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current_node.item;
            current_node = current_node.next_node;
            return item;
        }
    }
}
