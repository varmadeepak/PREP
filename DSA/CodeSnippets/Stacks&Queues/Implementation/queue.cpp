#include <iostream>
using namespace std;

class Queue {
private:
    static const int MAX_SIZE = 1000;
    int arr[MAX_SIZE];
    int front;
    int rear;

public:
    Queue() : front(-1), rear(-1) {}

    bool isEmpty() const {
        return front == -1;
    }

    bool isFull() const {
        return rear == MAX_SIZE - 1;
    }

    void enqueue(int element) {
        if (isFull()) {
            cout << "Queue Overflow" << endl;
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear++;
        arr[rear] = element;
    }

    int dequeue() {
        if (isEmpty()) {
            cout << "Queue Underflow" << endl;
            return -1;
        }

        int element = arr[front];
        front++;

        // Reset queue when last element is removed
        if (front > rear) {
            front = rear = -1;
        }

        return element;
    }

    int size() const {
        if (isEmpty()) {
            return 0;
        }
        return rear - front + 1;
    }
};

int main() {
    Queue q;

    q.enqueue(3);
    q.enqueue(2);
    q.enqueue(1);

    cout << "Size of Queue: " << q.size() << endl;

    q.dequeue();

    cout << "Size of Queue: " << q.size() << endl;

    q.dequeue();
    q.dequeue();

    cout << "IS Queue Empty ?? " << q.isEmpty() << endl;

    return 0;
}