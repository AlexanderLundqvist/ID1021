package Task_3;

import Utility.BreadthFirstSearch;
import Utility.Graph;
import Utility.SymbolGraph;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*********************************** README ************************************
*
* Seminar 4 - task 3 Shortest path from A to C via B
* @author Alexander Lundqvist
* Created: 07-10-2021
*
* About this class:
* This class uses breadth first search to find the shortest path from a starting
* vertex to destination vertex via a third vertex. 
*
*
*******************************************************************************/

public class Task_3 {

    /**
     * Main method with unit testing for the class.
     * 
     * @param args takes no input arguments
     */    
    public static void main(String[] args) throws FileNotFoundException {
        // String PATH = "contiguous-usa.txt"; // Relative path to project root
        String PATH = "test.txt"; // Use for testing
        String DELIMITER = " ";
        
        SymbolGraph symbol_graph = new SymbolGraph(PATH, DELIMITER);
        Graph graph = symbol_graph.getGraph(); // Copy of the symbol table graph
        
        System.out.println("**************************************************************************");
        System.out.println("Testing of depth first search in graph based on file " + PATH);
        System.out.println("\nInput vertices that you want to find path between!");
        Scanner input = new Scanner(System.in);
        String vertex_A;
        String vertex_B;
        String vertex_C;
        
        // Input vertices
        System.out.println("\nStarting vertex: ");
        try {
            vertex_A = input.nextLine();
            if (!symbol_graph.contains(vertex_A)) {
                System.out.println("Vertex doesn't exist!");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error in input!");
            return;
        }
        
        System.out.println("\nIntermediate  vertex: ");
        try {
            vertex_B = input.nextLine();
            if (!symbol_graph.contains(vertex_B)) {
                System.out.println("Vertex doesn't exist!");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error in input!");
            return;
        }
        
        System.out.println("\nEnd vertex: ");
        try {
            vertex_C = input.nextLine();
            if (!symbol_graph.contains(vertex_C)) {
                System.out.println("Vertex doesn't exist!");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error in input!");
            return;
        }
        
        // Gets the ST index for the input strings/keys
        int start_index = symbol_graph.indexOf(vertex_A);
        int intermediate_index = symbol_graph.indexOf(vertex_B);
        int end_index = symbol_graph.indexOf(vertex_C);
        
        
        // Find shortest path 
        BreadthFirstSearch bfs_AB = new BreadthFirstSearch(graph, start_index);
        BreadthFirstSearch bfs_BC = new BreadthFirstSearch(graph, intermediate_index);
    
        
        // If so, use the iterable from depth first search class to iterate through the path
        // and print
        System.out.println();
        if (bfs_AB.hasPathTo(end_index) && bfs_AB.hasPathTo(end_index)) {
            System.out.println("The given vertices has the following path:\n");
            for(int index : bfs_AB.pathTo(intermediate_index)) {
                System.out.print(symbol_graph.nameAt(index) + " -> ");
            }
            for(int index : bfs_BC.pathTo(end_index)) {
                if(index == end_index) {// For the last vertex
                    System.out.print(symbol_graph.nameAt(index));
                }
                else {
                    System.out.print(symbol_graph.nameAt(index) + " -> ");
                }
            }
        }
        else System.out.println("\nNo path between " + vertex_A + " and " + vertex_B+ " and " + vertex_C);
        System.out.println();
        System.out.println();
        System.out.println("**************************************************************************");
    }
}
