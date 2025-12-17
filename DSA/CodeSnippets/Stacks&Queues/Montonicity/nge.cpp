#include <iostream>
#include <stack>
using namespace std;
vector<int> findNGE(vector<int>& arr) {
    int n = arr.size();
    vector<int> greater(n,-1);
    stack<int> st;
    for(int i=n-1; i>=0; i--) {

        // check if monotonicity breaks
        while(!st.empty() && st.top() <= arr[i]) {
            st.pop();
        }
        greater[i] = st.empty() ? -1 : st.top();
        st.push(arr[i]);
    }
    return greater;
}
int main() {
    vector<int> arr{1,3,4,2};
    vector<int> NGE = findNGE(arr);
    cout << "NGE elements " << endl;
    for(auto &it : NGE){
        cout << it << " ";
    }
    return 0;
}