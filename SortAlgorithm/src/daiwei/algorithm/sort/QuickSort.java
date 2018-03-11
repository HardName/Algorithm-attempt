package daiwei.algorithm.sort;

import java.util.Random;

import daiwei.algorithm.util.SortTestHelper;

/**
 * 快速排序算法
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/3/10 10:33
 */
public class QuickSort {

    private static Random random = new Random();

    private QuickSort() {
    }

    /**
     * 对部分数组进行 partition 操作(核心操作)
     * partition：将数组的首位元素拿出，然后比遍历数组中的每个元素，
     * 如果比首位元素大，往前放
     * 4 | 2 1 3 | 6 5 7 8
     * 缺点：如果遇到有大量冗余数据，排序性能会急剧下降
     *
     * @param arr 排序数组
     * @param l   左边界 l
     * @param r   右边界 r
     * @return 返回中间值所在位置
     * [l, r]
     */
    private static int partition(Comparable[] arr, int l, int r) {

//       partition操作的中间元素 变为一个随机的位置的数字
        int m = random.nextInt(r - l + 1) + l;
        SortTestHelper.swap(arr, m, l);
        Comparable e = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(e) < 0) {
                j++;
                SortTestHelper.swap(arr, j, i);
            }
        }
        SortTestHelper.swap(arr, j, l);
        return j;
    }

    /**
     * 为防止大量冗余数据对性能的影响，partition所作出的优化
     * @param arr
     * @param l
     * @param r   [l,r]
     *            arr[l....i] <e< arr[j...r]
     */
    public static Integer partition4Redundancy(Comparable[] arr, int l, int r) {
        int ran = random.nextInt(r - l + 1) + l;
        SortTestHelper.swap(arr, l, ran);
        Comparable e = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(e) < 0) {
                i++;
            }
            while (j >= l + 1 && arr[j].compareTo(e) > 0) {
                j--;
            }
            if (j < i) {
                break;
            }
            SortTestHelper.swap(arr, j, i);
            i++;
            j--;
        }
        SortTestHelper.swap(arr, l, j);
        return j;
    }


    public static void quickSort3Ways(Comparable[] arr) {
        quickSort3ways(arr, 0, arr.length-1);
    }


    /**
     * 3路快速排序(对于有大量重复元素有很大的优势)
     * |||arr[l...lt]<e|||arr[lt+1....gt-1]=e|||arr[gt...r]>e|||||
     *
     * @param arr 要传快速排序的数组
     * @param l   该数组的左闭，即该数组的第一个元素的下标
     * @param r   该数组的右闭，即该数组的最后一个元素的下标
     *            [l, r]
     */
    private static void quickSort3ways(Comparable[] arr, int l, int r) {

        if (r <= l) {
            return;
        }

        /***********************partition 操作****************************/
        SortTestHelper.swap(arr, random.nextInt(r - l + 1)+l, l);
        Comparable e = arr[l];
        int gt = r+1;
        int lt = l ;
        int i = l + 1;
        while (i < gt) {
            if (e.compareTo(arr[i]) > 0) {
                SortTestHelper.swap(arr, lt+1, i);
                i++;
                lt++;
            } else if (e.compareTo(arr[i]) < 0) {
                SortTestHelper.swap(arr, i, gt-1);
                gt--;
            } else {
                i++;
            }
        }
        SortTestHelper.swap(arr, l, lt);


        /***********************递归调用****************************/
        quickSort3ways(arr, l, lt-1);
        quickSort3ways(arr, gt, r);
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
//          如果 r和l之间的元素少于15个 直接使用 O(n^2) 级别排序算法, 经过测试在只是简单排数的场景下，
//          如果添加其他类型的排序，会降低排序性能
//            ShellSort.sort(arr);
            return;
        }
        int p = partition4Redundancy(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }


}
