package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求最短路径使用 <strong>bfs</strong> 实现
 * @author DW
 * @version 1.0.0
 * @since 2018/4/30 10:20
 */
public class ShortestPath extends Path {

    private int[] order;

    public ShortestPath(Graph graph, int origin) {
        super(graph, origin);

    }

    @Override
    public void findPath(int original) {
        order= new int[graph.getNumOfNodes()];
        visited[original] = true;
        order[original] = 0;
        Queue<Integer> pathQueue = new LinkedList<>();
        pathQueue.offer(original);
        while (pathQueue.size() > 0 ) {
            Integer poll = pathQueue.poll();
            Iterable<Integer> list = graph.getIterableList(poll);
            for (Integer item : list) {
                if(!visited[item]) {
                    pathQueue.offer(item);
                    visited[item] = true;
                    order[item] = order[poll]+1;
                    from[item] = poll;
                }
            }
        }
    }

    public int pathLength(int targetNode) {
        return order[targetNode];
    }
}
