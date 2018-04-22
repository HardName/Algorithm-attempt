package daiwei.Algorithm;

/**
 * 基于 Quick Union 的优化版并查集
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/4/21 15:29
 */
public class UnionFind3 {

    private int[] parent;
    private int[] sz;
    private int count;

    public UnionFind3(int n) {
        parent = new int[n];
        sz = new int[n];
        count = 0;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            count++;
            sz[i] = 1;
        }
    }

    public int find(int q) {
        if (q >= 0 && q < count) {
            while (q != parent[q]) {
                q = parent[q];
            }
            return q;
        }
        return -1;
    }

    public boolean isConnected(int q, int p) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (qRoot != -1 && pRoot != -1) {
            return qRoot == pRoot;
        }
        return false;
    }

    public void union(int q, int p) {
        int qRoot = find(q);
        int pRoot = find(p);
        if (qRoot != pRoot && pRoot != -1 && qRoot != -1) {
            if (sz[qRoot] > sz[pRoot]) {
                parent[pRoot] = qRoot;
            } else {
                parent[qRoot] = pRoot;
            }
            if (sz[qRoot] == sz[pRoot]) {
                sz[pRoot]++;
            }

        }

    }
}
