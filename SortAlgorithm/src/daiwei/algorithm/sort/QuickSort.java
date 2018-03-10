package daiwei.algorithm.sort;

import java.util.Date;

import daiwei.algorithm.util.SortTestHelper;

/**
 * 快速排序算法
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/3/10 10:33
 */
public class QuickSort {

    private QuickSort() {
    }

    /**
     * 对部分数组进行 partition 操作
     * partition：将数组的首位元素拿出，然后比遍历数组中的每个元素，
     * 如果比首位元素大，往前放
     * 4 | 2 1 3 | 6 5 7 8
     *
     * @param arr 排序数组
     * @param l   左边界 l
     * @param r   右边界 r
     * @return 返回中间值所在位置
     * [l, r]
     */
    private static int partition(Comparable[] arr, int l, int r) {
        Comparable e = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(e) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, j, l);
        return j;
    }

    /**
     * 快速排序递归算法
     *
     * @param arr 要排序的数组
     * @param l   排序的左界
     * @param r   排序的右界
     *            [l, r]
     */
    private static void quickSort(Comparable[] arr, int l, int r) {

        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    private static void swap(Comparable[] arr, int a , int b) {
        Comparable t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public static void main(String[] args) {
        Integer[] randomArray = SortTestHelper.generateRandomArray(1000000, 0, 100000);
        long startTime = new Date().getTime();
        QuickSort.sort(randomArray);
        long endTime = new Date().getTime();
        System.out.println((endTime - startTime) / 1000.0);
    }
}
