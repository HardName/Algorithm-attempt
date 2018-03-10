package daiwei.algorithm.util;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import daiwei.algorithm.sort.*;

/**
 * 排序算法工具类
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/3/3 10:43
 */
public class SortTestHelper {



    /**
     * 随机生成一个 乱序的 int数组
     *
     * @param n          数组元素个数
     * @param ArrayLeft  左臂 数组最小值边界 [ArrayLeft, ArrayRight)
     * @param ArrayRight 右臂，数组最大值边界
     * @return 返回创建的数组
     */
    public static Integer[] generateRandomArray(int n, int ArrayLeft, int ArrayRight) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            int rand = new Random().nextInt(ArrayRight - ArrayLeft) + ArrayLeft;
            arr[i] = rand;
        }
        return arr;
    }

    /**
     * 产生一个近排序的数组(数组几乎是排好顺序的)
     * @param n     数组元素个数
     * @param timeSwap      数组中元素交换次数
     * @return
     */
    public static Integer[] generateNearlyOrderedArray(int n, int timeSwap) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Random random = new Random();
        for (int i = 0; i < timeSwap; i++) {
            int pos1 = random.nextInt(n);
            int pos2 = random.nextInt(n);
            swap(arr, pos1, pos2);
        }
        return arr;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArray(Integer[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 在一个数组中交换两个元素的位置
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(Comparable[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = (Comparable) temp;
    }

    public static void testSort(String sortName, Comparable[] arr) {

        long startTime = 0;
        long endTime = 0;
        switch (sortName) {
            case SortName.SELECTION_SORT:
                startTime = new Date().getTime();
                SelectionSort.sort(arr);
                endTime = new Date().getTime();
                break;

            case SortName.INSERTION_SORT:
                startTime = new Date().getTime();
                InsertionSort.sort(arr);
                endTime = new Date().getTime();
                break;

            case SortName.BUBBLE_SORT:
                startTime = new Date().getTime();
                BubbleSort.sortPro(arr);
                endTime = new Date().getTime();
                break;
            case SortName.SHELL_SORT:
                startTime = new Date().getTime();
                ShellSort.mySort(arr);
                endTime = new Date().getTime();
                break;
            case SortName.MERGE_SORT:
                startTime = new Date().getTime();
                MergeSort.sortBU(arr);
                endTime = new Date().getTime();
                break;
            case SortName.QUICK_SORT:
                startTime = new Date().getTime();
                QuickSort.sort(arr);
                endTime = new Date().getTime();
                break;
            case SortName.JAVA_DEFAULT:
                startTime = new Date().getTime();
                Arrays.sort(arr);
                endTime = new Date().getTime();
//              java util.arrays 使用的是 归并排序
                break;

            case SortName.BOBO_QUICKSORT:
                startTime = new Date().getTime();
                BobosQuickSort.sort(arr);
                endTime = new Date().getTime();
                break;
            default: break;

        }

        if(isSort(arr)) {
            System.out.println(arr.length + "个元素，" + sortName + " 排序算法，花费的时间为" + ((endTime - startTime) / 1000.0)+"s");
        } else {
            System.out.println("排序失败");
        }
    }

    /**
     * 判断排序是否完成
     * @param arr
     * @return
     */
    private static boolean isSort(Comparable[] arr) {
        if(arr[0].compareTo(arr[arr.length-1]) > 0) {
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i].compareTo(arr[i+1]) < 0) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i].compareTo(arr[i+1]) > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
