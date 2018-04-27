package graph;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/4/26 22:17
 */
public abstract class Graph {

    protected int n;
    protected int m;
    protected boolean directed;

    public int getNumOfNodes() {
        return n;
    }

    public int getNumOfEdges() {
        return m;
    }

    public abstract void printGraph();

    public abstract boolean hasEdge(int v, int w);

    public abstract void addEdge(int v, int w);

    public abstract Iterable<Integer> getIterableList(int v);

}
