#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

// Function to find shortest paths from a source node
// adj: adjacency list, where adj[u] contains {v, wt} pairs
// dist: vector storing {distance from source, parent node}
// sourceNode: starting node for Dijkstra
void findShortestPath(vector<vector<pair<int,int>>>& adj, vector<pair<int,int>>& dist, int sourceNode) {
    // Min-heap priority queue: {distance, node}
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

    // Distance to source is 0 and parent is itself
    dist[sourceNode] = {0, sourceNode};
    pq.push({0, sourceNode});

    while (!pq.empty()) {
        auto it = pq.top();
        pq.pop();
        int node = it.second;
        int curDist = it.first;

        // Skip if we already found a better distance
        if (curDist > dist[node].first) continue;

        // Explore neighbours
        for (auto& itr : adj[node]) {
            int adjNode = itr.first;
            int adjNodeEdgWt = itr.second;

            int updatedWt = curDist + adjNodeEdgWt;

            // If we found a shorter path to adjNode
            if (updatedWt < dist[adjNode].first) {
                dist[adjNode].first = updatedWt;   // update distance
                dist[adjNode].second = node;       // store parent
                pq.push({updatedWt, adjNode});
            }
        }
    }
}

int main() {
   int V = 6; // number of vertices

// Each edge: {u, v, weight}
// This graph is undirected for illustration.
// Diagram:
//
//      (4)
//   0 ------ 1
//   |        |
//  (4)     (2)
//   |        |
//   2 -------
//  / \      \
//(3) (1)    (6)
// /     \     \
// 3      4 --- 5
//        (3)
//
// Meaning:
// 0 --4-- 1
// 0 --4-- 2
// 1 --2-- 2
// 2 --3-- 3
// 2 --1-- 4
// 2 --6-- 5
// 4 --3-- 5
//
vector<vector<int>> edges = {
    {0, 1, 4}, // edge between 0 and 1 with weight 4
    {0, 2, 4}, // edge between 0 and 2 with weight 4
    {1, 2, 2}, // edge between 1 and 2 with weight 2
    {2, 3, 3}, // edge between 2 and 3 with weight 3
    {2, 4, 1}, // edge between 2 and 4 with weight 1
    {2, 5, 6}, // edge between 2 and 5 with weight 6
    {4, 5, 3}  // edge between 4 and 5 with weight 3
};
    // Step 1: Build adjacency list u -> {v, wt}Preferences: Open Settings (JSON)
    vector<vector<pair<int,int>>> adj(V);
    for (auto &e : edges) {
        int u = e[0], v = e[1], wt = e[2];
        adj[u].push_back({v, wt});
        adj[v].push_back({u, wt}); // remove this if directed graph
    }

    // Step 2: Distance array -> {distance from source, parent node}
    vector<pair<int,int>> dist(V, {1e9, -1});
    int source = 0;
    findShortestPath(adj, dist, source);

    // Step 3: Reconstruct shortest path from source to a target node
    int target = 5; // example: path from source to node 5
    vector<int> shortestPath;
    int node = target;
    while (node != source) {
        shortestPath.push_back(node);
        node = dist[node].second;
    }
    shortestPath.push_back(source);

    reverse(shortestPath.begin(), shortestPath.end());

    // Step 4: Print shortest path
    cout << "Shortest Path from " << source << " to " << target << ": ";
    for (int n : shortestPath) {
        cout << n << " ";
    }
    cout << "\nTotal Distance: " << dist[target].first << "\n";

    return 0;
}
