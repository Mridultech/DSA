import java.util.*;

public class BellmanFordAlgorithm {

    static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge> graphList) {
        graphList.add(new Edge(0, 1, 2));
        graphList.add(new Edge(0, 2, 4));
        graphList.add(new Edge(1, 2, -4));
        graphList.add(new Edge(2, 3, 2));
        graphList.add(new Edge(3, 4, 4));
        // graphList.add(new Edge(4, -1, -1)); // ❌ Invalid, remove
    }

    public static void bellmanFord(ArrayList<Edge> graph, int src, int vertices) {
        int distance[] = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            for (Edge edge : graph) {
                int u = edge.source;
                int v = edge.destination;
                int weight = edge.weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        // print result
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(distance[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge> graphList = new ArrayList<>();
        createGraph(graphList);
        bellmanFord(graphList, 0, vertices);
    }
}
// Time Complexity: O(V * E), where V is the number of vertices and E is the number of edges