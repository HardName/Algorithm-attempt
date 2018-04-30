package graph;

/**
 * 求出路径的普通方法，不是最短路径
 * 使用<strong>dfs</strong> 方式实现，求出的路径由遍历的决定
 * @author DW
 * @version 1.0.0
 * @since 2018/4/30 10:07
 */
public class NormalPath extends Path {

    public NormalPath(Graph graph, int origin) {
        super(graph, origin);
    }

    @Override
    public void findPath(int original) {
        visited[original] = true;
        Iterable<Integer> list = graph.getIterableList(original);
        for (Integer item : list) {
            if(!visited[item]) {
                from[item] = original;
                findPath(item);
            }
        }
    }
}
