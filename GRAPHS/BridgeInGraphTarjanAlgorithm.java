import java.util.*;

public class BridgeInGraphTarjanAlgorithm {

    /*
     * Bridge is an edge whose deletion increases the number of connected components in the graph.
     * We will use Tarjan's Algorithm to find bridges.
     * 
     * Core Concepts:
     * - discoveryTime[u] = When a node u is first visited
     * - low[u] = The earliest visited vertex (minimum discovery time) reachable from u
     * 
     * If for an edge (u, v), we find that low[v] > discovery[u], then it's a bridge.
     */

    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Function to create the graph
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
    }

    public static void dfs(ArrayList<Edge>[] graph, int current, int parent, int[] discoveryTime, int[] low,
                           boolean[] visited, int[] time) {
        visited[current] = true;
        discoveryTime[current] = low[current] = ++time[0];

        for (Edge e : graph[current]) {
            int neighbour = e.dest;

            if (neighbour == parent) {
                continue;
            }

            if (!visited[neighbour]) {
                dfs(graph, neighbour, current, discoveryTime, low, visited, time);

                // After return, update low time
                low[current] = Math.min(low[current], low[neighbour]);

                // Check for bridge
                if (low[neighbour] > discoveryTime[current]) {
                    System.out.println("Bridge : " + current + " ------- " + neighbour);
                }
            } else {
                // back edge
                low[current] = Math.min(low[current], discoveryTime[neighbour]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge>[] graph, int vertices) {
        int[] discoveryTime = new int[vertices];
        int[] low = new int[vertices];
        boolean[] visited = new boolean[vertices];
        int[] time = new int[1]; // time as reference wrapper

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(graph, i, -1, discoveryTime, low, visited, time);
            }
        }
    }

    public static void main(String[] args) {
/* 
        0 --- 1
         \   /
           2
           |
           3
           |
           4
*/

        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        createGraph(graph);
        tarjanBridge(graph, vertices);
    }
}
