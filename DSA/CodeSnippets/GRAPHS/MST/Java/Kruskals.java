import java.util.*;

class DisjointSet {
    private final int[] parent;
    private final int[] size;
    private final int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }
    }

    private int findUltimateParent(int node) {
        if (parent[node] != node) {
            parent[node] = findUltimateParent(parent[node]); // path compression
        }
        return parent[node];
    }

    public boolean isConnected(int u, int v) {
        return findUltimateParent(u) == findUltimateParent(v);
    }

    public void unionByRank(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);

        if (pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
            rank[pv]++;
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Edge {
    final int u;
    final int v;
    final int weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("(%d -- %d, w=%d)", u, v, weight);
    }
}

class Solution {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        List<Edge> edges = new ArrayList<>();

        // Convert adjacency list into edge list
        for (int u = 0; u < V; u++) {
            for (List<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);
                int wt = neighbor.get(1);
                if (u < v) { // prevent duplicate edges
                    edges.add(new Edge(u, v, wt));
                }
            }
        }

        // Sort edges by weight (ascending)
        edges.sort(Comparator.comparingInt(e -> e.weight));

        DisjointSet ds = new DisjointSet(V);
        int mstWeight = 0;

        for (Edge edge : edges) {
            if (!ds.isConnected(edge.u, edge.v)) {
                mstWeight += edge.weight;
                ds.unionBySize(edge.u, edge.v);
            }
        }

        return mstWeight;
    }
}

class Kruskals {
    public static void main(String[] args) {
      List<List<List<Integer>>> adj = new ArrayList<>();

        // 0
        adj.add(Arrays.asList(
            Arrays.asList(5, 4),
            Arrays.asList(4, 1),
            Arrays.asList(2, 2)
        ));

        // 1
        adj.add(new ArrayList<>()); // no edges

        // 2
        adj.add(Arrays.asList(
            Arrays.asList(0, 2),
            Arrays.asList(4, 3),
            Arrays.asList(3, 3),
            Arrays.asList(6, 7)
        ));

        // 3
        adj.add(Arrays.asList(
            Arrays.asList(4, 5),
            Arrays.asList(2, 3),
            Arrays.asList(6, 8)
        ));

        // 4
        adj.add(Arrays.asList(
            Arrays.asList(5, 9),
            Arrays.asList(0, 1),
            Arrays.asList(2, 3),
            Arrays.asList(3, 5)
        ));

        // 5
        adj.add(Arrays.asList(
            Arrays.asList(0, 4),
            Arrays.asList(4, 9)
        ));

        // 6
        adj.add(Arrays.asList(
            Arrays.asList(2, 7),
            Arrays.asList(3, 8)
        ));

        Solution s = new Solution();
        System.out.println("MST Weight = " + s.spanningTree(7, adj));
    }
}
