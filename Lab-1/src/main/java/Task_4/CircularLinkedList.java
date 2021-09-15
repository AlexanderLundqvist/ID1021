/*
 * Implement a generic iterable circular linked list which allows the user 
 * to insert and remove elements to/from the front and back end of the queue. 
 * Be careful when designing the API. You should print the content of the list 
 * after each insertion/deletion of an element.
 */
package Task_4;

/*******************************************************************************
*
* Seminar 1 - task 3
* @author Alexander Lundqvist
* Created: 12-09-2021
*
* 
* This class implements a generic iterable FIFO-queue based on a double linked 
* circular list.
*
*******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CircularLinkedList<Item> implements Iterable<Item>{
    private Node<Item> head;         // Start of the queue
    private Node<Item> tail;         // End of the queue
    private int size;                // Number of items in the queue
    
    /**
     * Constructor for the CircularLinkedList. Only called once.
     */
    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
    * Helper node class to implement the linked list structure
    */
    private class Node<Item> {
        private Item item;
        private Node<Item> next_node;
    }
    
    
    public void enqueueStart(Item item) {
        Node new_first = new Node<>();
        head.item = item;
        
        if (tail == null) {
            
        }
        
       
        size++;
        queueToString();
    }
    
    
    public void enqueueEnd(Item item) {
       
    }
    
    
    public Item dequeueStart() {
        return null;
    }
    
    public Item dequeueEnd() {
        return null;
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
                if (counter < size) {
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
        
        CircularLinkedList queue = new CircularLinkedList();
        
        // Hardcoded operations for easy testing
        
        queue.enqueueStart('H');
        queue.enqueueStart('e');
        queue.enqueueStart('l');
        queue.enqueueStart('l');
        queue.enqueueStart('o');
        
        /*
        queue.dequeueStart();
        queue.dequeueStart();
        queue.dequeueStart();
        queue.dequeueStart();
        queue.dequeueStart();
  
        queue.enqueueEnd('W');
        queue.enqueueEnd('o');
        queue.enqueueEnd('r');
        queue.enqueueEnd('l');
        queue.enqueueEnd('d');
        
        queue.dequeueEnd();
        queue.dequeueEnd();
        queue.dequeueEnd();
        queue.dequeueEnd();
        queue.dequeueEnd();
        */
        
        /*
        int choice = 0;
        while (true) {
            System.out.println();
            System.out.println("****** Testing interface for the ADT ******");
            System.out.println("Choose an option:");
            System.out.println("1. Queue a char to start of queue.");
            System.out.println("2. Queue a char to end of queue.");
            System.out.println("3. Dequeue from start.");
            System.out.println("4. Dequeue from end.");
            System.out.println("5. Exit.");
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
            if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
                System.out.println("Not a valid choice, try again!");
                continue;
            }
            else if (choice == 5) {
                break;
            }
            else {
                switch (choice) {
                    case 1:
                        System.out.println("input a char: ");
                        try {
                            char item = input.next().charAt(0);
                            queue.enqueueStart(item);
                        break;
                        } catch (Exception e) {
                            System.out.println("Wrong input!");
                            break;
                        }
                    case 2:
                        System.out.println("input a char: ");
                        try {
                            char item = input.next().charAt(0);
                            queue.enqueueEnd(item);
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input!");
                            break;
                        }
                        
                    case 3:
                        if (queue.isEmpty()) {
                            System.out.println("Queue is empty!");
                        }
                        else {
                            queue.dequeueStart();
                        }
                        break;
                        
                    case 4:
                        if (queue.isEmpty()) {
                            System.out.println("Queue is empty!");
                        }
                        else {
                            queue.dequeueEnd();
                        }
                        break;
                }
            }
        } 
        System.out.println();
        */
    }    
    
    /**
     * Returns an iterator for the queue ADT
     * 
     * @return an iterator that can iterate through the queue
     */
    public Iterator<Item> iterator() {
        return new DoublyLinkedIterator(head);
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

