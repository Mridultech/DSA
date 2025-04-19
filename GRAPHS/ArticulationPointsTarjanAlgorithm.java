import java.util.*;

public class ArticulationPointsTarjanAlgorithm {

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Yeh DFS function articulation points find karega
    public static void dfs(ArrayList<Edge> graph[], int current, int parent, int dt[], int low[], int time[], boolean visited[], boolean ap[]) {
        visited[current] = true;
        dt[current] = low[current] = time[0]++;
        int children = 0;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            int neighbour = edge.destination;

            if (neighbour == parent) {
                continue;
            }

            if (!visited[neighbour]) {
                children++; // DFS call ke pehle count karo
                dfs(graph, neighbour, current, dt, low, time, visited, ap);

                // Backtracking ke baad low update karo
                low[current] = Math.min(low[current], low[neighbour]);

                // Articulation point check karo
                if (parent != -1 && low[neighbour] >= dt[current]) {
                    ap[current] = true;
                }

            } else {
                // Back edge mila
                low[current] = Math.min(low[current], dt[neighbour]);
            }
        }

        // Agar root node hai aur uske 2+ children hain
        if (parent == -1 && children > 1) {
            ap[current] = true;
        }
    }

    // Graph banane ka function
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Edges add karo
        graph[0].add(new Edge(1, 1));
        graph[0].add(new Edge(2, 1));
        graph[1].add(new Edge(0, 1));
        graph[1].add(new Edge(2, 1));
        graph[1].add(new Edge(3, 1));
        graph[2].add(new Edge(0, 1));
        graph[2].add(new Edge(1, 1));
        graph[2].add(new Edge(3, 1));
        graph[3].add(new Edge(1, 1));
        graph[3].add(new Edge(2, 1));
        graph[3].add(new Edge(4, 1));
        graph[4].add(new Edge(3, 1));
        graph[4].add(new Edge(2, 1));
        graph[4].add(new Edge(1, 1));
        graph[4].add(new Edge(0, 1));
        graph[4].add(new Edge(5, 1));
    }

    // Tarjan algo lagakar articulation points dhoondhne wala function
    public static void getArticulationPoints(ArrayList<Edge> graph[], int vertices) {
        int discoveryTime[] = new int[vertices];
        int low[] = new int[vertices];
        int time[] = {0}; // time as array to make it mutable in recursion
        boolean visited[] = new boolean[vertices];
        boolean isArticulationPoint[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(graph, i, -1, discoveryTime, low, time, visited, isArticulationPoint);
            }
        }

        System.out.println("Articulation Points:");
        for (int i = 0; i < vertices; i++) {
            if (isArticulationPoint[i]) {
                System.out.println("Node " + i + " is an articulation point.");
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        getArticulationPoints(graph, vertices);
    }
}
