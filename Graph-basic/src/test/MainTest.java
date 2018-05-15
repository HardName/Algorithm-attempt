package test;

import graph.Path.NormalPath;
import graph.Path.Path;
import graph.Path.ShortestPath;
import graph.normalGraph.SparseGraph;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/4/25 16:30
 */
public class MainTest {

    public static void main(String[] args) {

        String filePath = "src/graph/text/testG2.txt";
        SparseGraph sparseGraph = new SparseGraph(6, true);
        try {
            sparseGraph.readGraph(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sparseGraph.printGraph();
        Path path = new NormalPath(sparseGraph, 0);
        if (path.hasPath(5)) {
            System.out.print("\ndfs : ");
            path.printPath(5);
        }

        ShortestPath shortestPath = new ShortestPath(sparseGraph, 0);
        if(shortestPath.hasPath(5)) {
            System.out.print("\nbfs : ");
            shortestPath.printPath(5);
        }

    }
}
