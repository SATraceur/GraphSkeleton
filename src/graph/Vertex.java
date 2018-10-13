package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Vertex implements Comparable<Vertex> {
    
    private String label;
    private int state; // 0 == unvisisted, 1 == discovered, 2 == finished
    private List<Vertex> adjacentVerticies = new ArrayList<>();
    private int inDegree = 0;
    
    public Vertex(String label) {
        this.label = label;
        state = 0;   
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.label);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex other = (Vertex) obj;
        if (!Objects.equals(this.label, other.label)) {
            return false;
        }
        return true;
    }
 
    @Override
    public int compareTo(Vertex t) {
        return this.label.compareTo(t.label);
    }
    
    @Override
    public String toString() {
        // a use value to see the true identy of an object
        //return String.valueOf(System.identityHashCode(this));
        return this.label;
    } // Output label of vertex.

    public String getLabel() { return label; }
    
    public void setToDiscovered() { state = 1; }
    
    public void setToFinished() { state = 2; }
     
    public void setToUndiscovered() { state = 0; }
    
    public boolean isUndiscovered() { return state == 0; }

    public List<Vertex> getAdjacentVerticies() { // Return sorted list of adjacent verticies
        Collections.sort(adjacentVerticies);
        return adjacentVerticies; 
    } 

    public void addAdjacentVertex(Vertex adjacentVertex) {             // Add an adjacent vertex to the list.
        this.adjacentVerticies.add(adjacentVertex);
    }
        
    public void incInDegree() { this.inDegree++; }
    
    public int getInDegree() { return this.inDegree; }
}
