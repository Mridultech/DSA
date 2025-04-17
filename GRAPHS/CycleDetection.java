import java.util.*;

public class CycleDetection {

    /*
     * Cycle Detection in Undirected Graph using DFS
     * -------------------------------------------------
     *  - Agar kisi visited node pe wapas pahuch jaayein via koi node jo parent nahi hai,
     *    toh cycle hai.
     *  - DFS ko har connected component ke liye chalayenge.
     */

    // Edge class representing an edge from src to dest
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Function to create the graph
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding undirected edges (so add both directions)
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        graph[1].add(new Edge(1, 3));
        graph[3].add(new Edge(3, 1));

        graph[2].add(new Edge(2, 4));
        graph[4].add(new Edge(4, 2));

        graph[3].add(new Edge(3, 5));
        graph[5].add(new Edge(5, 3));

        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));
    }

    // Main function to detect cycle in the graph
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];

        // DFS for every component
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, visited, i, -1)) {
                    return true; // cycle found
                }
            }
        }
        return false; // no cycle
    }

    // DFS utility to check for cycles
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, int current, int parent) {
        visited[current] = true;

        for (Edge e : graph[current]) {
            // Case 1: If neighbor not visited, do DFS
            if (!visited[e.dest]) {
                if (detectCycleUtil(graph, visited, e.dest, current)) {
                    return true;
                }
            }
            // Case 2: If visited and not parent => cycle exists
            else if (e.dest != parent) {
                return true;
            }
            // Case 3: If visited and is parent => no issue, continue
        }

        return false;
    }

    public static void main(String[] args) {
        int vertices = 6; // Increase to 6 because we use index 0 to 5
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        createGraph(graph); // build the graph

        // Check for cycle
        if (detectCycle(graph)) {
            System.out.println("Cycle is present in the graph.");
        } else {
            System.out.println("No cycle detected in the graph.");
        }
    }
}
