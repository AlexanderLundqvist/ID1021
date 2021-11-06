package Utility;

/*********************************** README ************************************
*
* Seminar FX - String-integer pair
* @author Alexander Lundqvist
* Created: 06-11-2021
*
* About this class:
* This class implements <String, integer> pairs. The class supports creation of
* a pair and printing of object fields.
*
* Based on:
* <a href="">Link</a>
*
*******************************************************************************/

public class Pair {
    private String string;
    private int integer;
    
    /**
     * Default constructor. Initializes an instance of a pair object.
     * @param string
     * @param integer 
     */
    public Pair(String string, int integer) {
        this.string = string;
        this.integer = integer;
    }
    
    /**
     * Returns the string value/field of the pair object
     * @return the string
     */
    public String getString() {
        return this.string;
    }
    
    /**
     * Returns the integer value/field of the pair object
     * @return the integer
     */
    public int getInteger() {
        return this.integer;
    }
    
    /**
     * Prints the contents/fields of the object
     */
    public void print() {
        System.out.println(this.string + " " + this.integer);
    }
    
    /**
     * 
     * @param args takes no arguments
     */
    public static void main(String[] args) {
        
    }
}
