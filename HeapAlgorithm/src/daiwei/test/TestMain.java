package daiwei.test;

import java.util.Random;

import daiwei.heap.MaxHeap;
import daiwei.util.HeapUtils;

/**
 * 主要测试类
 * @author DW
 * @version 1.0.0
 * @since 2018/3/11 16:30
 */
public class TestMain {

    public static void main(String[] args) {
        Random random = new Random();
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        for (int i = 0; i < 50; i++) {
            maxHeap.insert(random.nextInt(50));
        }
        HeapUtils.printData(maxHeap.getData());
//        System.out.println(maxHeap.getDataByIndex(2));
        HeapUtils.treePrint(maxHeap);
    }
}
