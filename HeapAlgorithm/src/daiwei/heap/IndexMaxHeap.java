package daiwei.heap;

import java.util.Arrays;

import daiwei.util.HeapUtils;

/**
 * 最大索引堆代码实现
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/3/22 22:27
 */
public class IndexMaxHeap<T extends Comparable> {

    private T[] data;
    private Integer[] indexes;
    private Integer[] rev;
    private int count;

    public IndexMaxHeap(int count) {
        data = (T[]) new Comparable[count + 1];
        indexes = new Integer[count + 1];
        rev = new Integer[count + 1];
        for (int i = 1; i < count + 1; i++) {
            rev[i] = 0;
        }
        indexes[0] = null;
        rev[0] = null;
        this.count = 0;
    }

    //    i从0开始
    public void insert(int i, Comparable e) {
        i = i + 1;
        data[i] = (T) e;
        indexes[count + 1] = i;
        rev[i] = count + 1;
        shiftUp(count + 1);
        count++;
    }

    private void shiftUp(int k) {

//        k 定义 k----> indexes 的下标
        while (k > 1 && (data[indexes[k]].compareTo(data[indexes[k / 2]]) > 0)) {
            HeapUtils.swap(indexes, k, k / 2);
            rev[indexes[k]] = k;
            rev[indexes[k / 2]] = k / 2;
            k = k / 2;
        }
    }

    public void HeapPrint() {

        System.out.print("indexes: null ");
        for (int i = 1; i <= count; i++) {
            System.out.print(indexes[i] + ", ");
        }
        System.out.println();

        System.out.println("  data :" + Arrays.toString(data));
        System.out.println(" rev :" + Arrays.toString(rev));
    }

    private int getIndexByData(Integer[] arr, int a) {
        for (int i = 1; i <= count + 1; i++) {
            if (a == arr[i]) {
                return i;
            }
        }
        return 0;
    }


    public Comparable exactMax() {
        Comparable c = data[indexes[1]];
        HeapUtils.swap(indexes, 1, count);
        rev[indexes[1]] = 1;
        rev[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return c;
    }


    //   data 数组从 0 开始
    public Integer exactMaxIndex() {
        Integer max = indexes[1] - 1;
        HeapUtils.swap(indexes, 1, count);
        rev[indexes[1]] = 1;
        rev[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return max;
    }


    // 堆是否为空
    public boolean isEmpty() {
        return count == 0;
    }


    //返回堆的size
    public Integer size() {
        return count;
    }

    //    拿索引从0开始
    public Comparable getDataItem(int i) {
        return data[i + 1];
    }

    //   替换data中的元素，索引从0开始
    public void changeItem(int i, Comparable c) {
        i += 1;
        data[i] = (T) c;
        int index = rev[i];
        if (index != 0) {
            shiftDown(index);
            shiftUp(index);
        }

    }


    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j]].compareTo(data[indexes[j + 1]]) < 0) {
                j += 1;
            }

            if (data[indexes[k]].compareTo(data[indexes[j]]) > 0) {
                break;
            }
            HeapUtils.swap(indexes, j, k);
            rev[indexes[j]] = j;
            rev[indexes[k]] = k;
            k = j;
        }
    }

}
