package cs143;

import java.util.*;

public class UnweightedGraph<V> extends AbstractGraph<V> {

    /**
     * Construct an empty graph
     */
    public UnweightedGraph() {
    }

    /**
     * Construct a graph from vertices and edges stored in arrays
     */
    public UnweightedGraph(V[] vertices, int[][] edges) {
        super(vertices, edges);
    }

    /**
     * Construct a graph from vertices and edges stored in List
     */
    public UnweightedGraph(List<V> vertices, List<Edge> edges) {
        super(vertices, edges);
    }

    /**
     * Construct a graph for integer vertices 0, 1, 2 and edge list
     */
    public UnweightedGraph(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    /**
     * Construct a graph from integer vertices 0, 1, and edge array
     */
    public UnweightedGraph(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    public boolean isConnected(V v1, V v2) {
        LinkedList<V> col = new LinkedList<>();
        ArrayList<V> vis = new ArrayList<>();
        col.addFirst(v1);
        while (!col.isEmpty()) {
            V v = col.removeFirst();
            if (!vis.contains(v)) {
                vis.add(v);
                if (v.equals(v2)) {
                    return true;
                }
                for (int i : getNeighbors(getIndex(v))) {
                    col.addFirst(getVertex(i));
                }
            }
        }
        return false;
    }

    public List<V> dfsPath(V v1, V v2) {
        List<V> vis = new ArrayList<>();
        dfsPath(v1, vis);
        int index = vis.indexOf(v2);
        if (index < 0) {
            return null;
        }
        vis = vis.subList(0, index + 1);
        return vis;
    }

    private void dfsPath(V v, List<V> vis) {
        vis.add(v);
        for (int i : getNeighbors(getIndex(v))) {
            if (!vis.contains(getVertex(i))) {
                dfsPath(getVertex(i), vis);
            }
        }
    }
}
