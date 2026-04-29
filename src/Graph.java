import java.util.*;

public class Graph {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    Graph(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
    }
    void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    void printGraph(){
        for(int i=0; i<V; i++){
            System.out.print(i + " -> ");
            for(int n : adj.get(i)){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
    void BFS(int start){
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node+" ");
            for(int neighbor : adj.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }

        }
    }
    void DFS(int start){
        boolean[] visited = new boolean[V];
        dfsHelper(start, visited);
    }
    void dfsHelper(int node, boolean[] visited){
        visited[node] = true;
        System.out.print(node + " ");
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfsHelper(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,3);

        System.out.println("Graph: ");
        g.printGraph();

    }
}
