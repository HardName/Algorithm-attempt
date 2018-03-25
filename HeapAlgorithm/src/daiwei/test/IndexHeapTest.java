package daiwei.test;

import java.util.Random;

import daiwei.heap.IndexMaxHeap;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/3/22 22:58
 */
public class IndexHeapTest {

    public static void main(String[] args) {
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<>(10);
        for (int i = 0; i < 10; i++) {

            Random random = new Random();
            indexMaxHeap.insert(i,random.nextInt(20));
        }
        indexMaxHeap.HeapPrint();

        Integer integer = (Integer) indexMaxHeap.exactMax();
        System.out.println("max ---> " + integer);

        indexMaxHeap.changeItem(0, 100);
        indexMaxHeap.HeapPrint();


    }


}
