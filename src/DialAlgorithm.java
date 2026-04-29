import java.util.*;

class DialAlgorithm {

    static class Edge {
        int v, weight;

        Edge(int v, int w) {
            this.v = v;
            this.weight = w;
        }
    }

    static void dial(List<List<Edge>> graph, int V, int src, int W) {

        int INF = Integer.MAX_VALUE;
        int maxDist = W * V;

        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        List<Queue<Integer>> bucket = new ArrayList<>();

        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new LinkedList<>());
        }

        bucket.get(0).add(src);

        for (int i = 0; i <= maxDist; i++) {

            while (!bucket.get(i).isEmpty()) {

                int u = bucket.get(i).poll();

                if (i != dist[u]) continue;

                for (Edge e : graph.get(u)) {
                    int v = e.v;
                    int w = e.weight;

                    if (dist[u] != INF && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        bucket.get(dist[v]).add(v);
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == INF)
                System.out.println(i + " -> INF");
            else
                System.out.println(i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input vertices, edges, max weight
        int V = sc.nextInt();
        int E = sc.nextInt();
        int W = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Input edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Edge(v, w));
        }

        int src = sc.nextInt();

        dial(graph, V, src, W);

        sc.close();
    }
}