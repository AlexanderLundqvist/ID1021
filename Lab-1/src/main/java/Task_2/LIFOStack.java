package Task_2;

/*******************************************************************************
*
* Seminar 1 - task 2
* @author Alexander Lundqvist
* Created: 30-08-2021
*
* ALSKDNALSKDNALSKdn
* implemented with an ADT (LIFO stack) built from scratch.
* The program can only take strings not containing whitespaces.
* 
* The stack is implemented as resizing array.
*
*******************************************************************************/

import java.util.Iterator;
import java.util.Scanner;



public class LIFOStack<Item> implements Iterable<Item> {
    // Basic fields for the stack
    private Item[] stack;
    private int stackpointer;    
    
    /**
     * Constructor. Initializes a new instance of the ADT.
     */
    public LIFOStack() {
        // Must initialize to 1, else the resizing won't work
        // Also it will be a null element at the absolute top of the stack
        this.stack = (Item[]) new Object[1]; 
        this.stackpointer = 0; 
    }
    
    /**
     * Basic function of the stack. Adds an item to the top/end of the stack.
     * @param item is the item to be added 
     */
    public void push(Item item) {
        if (this.stackpointer == size())
            resize(2*size());
        this.stack[this.stackpointer++] = item;
    }
    
    /**
     * Basic function of the stack. Pops/removes the last added item from the stack.
     * @return the popped item
     */
    public Item pop() {
        Item poppedItem = this.stack[--this.stackpointer];
        this.stack[this.stackpointer] = null;
        if (this.stackpointer > 0 && this.stackpointer == size()/4)
            resize(size()/2);
        return poppedItem; 
    }
    
    /**
     * Helper function to resize the stack depending on the need.
     * @param amount is the amount to increase the stack with
     */
    private void resize(int amount) {
        Item[] newStack = (Item[]) new Object[amount];
       
        for (int i = 0; i < this.stackpointer; i++) {
            newStack[i] = this.stack[i];
        }
        
        this.stack = newStack;
        newStack = null;
    }
    
    /**
     * Auxillary function of the stack ADT. Checks if stack is empty.
     * @return true or false depending if the stack is empty 
     */
    public boolean isEmpty() {
        if (this.stackpointer == 0){
            return true;
        }
        else
            return false;
    }
    
    /**
     * Function that gives the length of the stack
     * @return the length of the current stack
     */
    public int size() {
        return (this.stack.length);
    }
    
    /**
     * toString function that formats the stack into readable format
     */
    public void stackToString() {
        int comma = 0;
        System.out.print("{");
        for (int i = 0; i < size() - 2; i++) {
            System.out.print("[" + this.stack[i].toString() + "]");
            if (comma < size() - 3) System.out.print(",");
            comma++;
        }
        System.out.print("}");
    }
    
    /**
     * Main method to test the functionality of the stack. 
     * @param args takes argument
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please input text to reverse: ");
        String text = input.next();
        char[] textArray = text.toCharArray();
        System.out.println();
        
        LIFOStack testStack = new LIFOStack() {};
        for (char c : textArray) {
            testStack.push(c);
        }
        
        System.out.println("This is the content of the stack before reversal");
        testStack.stackToString();
        
        System.out.println("\n\nThis is the stack pointer");
        System.out.println(testStack.stackpointer);
       
        System.out.println("\nThis the input in reverse\n");
        for (char c : textArray) {
            System.out.print(testStack.pop());
        }
        
    }
    
    
    @Override
    public Iterator<Item> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
