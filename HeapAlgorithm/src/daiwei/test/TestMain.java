package daiwei.test;

import java.util.Random;

import daiwei.heap.MyMaxHeap;

/**
 * 主要测试类
 * @author DW
 * @version 1.0.0
 * @since 2018/3/11 16:30
 */
public class TestMain {

    public static void main(String[] args) {
        Random random = new Random();
//        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
//        for (int i = 0; i < 30; i++) {
//            maxHeap.insert(random.nextInt(50));
//        }

//        Integer[] datas = new Integer[30];
//        for (int i = 0; i < 30; i++) {
//            datas[i] = random.nextInt(50);
//        }
//        MaxHeap<Integer> maxHeap = new MaxHeap<>(datas);
//        HeapUtils.printData(maxHeap.getData());
////        System.out.println(maxHeap.getDataByIndex(2));
//        HeapUtils.treePrint(maxHeap);
//        System.out.println(maxHeap.exactMaxItem());
//        HeapUtils.treePrint(maxHeap);
//        System.out.println(maxHeap.exactMaxItem());
//        HeapUtils.treePrint(maxHeap);

        int n = 50;
        MyMaxHeap<Integer> myHeap = new MyMaxHeap<>(n);
        for (int i = 0; i < n; i++) {
            myHeap.insert(random.nextInt(50));
        }
//        for(int i = 0; i < n; i++) {
//            HeapUtils.treePrint(myHeap);
//            System.out.println("exactMax ----->  "+myHeap.exactMax());
//            HeapUtils.treePrint(myHeap);
//        }
        myHeap.sort();
        for (int i = 0; i < 50; i++) {
            System.out.print(myHeap.getDataByIndex(i) + " ");
        }
    }
}
