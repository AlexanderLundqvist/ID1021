package Task_2;

/*******************************************************************************
*
* Seminar 1 - task 2
* @author Alexander Lundqvist
* Created: 30-08-2021
*
* Single file program that performs the task of taking in a string input and
* then print out the characters in reverse order by using a recursive function.
* 
*
*******************************************************************************/

import java.util.*;

public class ReverseRecursive {
    
    public static void recursive(char[] textArray, int index) {
        if (index >= 0){ // Checks if we come to firts element in array
            System.out.print(textArray[index--]);
            recursive(textArray, index);
        }
    }
    
    /**
     * Main method. Controls the program flow.
     * @param args takes no argument
     */
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please input text to reverse: ");
        String text = input.next();
        char[] textArray = text.toCharArray();
        System.out.println();
        recursive(textArray, textArray.length-1);
    }
}
