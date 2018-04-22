package daiwei.Algorithm;

import java.util.Random;

/**
 * 未优化的并查集，并查集原始版本
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/4/21 12:26
 */
public class UnionFind1 {

    private int[] ids;
    private int count;

    public UnionFind1(int n) {
        Random random = new Random();
        ids = new int[n];
        count = 0;
        for (int i = 0; i < n; i++) {
            ids[i] = random.nextInt(n);
            count++;
        }
    }

    public int find(int q) {
        return ids[q];
    }

    public boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
    }

    public void union(int q, int p) {
        int qId = find(q);
        int pId = find(p);

        if (qId == pId) {
            return;
        }
        for (int i = 0; i < count; i++) {
            if (ids[i] == qId) {
                ids[i] = pId;
            }
        }
        ids[q] = ids[p];
    }

}
