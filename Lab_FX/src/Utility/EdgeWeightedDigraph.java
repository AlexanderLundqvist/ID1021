package Utility;

import edu.princeton.cs.algs4.Bag;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*********************************** README ************************************
*
* Seminar FX - Edge weighted directed graph
* @author Alexander Lundqvist
* Created: 03-11-2021
*
* About this class:
* This class implements a directed graph with weighted edges. It constructs the 
* graph from a specified file with a specific format. It supports operations 
* such as adding weighted and directed edges to the graph and also a method of 
* finding if a certain vertex exists in the graph.
*
* Based on:
* <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/EdgeWeightedGraph.java.html">Link</a>
* <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/DirectedEdge.java.html">Link</a>
*
*******************************************************************************/

public class EdgeWeightedDigraph {
    private final int vertices;             // Amount of vertices
    private int edges;                      // Amount of edges
    private Bag<Edge>[] adjacent_vertices;  // A list of all vertices with their respective connections
    
    /**
     * Initializes a new graph from a specified file path and with a specific delimiter.
     * This constructor assumes that the input file follows the correct format.
     * @param filename the path to the file
     * @param delimiter the specified delimiter
     * @throws FileNotFoundException 
     */
    public EdgeWeightedDigraph(String filename, String delimiter) throws FileNotFoundException{
        Scanner reader = new Scanner(new File(filename));
        
        // Since the input file follows a predefined format
        // the amount of vertices exists on the first line
        this.vertices = Integer.parseInt(reader.nextLine());
        
        // Consume the next line since it only contains the amount of edges
        reader.nextLine();
        
        // Create adjacency list. This list contains unique collections for every
        // vertex in the graph where any adjacent vertex is placed in the collection
        // of a specific vertex.
        this.adjacent_vertices = (Bag<Edge>[]) new Bag[this.vertices];
        
        // Create new collection for every vertex to hold their respective adjacent vertices
        for (int vertex_index = 0; vertex_index < this.vertices; vertex_index++) {
            adjacent_vertices[vertex_index] = new Bag<Edge>();
        }
        
        while(reader.hasNextLine()) {
            String[] path = reader.nextLine().split(delimiter);
            Edge edge = new Edge(Integer.parseInt(path[0]), Integer.parseInt(path[1]), Double.parseDouble(path[2]));
            this.addEdge(edge);
        }
    }
    
    /**
     * Initializes a standard graph with only the amount of vertices specified
     * @param amount_of_vertices the amount of vertices
     */
    public EdgeWeightedDigraph(int amount_of_vertices) {
        this.vertices = amount_of_vertices;
        
        // Create adjacency list. This list contains unique collections for every
        // vertex in the graph where any adjacent vertex is placed in the collection
        // of a specific vertex.
        this.adjacent_vertices = (Bag<Edge>[]) new Bag[amount_of_vertices];
        
        // Create new collection for every vertex to hold their respective adjacent vertices
        for (int vertex_index = 0; vertex_index < amount_of_vertices; vertex_index++) {
            adjacent_vertices[vertex_index] = new Bag<Edge>();
        }
    }
    
    // Helper class for giving edges weight and direction
    private class Edge {
        private final int from;
        private final int to;
        private final double weight;
        
        public Edge(int vertex_A, int vertex_B, double weight) {
            this.from = vertex_A;
            this.to = vertex_B;
            this.weight = weight;
        }
        
        public int from() {
            return this.from;
        }
        
        public int to() {
            return this.to;
        }
        
        public double weight() {
            return this.weight;
        }
    }
    
    /**
     * Adds an edge to the graph
     * @param edge the edge
     */
    public void addEdge(Edge edge) {
        edges++;
        adjacent_vertices[edge.from()].add(edge);
    }
    
    // WIP
    public boolean contains(String vertex) {
        return true;
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        
    }
}
