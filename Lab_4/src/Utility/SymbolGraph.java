package Utility;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
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
*  
*
* Based on:
* <a href="https://algs4.cs.princeton.edu/41graph/SymbolGraph.java.html">Link</a>
* 
* Implements: Graph, Symbol table
*
*******************************************************************************/

public class SymbolGraph {
    private ST<String, Integer> symbol_table;
    private String[] keys;
    private Graph graph;
    
    /**
     * 
     * @param filename is the filepath to the source file
     * @param delimiter the delimiter symbol for the text
     */
    public SymbolGraph(String filename, String delimiter) throws FileNotFoundException {
        symbol_table = new ST<String, Integer>();

        //File theText = new File("filteredtext.txt");
        Scanner reader_ST = new Scanner(new File("filteredtext.txt"));
        Scanner reader_graph = new Scanner(new File("filteredtext.txt"));
        
        // Reads file line for line and builds the symbol table that associates
        // each unique substring with an index.
        while (reader_ST.hasNextLine()) {
            // int ST_index = 0; // Index for the substring in the ST
            
            // Split each line into substrings
            String[] substring = reader_ST.nextLine().split(delimiter);
            // Check each substring and if unique/not in ST, then put it into the ST
            for (int i = 0; i < substring.length; i++) {
                if (!symbol_table.contains(substring[i])) {
                    symbol_table.put(substring[i], symbol_table.size()); // size() instead of ST_index++
                }
            }
        }
        
        // ??????
        // inverted index to get string keys in an array
        keys = new String[symbol_table.size()]; // String array
        for (String key : symbol_table.keys()) { // For every 
            keys[symbol_table.get(key)] = key; 
        }
        
        
        graph = new Graph(symbol_table.size());
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
     * Returns the graph assoicated with the symbol graph. It is the client's responsibility
     * not to mutate the graph.
     * @return the graph associated with the symbol graph
     */
    public Graph graph() {
        return graph;
    }
    
    public String name(int v) {
        return keys[v];
    }

    public boolean contains(String s) {
        return symbol_table.contains(s);
    }
    
    public int index(String s) {
        return symbol_table.get(s);
    }
    
    public void printGraph() {
        
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) throws FileNotFoundException {
        // Test building the graph
        String PATH = "routes.txt"; // Change depending on host
        SymbolGraph symbol_graph = new SymbolGraph(PATH, " ");
        Graph graph = symbol_graph.graph();
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            if (symbol_graph.contains(source)) {
                int s = symbol_graph.index(source);
                for (int v : graph.adjacentVertices(s)) {
                    StdOut.println("   " + symbol_graph.name(v));
                }
            }
            else {
                StdOut.println("input not contain '" + source + "'");
            }
        }
        
    }
}
