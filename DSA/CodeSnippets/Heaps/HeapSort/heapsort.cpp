#include <iostream>
#include <vector>
using namespace std;

void heapify(vector<int> &arr, int heapSize, int i) {
  int largest = i;
  int left = 2 * i + 1;
  int right = 2 * i + 2;

  if (left < heapSize && arr[left] > arr[largest])
    largest = left;

  if (right < heapSize && arr[right] > arr[largest])
    largest = right;

  if (largest != i) {
    swap(arr[i], arr[largest]);
    heapify(arr, heapSize, largest);
  }
}

/**
 * When building max or min heap we need not consider leaf nodes
 * As leaf nodes are already in correct position
 * As any valid value > invalid value
 * leafNode < leftNull && leafNode > rightNull
 * This does not mean that when non leafs are heapfied leafs will not be touched
 * Heapify woul work as-is
 */
void buildMaxHeap(vector<int> &arr, int n) {
  for (int i = n / 2 - 1; i >= 0; i--)
    heapify(arr, n, i);
}

void heapSort(vector<int> &arr) {
  int n = arr.size();

  // Step 1: Build max heap
  buildMaxHeap(arr, n);

  // Step 2: Extract max repeatedly and heapify reduced heap
  for (int heapSize = n; heapSize > 1; heapSize--) {
    swap(arr[0], arr[heapSize - 1]); // Move max to end
    heapify(arr, heapSize - 1, 0);   // Restore max heap for reduced heap
  }
}
int main() {
  vector<int> arr = {70, 10, 10, 20, 40, 30};
  cout << "Before Sort:\n";
  for (int num : arr)
    cout << num << " ";
  cout << "\n";

  heapSort(arr);

  cout << "After Sort:\n";
  for (int num : arr)
    cout << num << " ";
  cout << "\n";

  return 0;
}
