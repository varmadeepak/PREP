import java.util.*;

class dfs{
    private static void performDFSForTopoSort(int node,List<List<Integer>> adj,boolean[] visited,Stack<Integer> stack){
        visited[node] = true;

        for(Integer adjNode : adj.get(node)) {
            if(!visited[adjNode]) {
                performDFSForTopoSort(adjNode,adj,visited,stack);
            }
        }
        stack.add(node);
    }
    private static List<Integer> findTopoSortOrdering(List<List<Integer>> adj,int V){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                performDFSForTopoSort(i,adj,visited,stack);
            }
        }
        List<Integer> topoSort = new ArrayList<>();
        while(!stack.isEmpty()) {
            topoSort.add(stack.pop());
        }
        return topoSort;
    }
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        /*
            Graph structure:

          5 ─────► 0 ◄───── 4
          │                 │
          │                 ▼ 
          ▼                 │
          2 ─────► 3 ─────► 1

        */

        List<Integer> topoSort = findTopoSortOrdering(adj,6);

        for(Integer node : topoSort) {
            System.out.print(node + " ");
        }
    }
}