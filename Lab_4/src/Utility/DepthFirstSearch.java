package Utility;
import edu.princeton.cs.algs4.Stack;

/*********************************** README ************************************
*
* Seminar 4 - Depth first search algorithm
* @author Alexander Lundqvist
* Created: 05-10-2021
*
* About this class:
* This class implements DPS(Depth first search) that can find paths between 
* specified vertices if there exists one.
* 
* Based on:
* <a href="https://algs4.cs.princeton.edu/41graph/DepthFirstSearch.java.html">Link</a>
* <a href="https://algs4.cs.princeton.edu/41graph/DepthFirstPaths.java.html">Link</a>
*
*******************************************************************************/

public class DepthFirstSearch {
    private boolean[] marked;           // marked[v] = is there an s-v path?
    private int[] edgeTo;               // edgeTo[v] = last edge on s-v path
    private final int source_vertex;    // source vertex
    
    /**
     * Initializes the DFS algorithm class
     * 
     * @param graph the graph
     * @param source_vertex the vertex we start the search from
     */
    public DepthFirstSearch(Graph graph, int source_vertex) {
        this.source_vertex = source_vertex;
        edgeTo = new int[graph.getVertices()];
        marked = new boolean[graph.getVertices()];
        dfs(graph, source_vertex);
    }
    
    // The idea is that we look in starting vertex bag, pick first item
    // then look in that items bag and so on untill it stops, then we go back
    // and continue with next item
    // Test B1 - B4
    private void dfs(Graph graph, int vertex) {
        // The vertex we start at will be marked as visited
        marked[vertex] = true;
        
        // For every adjacent element in the input vertex collection
        // if a vertex in the collection is already visited, we do nothing
        for (int adjacent_vertex : graph.adjacentVertices(vertex)) {
            
            // If we haven't visited a vertex
            if (!marked[adjacent_vertex]) {
                
                // Mark that there is a path between the input vertex and the
                // adjacent vertex.
                // This is done by writing the index of the previous vertex 
                // in the edgeTo array at the current adjacent_vertex index 
                edgeTo[adjacent_vertex] = vertex;
                
                // Recurse deeper into the graph by examining the adjacent vertex      
                dfs(graph, adjacent_vertex); 
            }
        }
    }
    
    /**
     * Tells us if there is a path to the input vertex
     * 
     * @param destination_vertex is the vertex
     * @return True if there is a path to destination vertex, else false
     */
    public boolean hasPathTo(int destination_vertex) {
        return marked[destination_vertex];
    }
    
    /**
     * Returns A path between the source vertex and the destination vertex.
     * The path is any path, not the shortest.
     * 
     * @param destination_vertex the destination vertex
     * @return the sequence of vertices on a path between the source vertex
     *         and destination vertex, as an Iterable
     */
    public Iterable<Integer> pathTo(int destination_vertex) {
        if (!hasPathTo(destination_vertex)) return null; // No path, do nothing
        
        // Create a new LIFO Stack to hold the path
        // Could also just have been an array in this case, but stack fits better
        // for abstract datatypes
        Stack<Integer> path = new Stack<Integer>();
        
        // Start at destination vertex, as long as it is not at the same index 
        // as source, push it to the stack
        // Then x is set to the previous vertex in the edgeTO ARRAY  
        for (int x = destination_vertex; x != source_vertex; x = edgeTo[x]) {
            path.push(x);           
        }
        
        // Finally push the source to the stack
        path.push(source_vertex);
        return path;
    }
    
    public void printEdge() {
        int i;
        System.out.println("EdgeTo:");
        System.out.print("[");
        for (i = 0; i < edgeTo.length-1; i++) {
            System.out.print(edgeTo[i] + ", ");
        }
        System.out.print(edgeTo[i] + "]");
    }
    
    public void printMarked() {
        int i;
        System.out.println("Marked:");
        System.out.print("[");
        for (i = 0; i < marked.length-1; i++) {
            System.out.print(marked[i] + ", ");
        }
        System.out.print(marked[i] + "]");
    }
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
    }
}
