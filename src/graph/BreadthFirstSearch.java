package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {

    Map<Vertex,Vertex> prev;
    Map<Vertex,Integer> dist;
    List<Vertex> l;
    
    public BreadthFirstSearch(Graph g, Vertex source) {
        prev = new HashMap<>();
        dist = new HashMap<>();
        l = new LinkedList<>();
        List<Vertex> vs = g.getVertices();
        for (Vertex v : vs) {
            if (v.equals(source)) { source = v; }
            v.setToUndiscovered();
        }
        bfs(source, g);
    }
    
     private void bfs(Vertex v, Graph g) {

        Queue<Vertex> q = new LinkedList<>();
       
        q.offer(v);
        dist.put(v, 0);
        
        while (!q.isEmpty()) {

            Vertex v2 = q.poll();
            v2.setToDiscovered();
            List<Vertex> vs = g.adjacentTo(v2);
            if (vs != null) {
                for (Vertex child : vs) {
                    if (child.isUndiscovered()) {
                        child.setToDiscovered();
                        q.offer(child);
                        // distance is the distance so far (dist.get(v2)) plus 1
                        dist.put(child, 1 + dist.get(v2));
                        prev.put(child, v2);
                    }
                }
            }
            v2.setToFinished();
            l.add(v2);
        }
    }
     
    public List<Vertex> getBreadFirstTraversalList() { return l; }
     
    public int getDistanceTo(Vertex to) {
         if (dist.get(to) != null) { return dist.get(to); }
         else { return -1; }
    }
     
    public List<Vertex> pathTo(Vertex to) {
         Stack<Vertex> path = new Stack<Vertex>();
         while (dist.containsKey(to)) {
             path.push(to);
             to = prev.get(to);
         }
         return path;
    }
}
