package graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {

    private List<Vertex> l = new LinkedList<>();
    private List<Vertex> inDegree0 = new LinkedList<>();

    public TopologicalSort(Graph g) {       
        for(Vertex v : g.getVertices()) {                                 
            v.setToUndiscovered();                                        // Set all vertices to undiscovered.
            if(v.getInDegree() == 0) { inDegree0.add(v); }                // Get vertices with in degree of 0 and store in a list.
        }
        for(Vertex v : inDegree0) { 
            if(v.isUndiscovered()) { dfs(v, g); }
        }                                                 
    }
    
    private void dfs(Vertex v, Graph g) {       
        v.setToDiscovered();
        List<Vertex> vs = g.adjacentTo(v);       
        for(Vertex temp : vs) {
            if(temp.isUndiscovered()) { dfs(temp, g); }
        }
        v.setToFinished();
        l.add(v);      
    }
     
    public List<Vertex> getTopologicalSortList() { 
        Collections.reverse(l);
        return l; 
    }
        
}

