package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 稠密图 - 邻阶矩阵
 * @author DW
 * @version 1.0.0
 * @since 2018/4/22 23:15
 */
public class DenseGraph {

    /**
     * n 图中顶点数
     */
    private int n;

    /**
     * m 图中边数
     */
    private int m;

    private List<List<Boolean>> g;

    public DenseGraph(int n) {
        this.n = n;
        this.m = 0;
        g = new ArrayList<List<Boolean>>(n);
        ArrayList<Boolean> inner = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            inner.add(false);
        }
        for (int i = 0; i < n; i++) {
            g.add(inner);
        }
    }

    /**
     * 返回图中节点数量
     * @return
     */
    public int GetNumOfNodes() {
        return n;
    }

    /**
     * 返回图中边的数量
     * @return
     */
    public int getNumOfEdges() {
        return m;
    }
}
