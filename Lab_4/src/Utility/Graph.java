package Utility;

import edu.princeton.cs.algs4.Bag;

/*********************************** README ************************************
*
* Seminar 4 - Graph utility class
* @author Alexander Lundqvist
* Created: 06-10-2021
*
* About this class:
* This class is an utility class that implements an undirected graph. 
* It implements an API based on the description in 
* <a href="https://algs4.cs.princeton.edu/41graph/">Princeton</a>.
 The class supports operations such as adding edges to the graph, iteration 
 over vertices adjacentVertices to a vertex and returning number of edges and vertices.
 
 
 Based on:
 <a href="https://algs4.cs.princeton.edu/41graph/Graph.java.html">Link</a>
*
*******************************************************************************/


public class Graph {
    private final int vertices;
    private int edges;
    private Bag<Integer>[] adjacentVertices;
    
    
    // Initialize a graph with V vertices 
    public Graph(int V) {
        this.vertices = V;
        this.edges = 0;
        
        adjacentVertices = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adjacentVertices[v] = new Bag<Integer>();
        }
    }
    
    /**
     * Adds an edge between vertex A and vertex B to the graph.
     * 
     * @param vertex_A First vertex
     * @param vertex_B 
     */
    public void addEdge(int vertex_A, int vertex_B) {
        
    }
    
    
    /**
     * Returns the vertices adjacent to the input vertex.
     *
     * @param  vertex the vertex
     * @return the vertices adjacent to the input vertex as an iterable
     */
    public Iterable<Integer> adjacentVertices(int vertex) {
        return adjacentVertices[vertex];
    }
    
    /**
     * Prints out the graph.
     * For debugging purpose.
     */
    public void graphToString() {
        
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input argument
     */
    public static void main(String[] args) {
        
        // Test methods
    }
}
