package graph.normalGraph;

import java.util.ArrayList;

import graph.common.Graph;

/**
 * 稠密图 - 邻阶矩阵
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/4/22 23:15
 */
public class DenseGraph extends Graph {


    private Boolean[][] g;

    /**
     * 是否是有向图
     */
    private boolean directed;

    public DenseGraph(int n, boolean isDirected) {
        this.n = n;
        this.m = 0;
        this.directed = isDirected;
        g = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = false;
            }
        }
    }

    /**
     * 在顶点 v 和 w 中间添加一条边
     *
     * @param v
     * @param w
     */
    @Override
    public void addEdge(int v, int w) {
        if (v < n && v >= 0 && w < n && w >= 0) {
            if (!hasEdge(v, w)) {
                g[v][w] = true;
                if (!directed) {
                    g[w][v] = true;
                }
                m++;
            }
        }
    }

    /**
     * 判断两个节点之间是否有连接
     *
     * @param v
     * @param w
     * @return
     */
    @Override
    public boolean hasEdge(int v, int w) {
        if (v < n && v >= 0 && w < n && w >= 0) {
            return g[v][w];
        }
        return false;
    }

    /**
     * 获取某个与某个节点相连的node 的list
     * @param v
     * @return
     */
    @Override
    public Iterable<Integer> getIterableList(int v) {
        if (v >= 0 && v < n) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (g[v][i]) {
                    list.add(i);
                }
            }
            return list;
        }
        return null;
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(g[i][j]) {
                    System.out.print("1  ");
                } else {
                    System.out.print("0  ");
                }
            }
            System.out.println();
        }
    }
}
