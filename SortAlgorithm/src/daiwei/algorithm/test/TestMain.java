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
        Integer[] randomArray = SortTestHelper.generateRandomArray(10000000, 0, 1000);
//        Integer[] randomArray = SortTestHelper.generateNearlyOrderedArray(10000, 100);
        Integer[] randomArray1 = randomArray.clone();
//        Integer[] randomArray2 = randomArray.clone();
//        SortTestHelper.testSort(SortName.SELECTION_SORT, randomArray1);
//        System.out.println(Arrays.toString(randomArray));
        SortTestHelper.testSort(SortName.MERGE_SORT,randomArray);
//        SortTestHelper.testSort(SortName.INSERTION_SORT, randomArray2);
        SortTestHelper.testSort(SortName.SHELL_SORT, randomArray1);
//        System.out.println(new Date().getTime());
//        System.out.println(Arrays.toString(randomArray));
    }
}
