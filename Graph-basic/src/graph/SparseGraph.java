package graph;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 疏密图 - 领接表
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/4/24 23:08
 */
public class SparseGraph extends Graph {

    private List<Integer>[] g;

    public SparseGraph(int n, boolean isDirected) {
        this.n = n;
        this.m = 0;
        this.directed = isDirected;
        this.g = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            g[i] = list;
        }
    }

    @Override
    public void addEdge(int v, int w) {
        if (v < n && v >= 0 && w < n && w >= 0) {
//            判断两个节点之间是否会存在边的情况，如果存在不做添加边操作，
//            因此理论上不存在平行边的情况
            if (v != w&&!hasEdge(v, w)) {
                g[v].add(w);
                if (!directed) {
                    g[w].add(v);
                }
                m++;
            }
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        if (v < n && v >= 0 && w < n && w >= 0) {
            for (int i = 0; i < g[v].size(); i++) {
                if(g[v].get(i).equals(w)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取一个可以获取一个节点周围节点的迭代器
     * @return
     */
    @Override
    public Iterable<Integer> getIterableList(int v) {
        if (v >= 0 && v < n) {
            Collections.sort(g[v]);
            return g[v];
        }
        return null;
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < n; i++) {
            Iterable<Integer> iterableList = getIterableList(i);
            Iterator<Integer> iterator = iterableList.iterator();
            System.out.print(i+" : ");
            while (iterator.hasNext()) {
                System.out.print(iterator.next()+" ");
            }
            System.out.println();
        }
    }

}
