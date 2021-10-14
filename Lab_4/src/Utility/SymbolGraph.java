package Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*********************************** README ************************************
*
* Seminar 4 - Symbol Graph
* @author Alexander Lundqvist
* Created: 07-10-2021
*
* About this class:
* This class implements a symbol graph which is an extension of the graph data
* structure. It supports adding vertices with symbols instead of integers such
* as Strings. The class builds the symbol graph with an input file and generates
* a structure with specified relationships.
*
* Based on:
* <a href="https://algs4.cs.princeton.edu/41graph/SymbolGraph.java.html">Link</a>
* 
*
*******************************************************************************/

public class SymbolGraph {
    private SymbolTable<String, Integer> symbol_table;
    private String[] keys;
    private Graph graph;
    
    /**
     * Constructor method. Initializes a new symbol graph.
     * 
     * @param filename is the filepath to the source file
     * @param delimiter the delimiter symbol for the text
     */
    public SymbolGraph(String filename, String delimiter) throws FileNotFoundException {
        symbol_table = new SymbolTable<String, Integer>();

        Scanner reader_ST = new Scanner(new File(filename));
        Scanner reader_graph = new Scanner(new File(filename));
        
        // First pass:
        // Reads file line for line and builds the symbol table that associates
        // each unique substring with an index.
        while (reader_ST.hasNextLine()) {
            
            // Split each line into substrings, in this case a line will be
            // AB CD -> {[AB],[CD]}
            String[] substring = reader_ST.nextLine().split(delimiter);
            // Check each substring and if unique/not in ST, then put it into the ST
            for (int i = 0; i < substring.length; i++) {
                if (!symbol_table.contains(substring[i])) { // If st doesnt contain the string/name/vertex
                    // size() instead of ST_index++, since ST size is initially 0 and incremented every put
                    symbol_table.put(substring[i], symbol_table.size());  
                }
            }
        }
        
        // Creates a string array where we invert the symbol table. Only for nameOf().
        // Princeton class might use it more, but here it is only implemented so we don't have to
        // call get function all the time.
        // E.x {KEY: SomeString, VAL: SomeInteger} -> keys[SomeInteger] = SomeString
        keys = new String[symbol_table.size()]; // String array
        for (String key : symbol_table.keys()) { // For every key/vertex in the ST, add to new key list
            // Get normaly associated with value, but here value is just the index of the vertex
            // We place the ST key in the array at the index that corresponds to the value of the key
            keys[symbol_table.get(key)] = key;
        }
        
        graph = new Graph(symbol_table.size()); // Initialize the underlying graph
        
        // Second pass:
        // Build graph by connecting each vertex on a line with each other
        while (reader_graph.hasNextLine()) {
            // Split each line into substrings
            String[] substring = reader_graph.nextLine().split(delimiter);
            
            int vertex_A = symbol_table.get(substring[0]); // Gets substring index for inputing as vertex in graph
            for (int i = 1; i < substring.length; i++) { // Adds every string on the line to the first strings adjacency collection (bag)
                int vertex_B = symbol_table.get(substring[i]);
                graph.addEdge(vertex_A, vertex_B);
            }
        }
    }
    
    /**
     * Returns the graph associated with the symbol graph. 
     * 
     * @return the graph associated with the symbol graph
     */
    public Graph getGraph() {
        return graph;
    }
    
    /**
     * Returns the name of the vertex associated with the index.
     * 
     * @param index the index
     * @return the vertex name/symbol/key at the index
     */
    public String nameAt(int index) {
        return keys[index];
    }
    
    /**
     * Finds out if the graph has a vertex with the given key.
     * 
     * @param key the key
     * @return true or false 
     */
    public boolean contains(String key) {
        return symbol_table.contains(key);
    }
    
    /**
     * Gets the index in the symbol table for the input key
     * 
     * @param key the key
     * @return the index
     */
    public int indexOf(String key) {
        return symbol_table.get(key);
    }
    
    // For debugging
    public void toStringST() {
        symbol_table.toStringST();
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) throws FileNotFoundException {
    }
}
