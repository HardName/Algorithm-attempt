package daiwei.algorithm.sort;

import daiwei.algorithm.util.SortTestHelper;

/**
 * 冒泡排序 bubble Sort
 * 两数比较，大的往后放
 * @author DW
 * @version 1.0.0
 * @since 2018/3/4 14:02
 */
public class BubbleSort {

    private BubbleSort() {}

    /**
     * 冒泡排序
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = 1; j < arr.length - i; j++ ) {
                if(arr[j-1].compareTo(arr[j]) > 0) {
                    SortTestHelper.swap(arr, j, j-1);
                }
            }
        }
    }

    /**
     * 冒泡排序改进版本 对比结果 InsertionSortPro > bubbleSortPro > insertionSort > selectionSort > bubbleSort
     * @param arr
     */
    public static void sortPro(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Comparable maxValue = arr[0];
            for (int j = 1; j < arr.length - i; j++) {
                if(maxValue.compareTo(arr[j]) > 0) {
                    arr[j-1] = arr[j];
                } else {
                    Comparable temp = arr[j];
                    arr[j] = maxValue;
                    maxValue = temp;
                }
            }
        }
    }
}
