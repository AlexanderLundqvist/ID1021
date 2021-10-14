package Utility;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Queue;

/*********************************** README ************************************
*
* Seminar 4 - Breadth first search algorithm
* @author Alexander Lundqvist
* Created: 12-10-2021
*
* About this class:
* This class implements breadth first search that can find paths between 
* specified vertices if there exists one.
*
* Based on:
* <a href="https://algs4.cs.princeton.edu/41graph/BreadthFirstPaths.java.html">Link</a>
*
*******************************************************************************/

public class BreadthFirstSearch {
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private final int source_vertex;    // source vertex
    
    /**
     * Initializes the BFS algorithm class
     * 
     * @param graph the graph
     * @param source_vertex the vertex we start the search from
     */
    public BreadthFirstSearch(Graph graph, int source_vertex) {
        this.source_vertex = source_vertex;
        marked = new boolean[graph.getVertices()];
        edgeTo = new int[graph.getVertices()];   
        bfs(graph, source_vertex);
    }
    
    // Breadth first search algorithm
    private void bfs(Graph graph, int vertex) {
        // Using FIFO queue
        Queue<Integer> queue = new Queue<Integer>();
        
        // The vertex we start at will be marked as visited
        marked[vertex] = true;
        
        queue.enqueue(vertex);
        
        // Until every reachable vertex has been processed
        while (!queue.isEmpty()) {
            
            // Deque a vertex
            int current = queue.dequeue();
            
            // Go through all the vertices adjacent to current vertex
            for (int adjacent_vertex : graph.adjacentVertices(current)) {
                
                // If it is marked, go to next
                // Else
                if (!marked[adjacent_vertex]) {
                    
                    // write the index of the current vertex to the edgeTo
                    // at the index denoted by adjacent_vertex
                    // This is to illustrate what the previous vertex is
                    edgeTo[adjacent_vertex] = current;
                    
                    // Mark the vertex as visited
                    marked[adjacent_vertex] = true;
                    
                    // Queue the adjacent vertex for the next iteration of the while loop
                    queue.enqueue(adjacent_vertex);
                }
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
     * Returns the shortest path between the source vertex and the destination 
     * vertex.
     * 
     * @param destination_vertex the destination vertex
     * @return the sequence of vertices on a path between the source vertex
     *         and destination vertex, as an Iterable
     */
    public Iterable<Integer> pathTo(int destination_vertex) {
        if (!hasPathTo(destination_vertex)) return null; // No path, do nothing
        
        // Create a new LIFO Stack
        Stack<Integer> path = new Stack<Integer>();
        
        // Start at destination vertex, as long as it is not at the same index 
        // as source, push it to the stack. 
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
     * 
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {  
    }
}
