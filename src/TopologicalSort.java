import java.util.*;

public class TopologicalSort {

    // ---------- DFS METHOD ----------
    static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> graph) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack, graph);
            }
        }

        stack.push(node);
    }

    static void topoSortDFS(int V, List<List<Integer>> graph) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, graph);
            }
        }

        System.out.print("DFS Topological Sort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    // ---------- KAHN'S (BFS METHOD) ----------
    static void topoSortBFS(int V, List<List<Integer>> graph) {

        int[] indegree = new int[V];

        // Calculate indegree
        for (int i = 0; i < V; i++) {
            for (int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Add nodes with indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        System.out.print("BFS (Kahn's) Topological Sort: ");

        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            count++;

            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Cycle detection
        if (count != V) {
            System.out.print("\nCycle detected! Topological sort not possible.");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int V = 6;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Graph edges
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        topoSortDFS(V, graph);
        topoSortBFS(V, graph);
    }
}