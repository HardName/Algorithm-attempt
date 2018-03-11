package daiwei.heap;

import daiwei.util.HeapUtils;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/3/11 15:31
 */
public class MaxHeap<T extends Comparable> {

    private T[] data;
    private int count;

    public MaxHeap(int capacity) {
        data = (T[]) (new Comparable[capacity + 1]);
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(T t) {
//      上树操作

        if (count + 1 >= data.length) {
//            扩容操作
            T[] biggerData = (T[]) new Comparable[(int) (data.length * 1.5)];
            for (int i = 0; i < data.length; i++) {
                biggerData[i] = data[i];
            }
            data = biggerData;
        }
        data[count + 1] = t;
        shiftUp(count + 1);
        count++;

    }

    private void shiftUp(int k) {
        while (k > 1 && data[k].compareTo(data[k / 2]) > 0) {
            HeapUtils.swap(data, k, k / 2);
            k /= 2;
        }
    }

    public T[] getData() {
        return this.data;
    }

    public int getDataByIndex(int index) {
        if (this.data[index] instanceof Integer) {
            return (Integer) this.data[index];
        }
        return 0;
    }
}
