// 215. Kth Largest Element in an Array

// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Can you solve it without sorting?

 

// Example 1:

// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

import java.util.*;

class PriorityQueueMax{
    private List<Integer> maxHeapElements;
   

    public PriorityQueueMax() {
        maxHeapElements = new ArrayList<>();
        
    }

    private void swap(List<Integer> maxHeapElements, int indA, int indB) {
        int temp = maxHeapElements.get(indA);
        maxHeapElements.set(indA, maxHeapElements.get(indB));
        maxHeapElements.set(indB, temp);
    }

    private void heapify_up(int ind) {
        int parentInd = (ind - 1) / 2;
        if(ind > 0 && maxHeapElements.get(parentInd) < maxHeapElements.get(ind)) {
            swap(maxHeapElements, parentInd, ind);
            heapify_up(parentInd);
        }
    }

    private void heapify_down(int ind) {
        int largestInd = ind;
        int leftChildInd = 2 * ind + 1;
        int rightChildInd = 2 * ind + 2;

        if(leftChildInd < maxHeapElements.size() &&
           maxHeapElements.get(leftChildInd) > maxHeapElements.get(largestInd)) {
            largestInd = leftChildInd;
        }

        if(rightChildInd < maxHeapElements.size() &&
           maxHeapElements.get(rightChildInd) > maxHeapElements.get(largestInd)) {
            largestInd = rightChildInd;
        }

        if(largestInd != ind) {
            swap(maxHeapElements, largestInd, ind);
            heapify_down(largestInd);
        }
    }

    public void pushElement(int element) {
        maxHeapElements.add(element);
        heapify_up(maxHeapElements.size() - 1);
    }

    public void removeMax() {
        if(maxHeapElements.size() == 0) return;
        swap(maxHeapElements, 0, maxHeapElements.size() - 1);
        maxHeapElements.remove(maxHeapElements.size() - 1);
        heapify_down(0);
    }

    public int getMaxElement() {
        if(maxHeapElements.size() == 0) return -1;
        return maxHeapElements.get(0);
    }

    public int getHeapSize() {
        return maxHeapElements.size();
    }
}

class LC215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueueMax pq = new PriorityQueueMax();

        for(int num : nums) {
            pq.pushElement(num);
        }

        for(int i = 0; i < k - 1; i++) {
            pq.removeMax();
        }

        return pq.getMaxElement();
    }

    // ✅ Driver code
    public static void main(String[] args) {
        LC215 sol = new LC215();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = sol.findKthLargest(nums, k);
        System.out.println("Kth largest element: " + result);

        // Optional: test heap directly
        PriorityQueueMax pq = new PriorityQueueMax();
        pq.pushElement(10);
        pq.pushElement(30);
        pq.pushElement(20);
        pq.pushElement(5);

        System.out.println("Max element: " + pq.getMaxElement());
        pq.removeMax();
        System.out.println("Max after removal: " + pq.getMaxElement());
        System.out.println("Heap size: " + pq.getHeapSize());
    }
}