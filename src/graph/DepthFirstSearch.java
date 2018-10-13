package graph;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {
    List<Vertex> l = new LinkedList<>();
    
    public DepthFirstSearch(Graph g, Vertex source) {      
        List<Vertex> vs = g.getVertices();    
        
        for(Vertex v : vs) {                                          
            if (v.equals(source)) { source = v; }
            v.setToUndiscovered();
        }
        for(Vertex v : vs) {
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
     
    public List<Vertex> getDepthFirstTraversalList() { return l; }
     
}
