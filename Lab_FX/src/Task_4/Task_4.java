package Task_4;

import Utility.SeparateChainingHashST;

/*********************************** README ************************************
*
* Seminar FX - Task 4: k:th most common word
* @author Alexander Lundqvist
* Created: 07-10-2021
*
* About this class:
* This class lets the user find the words with a certain frequency in a text file.
* It does this by utilizing hashing of the specified text file leipzig1m.txt.
*
* Based on:
* <a href="">Link</a>
*
* Implement a program which takes as input a text file and allows the user to 
* repeatedly ask questions: 
* i) Which is the k:th most common word
* ii) Which are the k:th to the k+n:th most common words
* Use https://introcs.cs.princeton.edu/java/data/leipzig/leipzig1m.txt  as input. 
* The time to build the index must not exceed four minutes.
* 
*******************************************************************************/

public class Task_4 {
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        String PATH = "test.txt";
        String DELIMITER = " ";
        
        SeparateChainingHashST hashTable = new SeparateChainingHashST();
        
    }
}
