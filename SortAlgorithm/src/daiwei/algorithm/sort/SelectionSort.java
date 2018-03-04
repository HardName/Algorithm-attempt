package daiwei.algorithm.sort;

import daiwei.algorithm.util.SortTestHelper;

/**
 * 选择排序算法
 *  选择最小排序 即从头开始遍历找出最小个
 * @author DW
 * @version 1.0.0
 * @since 2018/3/3 13:30
 */
public class SelectionSort {

    private SelectionSort() {}

    public static void sort(Comparable[] arr) {
        //找出每轮最小值，然后和当前轮数的位置相调换
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            SortTestHelper.swap(arr, i, minIndex);
        }
    }
}
