#include <iostream>
#include<vector>
using namespace std;

class Solution {
private:
    vector<int> arr;

    void heapify_up(int ind) {
        if(ind == 0) return;
        int parentInd = (ind - 1) / 2;

        if(arr[ind] > arr[parentInd]) {
            swap(arr[ind], arr[parentInd]);
            heapify_up(parentInd);
        }
    }

    void heapify_down(int ind) {
        int n = arr.size();
        int largestInd = ind;
        int leftChildInd = 2 * ind + 1;
        int rightChildInd = 2 * ind + 2;

        if(leftChildInd < n && arr[leftChildInd] > arr[largestInd])
            largestInd = leftChildInd;

        if(rightChildInd < n && arr[rightChildInd] > arr[largestInd])
            largestInd = rightChildInd;

        if(largestInd != ind) {
            swap(arr[ind], arr[largestInd]);
            heapify_down(largestInd);
        }
    }

public:
    void initializeHeap() {
        arr.clear();
    }

    void insert(int key) {
        arr.push_back(key);
        heapify_up(arr.size() - 1);
    }

    void changeKey(int index, int new_val) {
        if(index < 0 || index >= arr.size()) return;

        int old = arr[index];
        arr[index] = new_val;

        if(new_val > old)
            heapify_up(index);
        else
            heapify_down(index);
    }

    void extractMax() {
        if(arr.empty()) return;

        swap(arr[0], arr.back());
        arr.pop_back();
        heapify_down(0);
    }

    bool isEmpty() {
        return arr.empty();
    }

    int getMax() {
        if(arr.empty()) return -1;
        return arr[0];
    }

    int heapSize() {
        return arr.size();
    }

    void printHeap() {
        for(int x : arr)
            cout << x << " ";
        cout << endl;
    }
};

int main() {
    Solution heap;

    heap.initializeHeap();

    cout << "Inserting elements:\n";
    heap.insert(10);
    heap.insert(20);
    heap.insert(5);
    heap.insert(30);
    heap.insert(25);

    cout << "Heap array: ";
    heap.printHeap();

    cout << "\nMax element: " << heap.getMax() << endl;

    cout << "\nChanging value at index 2 to 40\n";
    heap.changeKey(2, 40);

    cout << "Heap after changeKey: ";
    heap.printHeap();

    cout << "\nExtracting max...\n";
    heap.extractMax();

    cout << "Heap after extractMax: ";
    heap.printHeap();

    cout << "\nHeap size: " << heap.heapSize() << endl;

    return 0;
}