import java.util.*;

public class GraphExample {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        int n = 5;
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        addEdge(0,1);
        addEdge(0,2);
        addEdge(1,3);
        addEdge(2,4);

        System.out.println("BFS traversal: ");
        bfs(0);
        visited = new boolean[n];
        System.out.println("\nDFS traversal: ");
        dfs(0);
    }
    static void addEdge(int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    //BFS
    static void bfs(int start){
        visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            for(int neighbor : graph.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }
    //DFS
    static void dfs(int node){
        visited[node] = true;
        System.out.print(node + " ");
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }
}
