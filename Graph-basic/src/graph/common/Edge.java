package graph.common;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/5/13 15:16
 */
public class Edge<Wight extends Comparable> implements Comparable<Edge> {

//    a b 表顶点，a --> b
    private int a;
    private int b;
    private Wight wight;

    public Edge(int a, int b, Wight wight) {
        this.a = a;
        this.b = b;
        this.wight = wight;
    }

    public Edge(){}

    public int v() {
        return this.a;
    }

    public int w() {
        return this.b;
    }

    public int other(int node) throws Exception {
        if(node == this.a || node == this.b) {
            return node == a?b:a;
        }
        throw new Exception("node doesn't exist in this edge");
    }

    @Override
    public String toString() {
        return "Edge{" +
                "a=" + a +
                ", b=" + b +
                ", wight=" + wight +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.wight.compareTo(o.wight);
    }
}
