package Utility;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;

/*********************************** README ************************************
*
* Seminar 4 - Digraph
* @author Alexander Lundqvist
* Created: 13-10-2021
*
* About this class:
* This class is an utility class that implements an directed graph or digraph. 
* 
*
* Based on:
* <a href="https://algs4.cs.princeton.edu/42digraph/Digraph.java.html">Link</a>
* <a href="https://algs4.cs.princeton.edu/41graph/Graph.java.html">Link</a>
*
*******************************************************************************/

public class Digraph {
    private final int vertices; 
    private int edges;          
    private Bag<Integer>[] vertices_list; // A list of all vertices with their respective connections
    
    /**
     * Constructor for the graph class. Initializes a new graph with specified
     * amount of vertices.
     * 
     * @param amount_of_vertices 
     */
    public Digraph(int amount_of_vertices) {
        this.vertices = amount_of_vertices;
        this.edges = 0;
        
        // Create adjacency list. This list contains unique collections for every
        // vertex in the graph where any adjacent vertex is placed in the collection
        // of a specific vertex.
        vertices_list = (Bag<Integer>[]) new Bag[amount_of_vertices];
        
        // Create new collection for every vertex to hold their respective adjacent vertices
        for (int vertex_index = 0; vertex_index < amount_of_vertices; vertex_index++) {
            vertices_list[vertex_index] = new Bag<Integer>();
        }
    }
    
    /**
     * Adds an edge between vertex A and vertex B to the graph.
     * 
     * @param vertex_A First vertex
     * @param vertex_B 
     */
    public void addEdge(int vertex_A, int vertex_B) {
        edges++;
        // Adds the vertex number(int) to the collection of adjacent vertices(Bag)
        vertices_list[vertex_A].add(vertex_B);
        // vertices_list[vertex_B].add(vertex_A); Removed for one way realationships
    }
    
    /**
     * Get method for returning the amount of vertices in the graph
     * 
     * @return amount of vertices
     */
    public int getVertices() {
        return vertices;
    }
    
    /**
     * Get method for returning the amount of edges in the graph
     * 
     * @return amount of edges
     */
    public int getEdges() {
        return edges;
    }
    
    /**
     * Returns the vertices adjacent to the input vertex.
     *
     * @param  vertex the vertex
     * @return the vertices adjacent to the input vertex as an iterable
     */
    public Iterable<Integer> adjacentVertices(int vertex) {
        return vertices_list[vertex]; // The unique collection for the sought vertex
    }
    
    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices, the number of edges and the adjacency lists
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(vertices + " vertices, " + edges + " edges\n");
        for (int i = 0; i < vertices; i++) {
            string.append(i + ": { ");
            for (int w : vertices_list[i]) {
                string.append(w + " ");
            }
            string.append("}\n");
        }
        return string.toString();
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input argument
     */
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        
        // Test add edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        
        // Test print
        StdOut.println(graph);
    }
}
