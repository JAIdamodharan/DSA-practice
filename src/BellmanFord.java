import java.util.ArrayList;
import java.util.*;

public class BellmanFord{

    static class Edge{
        int u,v,w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class Graph{
        int V;
        List<Edge> edges;

        Graph(int V){
            this.V = V;
            this.edges = new ArrayList<>();
        }

        void addEdge(int u, int v, int w){
            edges.add(new Edge(u,v,w));
        }

        int[] bellmanFord(int src){
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            for(int i=1; i<V; i++){
                boolean updated = false;
                for(Edge e : edges){
                    int u = e.u, v  = e.v, w = e.w;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                        dist[v] = dist[u] + w;
                        updated = true;
                    }
                }
                if (!updated) break;
            }
            //negative cycle check
            for(Edge e : edges){
                int u = e.u, v  = e.v, w = e.w;
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    System.out.println("Negative cycle detected!");
                    return null;
                }
            }
            return dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        Graph g = new Graph(V);
        System.out.print("Enter Edges (u v w): ");
        for(int i = 0; i < E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            g.addEdge(u,v,w);
        }

        System.out.print("Enter source: ");
        int src = sc.nextInt();

        int[] dist = g.bellmanFord(src);
        if(dist != null){
            for(int i=0; i< dist.length; i++){
                if(dist[i] == Integer.MAX_VALUE){
                    System.out.println(i + " -> INF");
                } else {
                    System.out.println(i + " -> " + dist[i]);
                }
            }
        }
    }

}