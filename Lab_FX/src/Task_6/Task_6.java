package Task_6;

import java.util.Scanner;
import Utility.*;
import java.io.FileNotFoundException;

/*********************************** README ************************************
*
* Seminar FX - Task 6: Shortest path in weighted digraph
* @author Alexander Lundqvist
* Created: 14-10-2021
*
* About this class:
* This class finds the shortest path between two vertices with the option of a 
* intermediate vertex. 
*
*
* Implement a program which allows the user to find the shortest path between 
* two nodes in a directed graph with edge weights, possibly passing through a 
* third node. I.e. the user should be able to ask questions like:
* Which is the shortest path from A to B passing through C? 
* The program should output an ordered list of the nodes to traverse from A to B 
* if such a path exists. If no such path exists then the program should output 
* that no such path exists.
* Use NYC.txt as input when not executing tests (in the case that the tests 
* should be executed you may use another input). This is the undirected road 
* network of New York City. The graph contains 264346 vertices and 733846 edges. 
* It is connected, contains parallel edges, but no self-loops. The edge weights 
* are travel times and are strictly positive. You should also calculate/show 
* the time complexity of your algorithm.
* This assignment requires that you study material on edge weighted graphs in the book. 
* (the algorithm is used in routing in the Internet, i.e. it is useful to know)
* 
*******************************************************************************/

public class Task_6 {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        String PATH = "NYCTest.txt";
        String DELIMITER = " ";
        
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(PATH, DELIMITER);
        
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
            if (!graph.contains(vertex_A)) {
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
            if (!graph.contains(vertex_B)) {
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
            if (!graph.contains(vertex_C)) {
                System.out.println("Vertex doesn't exist!");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error in input!");
            return;
        }
        
        // Find path
        
    }
}
