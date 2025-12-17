
class Queue {
    private static final int MAX_SIZE = 1000;
    private int[] arr;
    private int front;
    private int rear;
    public Queue() {
        arr = new int[MAX_SIZE];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == MAX_SIZE - 1;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear++;
        arr[rear] = element;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int element = arr[front];
        front++;

        // Reset queue when it becomes empty
        if (front > rear) {
            front = -1;
            rear = -1;
        }

        return element;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return rear - front + 1;
    }
}

public class QueueImplementation {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(3);
        q.enqueue(2);
        q.enqueue(1);

        System.out.println("Size of Queue: " + q.size());

        q.dequeue();

        System.out.println("Size of Queue: " + q.size());
    }
}