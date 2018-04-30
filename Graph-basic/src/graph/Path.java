package graph;

import java.util.Stack;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/4/29 18:57
 */
public abstract class Path {

    protected Graph graph;
    protected int originalNode;
    protected boolean[] visited;
    protected int[] from;

    public Path(Graph graph, int origin) {
        this.graph = graph;
        this.originalNode = origin;
        this.visited = new boolean[graph.getNumOfNodes()];
        this.from = new int[graph.getNumOfNodes()];
        for(int i = 0; i < from.length; i++) {
            this.from[i] = -1;
        }
        findPath(originalNode);
    }

//    public void dfs(int i) {
//        visited[i] = true;
//        Iterable<Integer> list = graph.getIterableList(i);
//        for (Integer integer : list) {
//            if(!visited[integer]) {
//                from[integer] = i;
//                dfs(integer);
//            }
//        }
//    }

    public abstract void findPath(int original);

    public boolean hasPath(int targetNode) {
        if( graph.getNumOfNodes() > targetNode&& targetNode >= 0) {
            return visited[targetNode];
        }
        return false;
    }

    public int[] path(int targetNode) {
        Stack<Integer> pathStack =  new Stack<>();
        for(int i = targetNode;i != -1; i = from[i]) {
            pathStack.push(i);
        }
        int[] path = new int[pathStack.size()];

        for(int i = 0; !pathStack.empty(); i++) {
            path[i] = pathStack.pop();
        }
        return path;
    }

    public void printPath(int targetNode) {
        int[] paths = path(targetNode);
        for (int i = 0; i < paths.length; i++) {
            System.out.print(paths[i]);
            if(i+1 < paths.length) {
                System.out.print(" --> ");
            }
        }
    }


}
