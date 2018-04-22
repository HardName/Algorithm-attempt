package daiwei.Algorithm;

/**
 * 基于quick Union 的最终优化版本
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/4/21 22:44
 */
public class UnionFind4 {

    private int[] parent;
    private int count;
    private int[] rank;

    public UnionFind4(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            count++;
            rank[i] = 1;
        }
    }

    public int find(int q) {
        if (q >= 0 && q < count) {
            int qTemp = q;
            int level = 1;
            while (q != parent[q]) {
                q = parent[q];
                level++;
            }
            parent[qTemp] = q;
            return q;
        }
        return -1;
    }

    public boolean isConnected(int q, int p) {
        if (find(q) != -1 && find(p) != -1) {
            return find(q) == find(p);
        }
        return false;
    }

    public void union(int q, int p) {
        int qRoot = find(q);
        int pRoot = find(p);
        if (pRoot != qRoot && pRoot != -1 && qRoot != -1) {
            if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else {
                parent[qRoot] = pRoot;
                rank[pRoot]++;
            }
        }
    }
}
