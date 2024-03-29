package com.yy.example.data_structure_and_algorithm.algorithm.book_algorithm_4;

/**
 * Description: 使用二叉堆实现的有序优先队列 大顶堆
 * <pre>
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/27/22 at 10:20 AM
 */
public class C2_04_01_MaxPQ_Impl_Heap<E extends Comparable>{

    private E[] pq;
    private int N = 0;

    public C2_04_01_MaxPQ_Impl_Heap(int MaxN) {
        pq = (E[])new Comparable[MaxN + 1];
    }

    public void insert(E key) {
        pq[++N] = key;
        swim(N);
    }

    public E delMax() {
        E max = pq[1];
        exch(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 如果父节点小于子节点，则互换，以使大的数上移
     *
     * 上浮：指的是 k 的变化趋势，是往上的
     *
     * @param k 数组下标
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 如果父节点小于子节点，则互换，以使大的数上移
     *
     * 下沉：指的是 k 的变化趋势：是往下的
     *
     * @param k 数组下标
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int tmp = k * 2;
            if(tmp < N && less(tmp, tmp + 1)) {
                tmp++;
            }
            if(!less(k, tmp)) {
                break;
            }
            exch(k, tmp);
            k = tmp;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        E key = pq[i];
        pq[i] = pq[j];
        pq[j] = key;
    }

    public static void main(String[] args) {

        C2_04_01_MaxPQ_Impl_Heap maxPQ_impl_heap = new C2_04_01_MaxPQ_Impl_Heap(10);
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        for (Integer key : array) {
            maxPQ_impl_heap.insert(key);
        }

        System.out.println("size:" + maxPQ_impl_heap.size());
        int size = maxPQ_impl_heap.size();
        for (int i = 0; i < size; i++) {
            Comparable key = maxPQ_impl_heap.delMax();
            System.out.print(key + " ");
        }
    }
}
