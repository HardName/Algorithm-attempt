package daiwei.heap;

import daiwei.util.HeapUtils;

/**
 * 自己写一个简单的堆 下标索引从0 开始实现
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/3/15 21:23
 */
public class MyMaxHeap<T extends Comparable> {

    private T[] data;
    private Integer count;

    public MyMaxHeap() {
        this.data = (T[]) new Comparable[10];
        count = -1;
    }

    public MyMaxHeap(int n) {
        this.data = (T[]) new Comparable[n];
        count = -1;
    }

    public Boolean isEmpty() {
        return count == -1;
    }

    public Integer size() {
        return count+1;
    }

    public void insert(T e) {
//        自动扩容
//        if(count >= data.length -1) {
//            T[] temp = (T[]) new Comparable[data.length*3/2+1];
//            for (int i = 0; i < data.length; i++) {
//                temp[i] = data[i];
//            }
//            data = temp;
//        }
        count++;
        data[count] = e;
        shiftUp(count);
    }

    public T exactMax() {
        T max = data[0];
        HeapUtils.swap(data, count, 0);
        count--;
        shiftDown(0);
        return max;
    }

    /**
     * 出树操作
     * error
     * @param k
     * (k+1)*2 - 1   (k+1)*2
     */
    private void shiftDown(int k) {
        if(count == 1) {
            if(data[0].compareTo(data[1]) < 0) {
                HeapUtils.swap(data, 0, 1);
            }
        }
        while((k+1)*2 <= count && (data[k].compareTo(data[(k+1)*2]) < 0 ||data[k].compareTo(data[(k+1)*2-1]) < 0 ) ) {
            if(data[(k+1)*2].compareTo(data[(k+1)*2-1]) > 0) {
                HeapUtils.swap(data, k, (k+1)*2);
                k = (k+1)*2;
            } else{
                HeapUtils.swap(data, k, (k+1)*2-1);
                k = (k+1)*2-1;
            }
        }
    }

    /**
     * 上树操作
     *
     * @param count
     */
    private void shiftUp(int count) {
        while (count > 0 && data[(count - 1) / 2].compareTo(data[count]) < 0) {
            HeapUtils.swap(data, (count - 1) / 2, count);
            count = (count - 1) / 2;
        }
    }


    public void sort() {
        while (count >= 0) {
            HeapUtils.swap(exactMax(), data[count+1]);
        }

    }

    /**********辅助打印********************/
    public T[] getData() {
        return this.data;
    }


    public T getDataByIndex(int index) {
        return this.data[index];
    }


}
