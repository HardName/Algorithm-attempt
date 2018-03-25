package daiwei.search;

/**
 * 二分法查找 java 代码实现
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/3/25 13:42
 */
public class BinarySearch {


    /**
     * 根据二分法查找目标元素
     *
     * @param arr    已经排好序的有序数组
     * @param target [l, r]
     * @return 找到了返回目标的下标，没找到返回-1
     */
    public static Integer search(Comparable[] arr, Comparable target) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid].equals(target)) {
                return mid;
            }
            if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 对数组进行递归二分
     *
     * @param r 数组右闭
     * @param l 数组左闭
     * @return
     */
    public static Integer binaryArr(Comparable[] arr, int l, int r, Comparable target) {
        int mid = l + (r - l) / 2;
        if (arr[mid].equals(target) || l >= r) {
            return mid;
        }
        if (arr[mid].compareTo(target) > 0) {
            return binaryArr(arr, l, mid - 1, target);
        } else {
            return binaryArr(arr, mid + 1, r, target);
        }
    }

    /**
     * 使用递归法，进行二分查找
     *
     * @param arr
     * @param target
     * @return
     */
    public static Integer searchWithRec(Comparable[] arr, Comparable target) {
        Integer targetIndex = binaryArr(arr, 0, arr.length - 1, target);
        if (arr[targetIndex].equals(target)) {
            return targetIndex;
        }
        return -1;
    }

    /**
     * 获取target 值的 floor 如果这个这个target的index是0，返回 -1
     *
     * @param arr
     * @param target
     * @return
     */
    public static Integer getFloor(Comparable[] arr, Comparable target) {
        Integer res = binaryArr(arr, 0, arr.length - 1, target);
        if (arr[res].equals(target)) {
//            在arr中找到了目标
            while (res - 1 >= 0 && arr[res-1].equals(target)) {
                res--;
            }
            return res;
        } else {
            if (arr[res].compareTo(target) > 0) {
                res--;
            }
            return res < 0? -1: res;
        }
    }

    public static Integer getCeil(Comparable[] arr, Comparable target) {
        Integer res = binaryArr(arr, 0, arr.length - 1, target);
        if (arr[res].equals(target)) {
            while (res + 1 < arr.length &&arr[res+1].equals(target)) {
                res++;
            }
            return res;
        }
        if (arr[res].compareTo(target) < 0) {
            res++;
        }
        return res >= arr.length?-1:res;

    }
}
