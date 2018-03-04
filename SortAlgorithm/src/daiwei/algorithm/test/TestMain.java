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

//    InsertionSortPro > bubbleSortPro > insertionSort > selectionSort > bubbleSort
    public static void main(String[] args) {
        Integer[] randomArray = SortTestHelper.generateRandomArray(30000, 0, 1000);
//        Integer[] randomArray = SortTestHelper.generateNearlyOrderedArray(10000, 100);
        Integer[] randomArray1 = randomArray.clone();

        Integer[] randomArray2 = randomArray.clone();
        SortTestHelper.testSort(SortName.SelectionSort, randomArray1);
        SortTestHelper.testSort(SortName.InsertionSort, randomArray2);
        SortTestHelper.testSort(SortName.BubbleSort, randomArray);
    }
}
