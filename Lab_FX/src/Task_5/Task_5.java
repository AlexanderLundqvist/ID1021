package Task_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*********************************** README ************************************
*
* Seminar FX - Task 5: Misspellings in a text
* @author Alexander Lundqvist
* Created: 07-10-2021
*
* About this class:
* This class allows the user to read an ASCII text file in english that potentially
* contains misspellings and then corrects these misspellings. The program then 
* prints the corrected text to a new file.
*
* Implement a program which reads an ASCII text file whose name is given as an 
* argument at the command line. The text file should contain a text written in 
* English which may contain misspellings of words. The program should output a 
* corrected version of the text, basing the corrections on the list of common 
* misspellings found here: 
* https://en.wikipedia.org/wiki/Wikipedia:Lists_of_common_misspellings/For_machines
* 
* The execution time complexity should be near linear compared to the time it 
* takes to read the input files. That is, you need to show that your algorithm 
* meets this constraint.
* 
* For this assignment you may use the abstract data types defined in the course 
* directly (i.e. you need not implement them yourself)
* 
*******************************************************************************/

public class Task_5 {

    /**
     * Main method that controls the whole program flow.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) throws FileNotFoundException {
        String misspellings = "common_misspellings.txt";
        String DELIMITER = "->";
        Scanner reader = new Scanner(new File(misspellings));
         
        LinearProbingHashST<String, string>
    }
}
