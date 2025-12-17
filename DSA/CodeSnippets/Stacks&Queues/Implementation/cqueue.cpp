#include <iostream>
using namespace std;

class CircularQueue {
private:
    static const int MAX_SIZE = 4;
    int arr[MAX_SIZE];
    int front;
    int rear;
    int count;

public:
    CircularQueue() {
        front = -1;
        rear = -1;
        count = 0;
    }

    bool isEmpty(){
        return count == 0;
    }

    bool isFull(){
        return count == MAX_SIZE;
    }

    void enqueue(int element) {
        if (isFull()) {
            cout << "Circular Queue Overflow" << endl;
            return;
        }
        rear = (rear + 1) % MAX_SIZE;
        arr[rear] = element;
        count++;
    }

    int dequeue() {
        if (isEmpty()) {
            cout << "Circular Queue Underflow" << endl;
            return -1;
        }

        int element = arr[front];
        front = (front + 1) % MAX_SIZE;
        count--;
        return element;
    }

    int size() const {
        return count;
    }

    int getRear() {
        return rear;
    }
};

    int main() {
        CircularQueue cq;

        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        // 1 -> 2 -> 3
        cout << "Size of Queue: " << cq.size() << endl;

        cq.dequeue();
        // 2 -> 3
        cout << "Size of Queue: " << cq.size() << endl;
        // 2 -> 3 -> 1
        cq.enqueue(1);
        // 2 -> 3 -> 1 -> 0
        cq.enqueue(0);

        cout << "Size of Queue: " << cq.size() << endl;

        cout << "Rear Index : " << cq.getRear();

        return 0;
    }