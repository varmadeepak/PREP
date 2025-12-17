import java.util.ArrayList;

class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Heapify up: maintain min-heap property after insertion
    private void heapifyUp(int idx) {
        int parentInd = (idx - 1) / 2;
        if (idx > 0 && heap.get(idx) < heap.get(parentInd)) {
            swap(idx, parentInd);
            heapifyUp(parentInd);
        }
    }

    // Heapify down: maintain min-heap property after extraction
    private void heapifyDown(int idx) {
        int n = heap.size();
        int smallestInd = idx;
        int leftChildInd = 2 * idx + 1;
        int rightChildInd = 2 * idx + 2;

        if (leftChildInd < n && heap.get(leftChildInd) < heap.get(smallestInd)) {
            smallestInd = leftChildInd;
        }
        if (rightChildInd < n && heap.get(rightChildInd) < heap.get(smallestInd)) {
            smallestInd = rightChildInd;
        }
        if (smallestInd != idx) {
            swap(idx, smallestInd);
            heapifyDown(smallestInd);
        }
    }

    // Insert element
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    // Get min element
    public int getMin() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }
        return heap.get(0);
    }

    // Extract min element
    public int extractMin() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }
        int currMin = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heapifyDown(0);
        }
        return currMin;
    }

    // Print heap
    public void printHeap() {
        for (int val : heap) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Swap helper
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
        MinHeap minHeap = new MinHeap();
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(15);

        System.out.print("Heap elements: ");
        minHeap.printHeap();

        System.out.println("Min element: " + minHeap.getMin());

        System.out.println("Extracted min element: " + minHeap.extractMin());

        System.out.print("\nHeap elements after extraction: ");
        minHeap.printHeap();
    }
}
