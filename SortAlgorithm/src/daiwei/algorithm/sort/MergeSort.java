package daiwei.algorithm.sort;

/**
 * 归并排序
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/3/7 19:49
 */
public class MergeSort {

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
        if(l >= r) {
            return ;
        }
        int m = (l+r)/2;
        sort(arr, l, m);
        sort(arr, m+1, r);
        mergeArr(arr, l,m,r);
    }
}
