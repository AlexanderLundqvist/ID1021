package Utility;

import java.util.Random;

/*********************************** README ************************************
*
* Seminar FX - Random Key-value pair generator
* @author Alexander Lundqvist
* Created: 04-11-2021
*
* About this class:
* This class implements creating random key-value pairs, key is in the format 
* of strings and the values are simple integers. The class supports creating of
* singular key-value pairs but also creating multiple key value-pairs at the
* same time.
*
* Based on:
* <a href="">Link</a>
*
*******************************************************************************/

public class RandomKeyValue {
    private static final int MAX = 100; // Max value for integer part
    private final int amount;
    private Random random;

    // Default constructor. Initializes an instance of the randomomizer
    public RandomKeyValue(int amount, long seed) {
        this.amount = amount;
        this.random = new Random();
        this.random.setSeed(seed);
    }
    
    /**
     * Creates an array populated with random integers in a specified interval.
     * @return the array
     */
    public int[] randomizeInt() {
        int[] randomizedIntArray = new int[amount];
        for(int i = 0; i < amount; i++) {
            randomizedIntArray[i] = random.nextInt(MAX);
        }
        return randomizedIntArray;
    }
    
    /**
     * Creates an array populated with random strings(actually chars) in a 
     * specified interval.
     * @return the array
     */
    public String[] randomizeString() {
        String[] randomizedStringArray = new String[amount];
        for(int i = 0; i < amount; i++) {
            char character = (char) (random.nextInt(26) + 'A');
            randomizedStringArray[i] = Character.toString(character);
        }
        return randomizedStringArray;
    }
    
    /**
     * Contains unit testing for the class.
     * @param args takes no input arguments
     */
    public static void main(String[] args) {
        RandomKeyValue test = new RandomKeyValue(10, 100);
        int[] integers = test.randomizeInt();
        String[] strings = test.randomizeString();
        
        for (int i = 0; i < integers.length; i++) {
            System.out.println(strings[i] + " " + integers[i]);
        }
    }
}
