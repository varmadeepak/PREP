#include <iostream>
using namespace std;

class Deque {
private:
    static const int MAX_SIZE = 4;
    int arr[MAX_SIZE];
    int front;
    int rear;
    int count;

public:
    Deque() {
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

    void push_front(int element) {
       if(isFull()) {
            cout << "OVERFLOW";
            return;
       }
       if(isEmpty()) {
            front = rear = 0;
       }
       else {
         front = (front - 1 + MAX_SIZE) % MAX_SIZE;
         // Imagine n=5 and front = 0 , to maintaing ciruclar concept ,we need to insert at index = 4 => (0-1 + 5) % 5 => 4
       }
       arr[front] = element;
       count++;
    }
    void push_rear(int element) {
        if(isFull()) {
            cout << "OVERFLOW";
            return;
       }
       if(isEmpty()) {
            front = rear = 0;
       }
       else {
            rear = (rear + 1) % MAX_SIZE;
       }
       arr[rear] = element;
       count++;
    }
    void pop_front() {
        if(isEmpty()) {
            cout << "UNDERFLOW" << endl;
            return;
        }
        if(front == rear) {
            front = rear = -1;
        }
        else {
            front = (front + 1) % MAX_SIZE;
        }
       count--;
    }
    void pop_rear() {
         if(isEmpty()) {
            cout << "UNDERFLOW" << endl;
            return;
        }
        if(front == rear) {
            front = rear = -1;
        }
        else {
            rear = (rear - 1 + MAX_SIZE) % MAX_SIZE;
        }
       count--;
    }
    int getFront() {return front;}
    int getRear() {return rear;}
};

int main () {
    Deque dq;

    dq.push_rear(1);
    dq.push_rear(2);
    dq.push_front(0);

    cout << "Front element: " << dq.getFront() << endl; // 0
    cout << "Rear element: " << dq.getRear() << endl;   // 2

    dq.pop_front();
    cout << "Front after deletion: " << dq.getFront() << endl; // 1

    dq.pop_rear();
    cout << "Rear after deletion: " << dq.getRear() << endl;   // 1

}