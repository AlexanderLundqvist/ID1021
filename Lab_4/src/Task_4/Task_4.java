package Task_4;

import Utility.DepthFirstSearchDirected;
import Utility.Digraph;
import Utility.SymbolDigraph;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*********************************** README ************************************
*
* Seminar 4 - Task 4 Find path in directed graph
* @author Alexander Lundqvist
* Created: 07-10-2021
*
* About this class:
* This class uses depth first search in a symbol digraph to find paths between 
* specified vertices if there exists one.
* 
* Based on:
* <a href="">Link</a>
*
*******************************************************************************/

public class Task_4 {
    
     /**
     * Main method with unit testing for the class.
     * 
     * @param args takes no input arguments
     */   
    public static void main(String[] args) throws FileNotFoundException {
        //String PATH = "contiguous-usa.txt"; // Relative path to project root
        String PATH = "test.txt"; // Use for testing
        String DELIMITER = " ";
        
        SymbolDigraph symbol_digraph = new SymbolDigraph(PATH, DELIMITER);
        Digraph digraph = symbol_digraph.getDigraph(); // Copy of the symbol table graph
        
        System.out.println("**************************************************************************");
        System.out.println("Testing of depth first search in graph based on file " + PATH);
        System.out.println("\nInput vertices that you want to find path between!");
        Scanner input = new Scanner(System.in);
        String vertex_A;
        String vertex_B;
        
        // Input vertices
        System.out.println("\nStarting vertex: ");
        try {
            vertex_A = input.nextLine();
            if (!symbol_digraph.contains(vertex_A)) {
                System.out.println("Vertex doesn't exist!");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error in input!");
            return;
        }
        
        System.out.println("\nEnd vertex: ");
        try {
            vertex_B = input.nextLine();
            if (!symbol_digraph.contains(vertex_B)) {
                System.out.println("Vertex doesn't exist!");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error in input!");
            return;
        }
        
        // Gets the ST index for the input strings/keys
        int start_index = symbol_digraph.indexOf(vertex_A);
        int end_index = symbol_digraph.indexOf(vertex_B);
        
        // Searches the paths from starting vertex or vertex A
        DepthFirstSearchDirected dfs = new DepthFirstSearchDirected(digraph, start_index);

        // If so, use the iterable from depth first search class to iterate through the path
        // and print
        System.out.println();
        if(dfs.hasPathTo(end_index)) {
           System.out.println("The given vertices has the following path:\n");
            for(int index : dfs.pathTo(end_index)) {
                if(index == end_index) { // For the last vertex
                        System.out.print(symbol_digraph.nameAt(index));
                }
                else {
                        System.out.print(symbol_digraph.nameAt(index) + " -> ");
                }
            } 
        }
        else System.out.println("\nNo path between " + vertex_A + " and " + vertex_B);
        System.out.println();
        System.out.println();
        System.out.println("**************************************************************************");
        System.out.println();
        dfs.printEdge();
        System.out.println();
        dfs.printMarked();
        System.out.println();
    }
}
