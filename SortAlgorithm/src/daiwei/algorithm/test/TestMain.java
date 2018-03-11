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
        Integer[] randomArray = SortTestHelper.generateRandomArray(100, 0, 10000);
        Integer[] randomArray1 = randomArray.clone();
        Integer[] randomArray2 = randomArray.clone();
        Integer[] randomArray3 = randomArray.clone();
        SortTestHelper.testSort(SortName.SHELL_SORT, randomArray3);
        SortTestHelper.testSort(SortName.QUICK_SORT,randomArray1);
        SortTestHelper.testSort(SortName.MERGE_SORT, randomArray2);
//        System.out.println(SortTestHelper.isRightOrder(randomArray1, 100, randomArray1[0]));
//        SortTestHelper.testSort(SortName.INSERTION_SORT,randomArray);
    }
}
