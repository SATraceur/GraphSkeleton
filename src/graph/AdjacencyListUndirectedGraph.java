package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyListUndirectedGraph implements Graph {

    private List<Vertex> verticies = new ArrayList<>();
    
    @Override
    public void addEdge(String v, String w) {
        Vertex one = new Vertex(v);
        Vertex two = new Vertex(w);
        
        if(!verticies.contains(one)) { verticies.add(one); } // If vertex does not exist, add it to the graph.
        if(!verticies.contains(two)) { verticies.add(two); } // If vertex does not exist, add it to the graph.
        addEdge(one, two);
    }

    @Override
    public void addEdge(Vertex v, Vertex w) {
       verticies.get(verticies.indexOf(v)).addAdjacentVertex(verticies.get(verticies.indexOf(w)));  // Add vertex 2 to vertex 1's adjacency list 
       verticies.get(verticies.indexOf(w)).addAdjacentVertex(verticies.get(verticies.indexOf(v)));  // Add vertex 1 to vertex 2's adjacency list 
       v.incInDegree();                                                                             // Increment in degree of both verticies
       w.incInDegree();
    }

    @Override
    public List<Vertex> adjacentTo(String v) {
        return verticies.get(verticies.indexOf(new Vertex(v))).getAdjacentVerticies();
    }

    @Override
    public List<Vertex> adjacentTo(Vertex v) {
        return verticies.get(verticies.indexOf(v)).getAdjacentVerticies();
    }

    @Override
    public int degree(String v) {          // Chose to implement degree within vertex class
        return -1;
    }

    @Override
    public int degree(Vertex v) {
        return -1;
    }

    @Override
    public List<Vertex> getVertices() {
        Collections.sort(verticies);         // COME BACK TO THIS
        return verticies;
    }

    @Override
    public boolean hasEdge(String v, String w) {
        Vertex V = new Vertex(v);
        Vertex W = new Vertex(w);
        return verticies.get(verticies.indexOf(V)).getAdjacentVerticies().contains(W);
    }

    @Override
    public boolean hasEdge(Vertex v, Vertex w) {
        return verticies.get(verticies.indexOf(v)).getAdjacentVerticies().contains(w);
    }

    @Override
    public boolean hasVertex(String v) {
        return verticies.contains(new Vertex(v));
    }

    @Override
    public boolean hasVertex(Vertex vertex) {
        return verticies.contains(vertex);
    }

    @Override
    public Vertex getVertex(String v) {
        return verticies.get(verticies.indexOf(new Vertex(v)));
    }
    
}
