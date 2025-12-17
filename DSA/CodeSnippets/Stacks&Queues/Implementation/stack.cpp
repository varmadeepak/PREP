#include <iostream>
#include <vector>
using namespace std;

class Stack {
    private:
        int top;
        int size;
        vector<int> arr;
    public:
        Stack(int n) {
            top = -1;
            size = n;
            arr.resize(n);
        }
        void push(int x) {
            if (top + 1 >= size) {
                cout << "OVERFLOW";
                return;
            }
            top++;
            arr[top] = x;
        }
        void pop() {
            if (top == -1) {
                cout << "UNDERFLOW";
                return;
            }
            top--;
        }
        int stackSize() {
            return top + 1;
        }
        void peek() {
            if (top == -1) {
                cout << "UNDERFLOW";
                return;
            }
            cout << arr[top];
        }
        void printStack() {
            cout << "------" << endl;
            for (int i = 0; i <= top; i++) {
                cout << arr[i] << " ";
            }
            cout << endl;
        }
};

int main() {
    Stack st(6);
    st.push(5);
    st.push(4);
    st.push(3);
    st.push(2);
    st.push(1);
    st.push(0);
    st.printStack();
    st.push(0);
    st.pop();
    st.printStack();
    cout << "PEEK ";
    st.peek();
    return 0;
}