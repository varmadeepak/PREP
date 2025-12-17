//  KAHN'S ALGORITHM
import java.util.*;
public class BFS {
    private static int[] findTopoSortOrdering(List<List<Integer>> adj,int V){
        int[] topoSort = new int[V];
        int[] inDegree = new int[V];
        int ind = 0;
        for(int i=0; i<V; i++) {
            for(Integer node : adj.get(i)) {
                inDegree[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();

            topoSort[ind++] = node;

            for(int adjNode : adj.get(node)) {
                inDegree[adjNode]--;

                if(inDegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
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

        int[] topoSort = findTopoSortOrdering(adj,6);

        for(Integer node : topoSort) {
            System.out.print(node + " ");
        }
    }
}
