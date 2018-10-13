package graph;

import java.util.List;

public interface Graph {
    
    /**
     * Add edge v-w.
     * @param v vertex v of the edge
     * @param w vertex w of the edge
     */
    void addEdge(String v, String w);

    /**
     * Add edge v-w.
     * @param v vertex v of the edge
     * @param w vertex w of the edge
     */
    void addEdge(Vertex v, Vertex w);

    /**
     * Neigbours of vertex v in lexicographic order.
     * @param v the vertex to find the neighbours of.
     * @return
     */
    List<Vertex> adjacentTo(String v);

    /**
     * Neigbours of vertex v in lexicographic order.
     * @param v the vertex to find the neighbours of.
     * @return
     */
    List<Vertex> adjacentTo(Vertex v);

    /**
     * number of neighbours of vertex v.
     * @param v
     * @return
     */
    int degree(String v);

    /**
     * number of neighbours of vertex v.
     * @param v
     * @return
     */
    int degree(Vertex v);

    /**
     * Get all the vertices associated with the graph in lexicographic order.
     * @return a list of adjacent vertices
     */
    List<Vertex> getVertices();

    /**
     * is v-w an edge in the graph
     * @param v
     * @param w
     * @return
     */
    boolean hasEdge(String v, String w);

    /**
     * is v-w an edge in the graph
     * @param v
     * @param w
     * @return
     */
    boolean hasEdge(Vertex v, Vertex w);

    /**
     * is v a vertex in the graph
     * @param v
     * @return
     */
    boolean hasVertex(String v);

    /**
     * is v a vertex in the graph?
     * @param vertex
     * @return
     */
    boolean hasVertex(Vertex vertex);
    
    /**
     * Gets the vertex in the graph with the label v
     * @param v
     * @return
     */
    Vertex getVertex(String v);

    
}
