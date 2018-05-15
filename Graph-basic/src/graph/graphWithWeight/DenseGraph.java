package graph.graphWithWeight;

import java.util.ArrayList;

import graph.common.Edge;
import graph.common.Graph;

/**
 * 带权图 邻接矩阵实现
 * @author DW
 * @version 1.0.0
 * @since 2018/5/13 15:39
 */
public class DenseGraph<Weight extends Comparable> extends Graph {

    private Edge<Weight>[][] g;

    public DenseGraph(int n, boolean isDirected ) {
        this.n = n;
        this.directed = isDirected;
        g = new Edge[n][n];
    }

    @Override
    public void printGraph() {}

    @Override
    public boolean hasEdge(int v, int w) {
        return g[v][w] == null?false:true;
    }

    public void addEdge(int v, int w, Weight weight) {
        if (v!=w&&hasEdge(v, w)) {
            g[v][w] = null;
            if(!directed) {
                g[w][v] = null;
            }
            m--;
        }
        if(v!=w) {
            Edge edge = new Edge<>(v, w, weight);
            g[v][w] = edge;
            if(!directed) {
                g[v][w] = edge;
            }
            m++;
        }
    }

    @Override
    public Iterable<Integer> getIterableList(int v) {
        if (v >= 0 && v < n) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (g[v][i] != null) {
                    list.add(i);
                }
            }
            return list;
        }
        return null;
    }

    @Deprecated
    @Override
    public void addEdge(int v, int w) {

    }
}
