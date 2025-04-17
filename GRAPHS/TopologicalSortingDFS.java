import java.util.*;

public class TopologicalSortingDFS {

    /*
     * Topological sorting can only be used for directed acyclic graphs (DAGs).
     * 
     * Topological sorting is a linear ordering of vertices such that for every directed edge u -> v,
     * vertex u comes before vertex v in the ordering.
     * 
     * Modified DFS is used: call DFS for each unvisited node, 
     * and once a node finishes its recursion, push it to a stack.
     * In the end, popping the stack gives the topological order.
     */

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding directed edges
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 5));
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length]; // Track visited nodes
        Stack<Integer> stack = new Stack<>(); // Stores topological order in reverse

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topSortUtil(graph, i, visited, stack);
            }
        }

        // Pop all elements from stack to get the topological ordering
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true; // Mark current node visited

        for (int i = 0; i < graph[v].size(); i++) {
            Edge e = graph[v].get(i); // Get all neighbors
            if (!visited[e.dest]) {
                topSortUtil(graph, e.dest, visited, stack); // Recur for unvisited neighbors
            }
        }

        stack.push(v); // Push to stack after all its neighbors are visited
    }

    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);
        System.out.println("Topological Sort of the given graph:");
        topSort(graph);
    }
}
