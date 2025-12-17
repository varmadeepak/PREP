#include <iostream>
#include <vector>
#include <queue>
#include <functional>
using namespace std;

int main() {
    int V = 6;
    vector<vector<int>> edges = {
        {0, 1, 4}, 
        {0, 2, 4}, 
        {1, 2, 2}, 
        {2, 3, 3}, 
        {2, 4, 1}, 
        {2, 5, 6}, 
        {4, 5, 3}  
    };

    vector<vector<pair<int,int>>> adj(V);
    for (auto &e : edges) {
        int u = e[0], v = e[1], wt = e[2];
        adj[u].push_back({v, wt});
        adj[v].push_back({u, wt});
    }

    vector<int> dist(V, 1e9);
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

    pq.push({0, 0});
    dist[0] = 0;

    while (!pq.empty()) {
        auto it = pq.top(); pq.pop();
        int currNode = it.second;
        int currDist = it.first;

        for (auto& nodeDist : adj[currNode]) {
            int adjNode = nodeDist.first;
            int adjNodeEdgeWt = nodeDist.second;

            int updatedWt = currDist + adjNodeEdgeWt;
            if (updatedWt < dist[adjNode]) {
                dist[adjNode] = updatedWt;
                pq.push({dist[adjNode], adjNode});
            }
        }
    }

    cout << "Distance From Source Node to all the other nodes : " << endl;
    for (int i = 0; i < V; i++) {
        cout << "Dist from 0 -> " << i << " ==> " << dist[i] << endl;
    }
}
