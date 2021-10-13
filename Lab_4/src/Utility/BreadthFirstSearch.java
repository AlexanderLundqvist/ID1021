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
    private void bfs(Graph graph, int source_vertex) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[source_vertex] = true; // The vertex we start at will be marked as visited
        queue.enqueue(source_vertex);
        
        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            for (int adjacent : graph.adjacentVertices(current)) {
                if (!marked[adjacent]) {
                    edgeTo[adjacent] = current;
                    marked[adjacent] = true;
                    queue.enqueue(adjacent);
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
        // 
        //
        for (int x = destination_vertex; x != source_vertex; x = edgeTo[x]) { 
            path.push(x);           
        }
        
        // 
        path.push(source_vertex);
        return path;
    }
    
    public void printEdge() {
        int i;
        System.out.println("EdgeTo:");
        System.out.println("[");
        for (i = 0; i < edgeTo.length-1; i++) {
            System.out.print(edgeTo[i] + ", ");
        }
        System.out.print(edgeTo[i] + "]");
    }
    
    public void printMarked() {
        int i;
        System.out.println("Marked:");
        System.out.println("[");
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
