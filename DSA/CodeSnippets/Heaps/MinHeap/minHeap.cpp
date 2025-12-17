#include <iostream>
#include <vector>
using namespace std;

class MinHeap {
private:
    vector<int> heap;

    void heapifyUp(int idx) {
        int parentInd = (idx - 1) / 2;
        if (idx > 0 && heap[idx] < heap[parentInd]) {
            swap(heap[idx], heap[parentInd]);
            heapifyUp(parentInd);
        }
    }

    void heapifyDown(int idx) {
        int n = heap.size();
        int smallestInd = idx;
        int leftChildInd = 2 * idx + 1;
        int rightChildInd = 2 * idx + 2;

        if (leftChildInd < n && heap[leftChildInd] < heap[smallestInd]) {
            smallestInd = leftChildInd;
        }
        if (rightChildInd < n && heap[rightChildInd] < heap[smallestInd]) {
            smallestInd = rightChildInd;
        }
        if (smallestInd != idx) {
            swap(heap[idx], heap[smallestInd]);
            heapifyDown(smallestInd);
        }
    }

public:
    void insert(int value) {
        heap.push_back(value);
        heapifyUp(heap.size() - 1);
    }

    int getMin() {
        if (heap.empty()) {
            cout << "Heap is empty" << endl;
            return -1;
        }
        return heap[0];
    }

    int extractMin() {
        if (heap.empty()) {
            cout << "Heap is empty" << endl;
            return -1;
        }
        int currMin = heap[0];
        heap[0] = heap.back();
        heap.pop_back();
        if (!heap.empty()) {
            heapifyDown(0);
        }
        return currMin;
    }

    void printHeap() {
        for (int val : heap) cout << val << " ";
        cout << endl;
    }

    int getSize() {
        return heap.size();
    }
};

int main() {
    MinHeap minHeap;
    minHeap.insert(10);     
    minHeap.insert(20);
    minHeap.insert(5);
    minHeap.insert(30);
    minHeap.insert(10);     
    minHeap.insert(15);

    cout << "Heap elements: ";
    minHeap.printHeap();

    cout << "Min element: " << minHeap.getMin() << endl;

    cout << "Extracted min element: " << minHeap.extractMin() << endl;

    cout << "\nHeap elements after extraction: ";
    minHeap.printHeap();

    return 0;
}
