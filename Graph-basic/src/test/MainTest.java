package test;

import java.util.Iterator;
import java.util.Random;

import graph.DenseGraph;
import graph.SparseGraph;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/4/25 16:30
 */
public class MainTest {

    public static void main(String[] args) {
        int n = 10;
        DenseGraph denseGraph = new DenseGraph(n, false);
        SparseGraph sparseGraph = new SparseGraph(n, false);
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int rand1 = rand.nextInt(n);
            int rand2 = rand.nextInt(n);
            System.out.println(rand1 + "&" + rand2);
            denseGraph.addEdge(rand1, rand2);
            sparseGraph.addEdge(rand1, rand2);
        }
        System.out.println("----------稠密图（邻接矩阵）------------");
        for (int i = 0; i < n; i++) {
            printLinkedNodes(denseGraph, i);
        }
        System.out.println("---------疏密图（领接表）--------------");
        for (int i = 0; i < n; i++) {
            printLinkedNodes(sparseGraph, i);
        }
    }

    private static void printLinkedNodes(DenseGraph denseGraph, int v) {
        Iterable<Integer> iterableList = denseGraph.getIterableList(v);
        printNodes(v, iterableList);
    }

    private static void printNodes(int v, Iterable<Integer> iterableList) {
        Iterator<Integer> iterator = iterableList.iterator();
        System.out.print(v+" : ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
    }

    private static void printLinkedNodes(SparseGraph sparseGraph, int v) {
        Iterable<Integer> iterableList = sparseGraph.getIterableList(v);
        printNodes(v, iterableList);
    }
}
