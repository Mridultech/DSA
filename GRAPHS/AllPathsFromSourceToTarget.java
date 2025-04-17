import java.util.*;

public class AllPathsFromSourceToTarget { // time complexity : O(v^v) where v is the number of vertices in the graph.

    /*
     * For directed graph : https://leetcode.com/problems/all-paths-from-source-to-target/description/
     * We'll solve it using dfs.
     */

    static class Edge {
        int src;
        int dest;

        // ✅ Bug fix: Constructor ka parameter galat tha — weight ka koi use nahi ho raha
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // ✅ Graph ko initialize aur edges add kar rahe hain
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Directed edges — har edge ek direction mein ja rahi hai
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 5));
    }

    // ✅ Ye method sari possible paths print karega from src to dest
    public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
        // Base case: agar src == dest, to path complete ho gaya
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        // ✅ DFS traversal: har connected node ke liye call lagayenge
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // Next recursive call with updated path
            printAllPath(graph, e.dest, dest, path + src + "->");
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertices]; // Graph ka array banaya
        createGraph(graph); // Graph ko banaya

        int src = 0, dest = 5; // ✅ src = 0 se start hona chahiye, warna koi path hi nahi milega
        System.out.println("All Paths from " + src + " to " + dest + " are:");
        printAllPath(graph, src, dest, "");
    }
}
