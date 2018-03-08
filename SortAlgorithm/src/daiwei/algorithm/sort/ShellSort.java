package daiwei.algorithm.sort;

/**
 * 希尔排序
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/3/4 23:30
 */
public class ShellSort {


    private ShellSort() {
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void sort(Comparable[] arr) {

        int n = arr.length;

        int step = 0;

        //获取增进量
        while (step  < n/3 ) {
            step = 3 * step + 2;
        }

        while (step >= 1) {
//            让每个元素都要出来进行比较
            for (int i = step; i < n; i++) {
                Comparable e = arr[i];
                int j = i;
                for ( ; j >= step&&e.compareTo(arr[j-step]) < 0; j-=step) {
                    arr[j] = arr[j-step];
                }
                arr[j] = e;
            }
            step /= 2;
        }

    }


    public static void  mySort(Comparable[] arr) {
        int n = arr.length;

        int step = 0;
        while(3*step < n) {
            step = 3*step + 1;
        }

        while (step >= 1) {
            for(int i = step; i < n; i++) {
                Comparable e = arr[i];
                int j = i;
                for(;j >= step&&e.compareTo(arr[j-step]) < 0; j-=step) {
                    arr[j-step] = arr[j];
                }
                arr[j] = e;
            }
            step /= 3;
        }
    }
}
