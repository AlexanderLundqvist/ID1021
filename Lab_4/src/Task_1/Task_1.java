package Task_1;

import Utility.Graph;
import Utility.SymbolGraph;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Stack;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*********************************** README ************************************
*
* Seminar 4 - Task 1 DPS (Depth first search) 
* @author Alexander Lundqvist
* Created: 05-10-2021
*
*
* This class implements DPS(Depth first search) that can find paths between 
* speciefied verticies if there exists one.
* 
* Based on:
* <a href="https://algs4.cs.princeton.edu/41graph/DepthFirstSearch.java.html">Link</a>
*https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/BreadthFirstPaths.java.html
* 
* For this part you should assume that the edges defined by the vertex pairs are two-way.
* Write a program based on DFS which can answer questions of the type: 
* "Find the a path from X to Y" Which should result in a list of vertices 
* traversed from X to Y if there is a path.
*
*******************************************************************************/

public class Task_1 {
    private boolean[] marked;       // marked[v] = is there an s-v path?
    private int[] edgeTo;           // edgeTo[v] = last edge on s-v path
    private final int source_vertex;       // source vertex 

    public Task_1(Graph graph, int source) {
        this.source_vertex = source;
        edgeTo = new int[graph.getVertices()];
        marked = new boolean[graph.getVertices()];
        depthFirstSearch(graph, source);
    }

    // depth first search from start_vertex
    private void depthFirstSearch(Graph graph, int start_vertex) {
        marked[start_vertex] = true;
        for (int adjacent_vertex : graph.adjacentVertices(start_vertex)) {
            if (!marked[adjacent_vertex]) {
                edgeTo[adjacent_vertex] = start_vertex;
                depthFirstSearch(graph, adjacent_vertex);
            }
        }
    }

    /**
     * Is there a path between the source vertex {@code s} and vertex {@code v}?
     * @param v the vertex
     * @return {@code true} if there is a path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * Returns a path between the source vertex {@code s} and vertex {@code destination_vertex}, or
     * {@code null} if no such path.
     * @param  destination_vertex the vertex
     * @return the sequence of vertices on a path between the source vertex
     *         {@code s} and vertex {@code destination_vertex}, as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= destination_vertex < V}
     */
    public Iterable<Integer> pathTo(int destination_vertex) {
        if (!hasPathTo(destination_vertex)) return null; //
        
        //
        Stack<Integer> path = new Stack<Integer>();
        
        //
        for (int x = destination_vertex; x != source_vertex; x = edgeTo[x]) {
            path.push(x);           
        }
        
        //
        path.push(source_vertex);
        return path;
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) throws FileNotFoundException {
        String PATH = "contiguous-usa.dat"; // Relative path to project root
        String DELIMITER = " ";
        
        
        SymbolGraph symbol_graph = new SymbolGraph(PATH, DELIMITER);
        
        
        System.out.println("**************************************************************************");
        System.out.println("Testing of depth first search in graph based on file " + PATH);
        System.out.println("Testing of depth first search in graph based on file " + PATH);
        Scanner input = new Scanner(System.in);
        System.out.println("Size of array: ");
            try {
                size = input.next();
            } catch (Exception e) {
                System.out.println("Wrong input!");
                break;

    }
}
