package Utility;

/*********************************** README ************************************
*
* Seminar 3 - Frequency counter
* @author Alexander Lundqvist
* Created: 30-09-2021
*
* 
* This class implements a binary search symbol table.
* Based on:
* <a href="https://algs4.cs.princeton.edu/31elementary/BinarySearchST.java.html">Link</a>
*
*
*******************************************************************************/

import Task_2.BinarySearchSymbolTableTask2.*;
import Task_3.BinarySearchTreeTask3.*;

/* The {@code FrequencyCounter} class provides a client for 
 *  reading in a sequence of words and printing a word (exceeding
 *  a given length) that occurs most frequently. It is useful as
 *  a test client for various symbol table implementations.
 */
public class FrequencyCounter {
     
    /**
     * Reads in a command-line integer and sequence of words from
     * standard input and prints out a word (whose length exceeds
     * the threshold) that occurs most frequently to standard output.
     * It also prints out the number of words whose length exceeds
     * the threshold and the number of distinct such words.
     * @param args 
     */
    public static void main(String[] args) {
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<String, Integer>();

        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
    }
}
