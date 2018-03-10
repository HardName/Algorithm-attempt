package daiwei.algorithm.sort;

import java.util.Date;

import daiwei.algorithm.util.SortTestHelper;

/**
 * 归并排序
 * 归并排序的优化方案，
 * 方案 一： 如果比较短的数组需要排序可以调用 O(n^2)级别的 插入排序
 * 方案二：在调用归并方法之前可以比较第一个数组的最后一个元素和最后一个元素的值
 * 如果第一个数组的最后一个元素的值比第二个数组的第一个元素值要小，则无需进行归并，因为两个数组都是有序的，所以
 * 如果 第一个数组的最后一个元素的值比第二个元素的第一个值要小，则，俩个数组直接进行拼接即可。。
 * @author DW
 * @version 1.0.0
 * @since 2018/3/7 19:49
 */
public class MergeSort {


    private MergeSort() {

    }

    /**
     * 把两个数组进行merge
     * 1 3 5 7|2 4 6 8
     * 1 2 3 4 5 6 7 8
     * [l,r]
     * @param arr 要传入排序的数组
     * @param l   要进行归并的左界
     * @param m   归并排序的中间点,前一个数组的最后一个位置
     * @param r   要归并排序的右界
     * @return
     */
    private static void mergeArr(Comparable[] arr, int l, int m, int r) {

        Comparable[] resArr = new Comparable[r-l+1];
        for(int i = 0; i <= r-l; i++) {
            resArr[i] =  arr[l+i];
        }

        int i = 0;  //第一个数组比较元素
        int j = m-l+1; //第二个数组比较元素位置

        for (int k = l; k <= r; k++ ) {
            if(i+l > m) {
//                i值越界 数组2直接灌入
                arr[k] = resArr[j];
                j++;
            } else if (j+l > r) {
//                j值越界，数组1直接灌入
                arr[k] = resArr[i];
                i++;
            } else if(resArr[i].compareTo(resArr[j]) < 0) {
                arr[k] = resArr[i];
                i++;
            } else {
                arr[k] = resArr[j];
                j++;
            }
        }
    }

    /**
     * 归并排序算法
     * 2 3 1 5 8 2 4| 6 4 8 1 0 3
     * @param arr   要传入的乱序数组
     * @param l     数组的左边界
     *              [l r]
     * @param r     length-1数组的右边界
     */
    public static void sort(Comparable[] arr, int l, int r) {
        if(l + 15 >= r) {
            ShellSort.sort(arr);
            return;
        }
        int m = (l+r)/2;
        sort(arr, l, m);
        sort(arr, m+1, r);
        mergeArr(arr, l,m,r);
    }

    /**
     * 自顶向下的的归并排序
     * @param arr
     */
    public static void sortBU(Comparable[] arr) {
        for (int sz = 1; sz <= arr.length ; sz *= 2 ) {
            for( int i = 0; i + sz <  arr.length; i+=2*sz ) {
                if(arr[i+sz-1].compareTo( arr[i+sz]) > 0 ) {
                    mergeArr(arr, i, i+sz-1, min(i+2*sz - 1, arr.length - 1));
                }
            }
        }
    }

    private static int min(int a , int b) {
        return a > b ? b:a;
    }

    public static void main(String[] args) {
        Integer[] randomArray = SortTestHelper.generateRandomArray(1000000, 0, 1000);
        long startTime = new Date().getTime();
        QuickSort.sort(randomArray);
        long endTime = new Date().getTime();
        System.out.println((endTime - startTime) / 1000.0);
    }
}
