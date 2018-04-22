package daiwei.test;

import java.util.Date;
import java.util.Random;

import daiwei.Algorithm.UnionFind3;
import daiwei.Algorithm.UnionFind4;

/**
 * 主要的测试类
 * @author DW
 * @version 1.0.0
 * @since 2018/4/21 13:48
 */
public class MainTest {

    public static void main(String[] args) {
//        Random random = new Random();
//        UnionFind4 uf = new UnionFind4(10);
////        System.out.println(uf.find(5));
//        System.out.println(uf.isConnected(5, 7));
////        uf.union(5,7);
//        System.out.println(uf.isConnected(5, 7));
//        for (int i = 0; i < 10; i++) {
//            uf.union(random.nextInt(6), random.nextInt(10));
//        }
//        System.out.println(uf.isConnected(3, 8));

        int n = 10000000;
        UnionFind4 uf4 = new UnionFind4(n);
        UnionFind3 uf3 = new UnionFind3(n);
        Random rand = new Random();
        Date start1 = new Date();
        for (int i = 0; i < n; i++) {
            uf4.union(rand.nextInt(n),rand.nextInt(n));
            uf4.isConnected(rand.nextInt(n),rand.nextInt(n));
        }
        Date end1 = new Date();

        Date start2 = new Date();
        for (int i = 0; i < n; i++) {
            uf3.union(rand.nextInt(n),rand.nextInt(n));
            uf3.isConnected(rand.nextInt(n),rand.nextInt(n));
        }
        Date end2 = new Date();

        System.out.println("uf4: " + n + " loops time is " + (end1.getTime() - start1.getTime())/1000.0+"s");
        System.out.println("uf3: " + n + " loops time is " + (end2.getTime() - start2.getTime())/1000.0+"s");
    }
}
