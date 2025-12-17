#include <iostream>
using namespace std;


class DijointSet{
    private:
        vector<int> parent,size;
    public:
        DijointSet(int V) {
            parent.resize(V,0);
            size.resize(V,1);
            for(int i=0; i<V; i++) {
                parent[i] = i;
            }
        }

        int findUltimateParent(int node) {
            if(parent[node] == node) return node;

            return parent[node] = findUltimateParent(parent[node]);
        }

        void unionBySize(int nodeU,int nodeV) {
            int ultimateParent_Of_U = findUltimateParent(nodeU);
            int ultimateParent_Of_V = findUltimateParent(nodeV);

            if(ultimateParent_Of_U == ultimateParent_Of_V) return;

            if(size[ultimateParent_Of_U] < size[ultimateParent_Of_V]) {
                size[ultimateParent_Of_U] += size[ultimateParent_Of_V];
                parent[ultimateParent_Of_V] = ultimateParent_Of_U;
            } else {
                size[ultimateParent_Of_V] += size[ultimateParent_Of_U];
                parent[ultimateParent_Of_U] = ultimateParent_Of_V;
            }
        }

};

int main() {
    DijointSet ds(6);

    ds.unionBySize(1,2);
    ds.unionBySize(2,3);
    ds.unionBySize(3,4);
    ds.unionBySize(5,6);

    cout << "2,6 Belongs to same component ? " << (ds.findUltimateParent(2) == ds.findUltimateParent(6));

    return 0;
}