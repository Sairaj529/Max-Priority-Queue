/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;

public class MaximumPQ<Type extends Comparable<Type>> implements Iterable<Type> {

    Type[] heap;
    int N;
    int capacity;

    public MaximumPQ() {
        capacity = 16;
        heap = (Type[]) new Comparable[capacity];
        N = 0;
    }

    public MaximumPQ(Type[] a) {
        this();
        for (Type item : a) {
            insert(item);
        }

    }

    public void insert(Type v) {
        if (capacity == N)
            resize();
        heap[++N] = v;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1) {
            int parent = k / 2;
            if (less(k, parent)) break;
            exch(k, parent);
            k = parent;
        }
    }

    private void exch(int i, int j) {
        Type temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void resize() {
        Type[] newHeap = (Type[]) new Comparable[N * 2];
        for (int i = 1; i < N + 1; i++) {
            newHeap[i] = heap[i];
        }
    }

    public Type delMax() {
        Type max = heap[1];
        heap[1] = heap[N--];
        sink(1);
        heap[N + 1] = null;
        return max;

    }

    private void sink(int k) {
        while (2 * k <= N) {
            int child = 2 * k;
            if (child < N && less(child, child + 1)) child += 1;
            if (less(child, k)) break;
            exch(k, child);
            k = child;
        }

    }

    public Iterator<Type> iterator() {
        return new IteratorClass();
    }

    private class IteratorClass implements Iterator<Type> {

        int i = 1;

        public boolean hasNext() {
            return i < N + 1;
        }

        public Type next() {
            return heap[i++];
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Type max() {
        return heap[1];
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        Integer[] a = { 8, 4, 6, 2, 9, 6, 7, 1, 5 };
        MaximumPQ<Integer> pq = new MaximumPQ<>(a);
        while (!pq.isEmpty()) {
            System.out.println(pq.delMax());
        }

    }
}
