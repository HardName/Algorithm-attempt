package daiwei.algorithm.sort;

import daiwei.algorithm.util.SortTestHelper;

/**
 * 插入排序(在近乎有序的数组中，排序性能非常强大)
 * @author DW
 * @version 1.0.0
 * @since 2018/3/3 16:52
 */
public class InsertionSort {

    private InsertionSort() {}

    /**
     * 插入排序正常版
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j > 0&&arr[j-1].compareTo(arr[j]) > 0 ; j--) {
                 SortTestHelper.swap(arr, j, j-1);
            }
        }
    }

    /**
     * 插入排序优化版，在近排序的数据排序速度更加快
     * @param arr
     */
    public static void sortPro(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable e = arr[i];
            int index = i;
            for (int j = i; j > 0 && arr[j-1].compareTo(e) > 0; j--) {
                arr[j] = arr[j-1];
                index = j - 1  ;
            }
            arr[index] = e;

        }
    }
}
