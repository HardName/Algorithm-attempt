package daiwei.algorithm.test;

import daiwei.algorithm.util.SortName;
import daiwei.algorithm.util.SortTestHelper;

/**
 * 测试主方法
 * @author DW
 * @version 1.0.0
 * @since 2018/3/3 10:49
 */
public class TestMain {

    public static void main(String[] args) {
        Integer[] randomArray = SortTestHelper.generateRandomArray(1000, 0, 100);
        SortTestHelper.testSort(SortName.SelectionSort, randomArray);
        SortTestHelper.printArray(randomArray);
    }
}
