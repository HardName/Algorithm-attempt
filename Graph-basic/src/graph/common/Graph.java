package graph.common;

import java.io.*;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/4/26 22:17
 */
public abstract class Graph {

    protected int n;
    protected int m;
    protected boolean directed;
    private boolean[] visited;
    private int[] linkedKey;

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

    public void readGraph(String filePath) throws Exception {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            String[] graphInfo = line.split(" ");
            if (getNumOfNodes() == Integer.valueOf(graphInfo[0])) {
                while ((line = reader.readLine()) != null) {
                    String[] graphContent = line.split(" ");
                    Integer v = Integer.valueOf(graphContent[0]);
                    Integer w = Integer.valueOf(graphContent[1]);
                    if (v < getNumOfNodes() && v >= 0 && w < getNumOfNodes() && w >= 0) {
                        addEdge(v, w);
                    }
                }
            } else {
                throw new Exception("Reading graph failed, because the graph's size is not right !!!" +
                        "the init size should be " + graphInfo[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取这个图中有多少个连通分量
     *
     * @return
     */
    public int graphWalkNGetGroups() throws Exception {
        if (n == 0) {
            throw new Exception("graph doesn't load！！");
        }
        int cCount = 0;
        visited = new boolean[n];
        linkedKey = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                linkedKey[i] = cCount;
                dfs(i, cCount);
                cCount++;

            }
        }
        return cCount;
    }

    /**
     * 深度优先 dfs 遍历
     *
     * @param i
     * @param cCount
     */
    private void dfs(int i, int cCount) {
        visited[i] = true;
        Iterable<Integer> list = getIterableList(i);
        for (Integer integer : list) {
            if (!visited[integer]) {
                linkedKey[integer] = cCount;
                dfs(integer, cCount);
            }
        }
    }

    private void resetVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    public boolean isConnected(int v, int w) throws Exception {
        if (linkedKey==null) {
            graphWalkNGetGroups();
        }
        if (v < n && v >= 0 && w < n && w >= 0) {
            return linkedKey[v] == linkedKey[w];
        }
        return false;
    }

    public boolean hasCircle() throws Exception {
        if (n == 0) {
            throw new Exception("graph doesn't load！！");
        }
        for (int i = 0; i < n; i++) {
            if(hasCircle(i, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCircle(int i, int original) {
        Iterable<Integer> list = getIterableList(i);
        for (Integer integer : list) {
            if(integer == original) {
                return true;
            }
            if(hasCircle(integer, original)) {
                return true;
            }
        }
        return false;
    }
}
