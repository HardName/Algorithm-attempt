package daiwei.Algorithm;

/**
 * 并查集优化版
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/4/21 13:23
 */
public class UnionFind2 {

    private int[] parents;
    private int count;

    public UnionFind2(int n) {
        count = 0;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            count++;
        }
    }

    public int find(int q) {
        if (q < count && q >= 0) {
            while (q != parents[q]) {
                q = parents[q];
            }
            return q;
        }
        return -1;
    }

    public boolean isConnected(int q, int p) {
        return find(q) == find(p);
    }

    public void union(int q, int p) {
        int qRoot = find(q);
        int pRoot = find(p);

        if (qRoot != pRoot && pRoot != -1 && qRoot != -1) {
            parents[qRoot] = pRoot;
        }


    }
}
