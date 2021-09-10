package Task_2;

/*******************************************************************************
*
* Seminar 1 - task 2
* @author Alexander Lundqvist
* Created: 30-08-2021
*
* Single file program that performs the task of taking in a string input and
* then print out the characters in reverse order by using a iterative function.
* implemented with an ADT (LIFO stack) built from scratch.
* 
*
*******************************************************************************/

import java.util.Iterator;
import java.util.Scanner;


public class LIFOStack<Item> implements Iterable<Item> {
    // Basic fields for the stack
    private Item[] stack;
    private int stackpointer;
    
    
    public LIFOStack() {
        this.stack = (Item[]) new Object[0];
        this.stackpointer = -1;
    }
    
    public void push(Item item) {
        resize(1);
        this.stack[++this.stackpointer] = item;
    }
    
    private void resize(int amount) {
        Item[] newStack = (Item[]) new Object[size() + amount];
      
        for (int i = 0; i < size(); i++) {
            if (size() > 0) {
                newStack[i] = this.stack[i];
            }
        }
        this.stack = newStack;
        newStack = null;
    }
    
    public Item pop() {
        if (isEmpty() == true) {
            System.out.println("The stack is empty!");
            return null;
        }
        else {
            Item poppedItem = this.stack[this.stackpointer];
            this.stack[this.stackpointer] = null;
            this.stackpointer--;
            resize(-1);
            return poppedItem; 
        }
    }
    
    public boolean isEmpty() {
        if (this.stackpointer == -1){
            return true;
        }
        else
            return false;
    }
    
    public int size() {
        return (this.stackpointer+1);
    }
    
    public void stackToString() {
        for (Item item : this.stack) {
            System.out.print("[" + item.toString() + "], ");
        }
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
        
        System.out.println("This is the content of the stack");
        testStack.stackToString();
        
        /*System.out.println("This the input in reverse");
        for (int i = 0; i < testStack.size(); i++) {
            System.out.print(testStack.pop());
        }*/

    }
    
    
    @Override
    public Iterator<Item> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
