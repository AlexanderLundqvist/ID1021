package Task_1;

import Utility.Graph;
import edu.princeton.cs.algs4.ST;

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
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int source;         // source vertex

    /**
     * Computes a path between {@code source} and every other vertex in graph {@code graph}.
     * @param graph the graph
     * @param source the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= source < V}
     */
    public Task_1(Graph graph, int source) {
        this.source = source;
        edgeTo = new int[graph.V()];
        marked = new boolean[graph.V()];
        validateVertex(source);
        depthFirstSearch(graph, source);
    }

    // depth first search from v
    private void depthFirstSearch(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adjacentVertices(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                depthFirstSearch(graph, w);
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
        validateVertex(v);
        return marked[v];
    }

    /**
     * Returns a path between the source vertex {@code s} and vertex {@code v}, or
     * {@code null} if no such path.
     * @param  v the vertex
     * @return the sequence of vertices on a path between the source vertex
     *         {@code s} and vertex {@code v}, as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    
    
    /**
     * Main method with unit testing for the class.
     * @param args takes no input arguments
     */    
    public static void main(String[] args) {
        String PATH = "contiguous-usa.dat"; // Relative path to project root
        String DELIMITER = " ";
        
        
        //SymbolGraph symbol_graph = new SymbolGraph(PATH, DELIMITER);
        
    }
}
