import java.util.ArrayList;

class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    private void heapifyUp(int idx) {
        int parentInd = (idx - 1) / 2;
        if (idx > 0 && heap.get(idx) > heap.get(parentInd)) {
            swap(idx, parentInd);
            heapifyUp(parentInd);
        }
    }

    private void heapifyDown(int idx) {
        int n = heap.size();
        int largestInd = idx;
        int leftChildInd = 2 * idx + 1;
        int rightChildInd = 2 * idx + 2;

        if (leftChildInd < n && heap.get(leftChildInd) > heap.get(largestInd)) {
            largestInd = leftChildInd;
        }
        if (rightChildInd < n && heap.get(rightChildInd) > heap.get(largestInd)) {
            largestInd = rightChildInd;
        }
        if (largestInd != idx) {
            swap(idx, largestInd);
            heapifyDown(largestInd);
        }
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int getMax() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }
        return heap.get(0);
    }

    public int extractMax() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }
        int currMax = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heapifyDown(0);
        }
        return currMax;
    }

    public void printHeap() {
        for (int val : heap) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public int getSize() {
        return heap.size();
    }
}

public class Heap {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.insert(15);

        System.out.print("Heap elements: ");
        maxHeap.printHeap();

        System.out.println("Max element: " + maxHeap.getMax());

        System.out.println("Extracted max element: " + maxHeap.extractMax());

        System.out.print("\nHeap elements after extraction: ");
        maxHeap.printHeap();
    }
}
