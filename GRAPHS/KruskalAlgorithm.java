import java.util.*;
public class KruskalAlgorithm { // Time Complexity : O( V + E log E) where E is the number of edges in the graph and V is number of vertices.

    /*
     * Kruskal's algorithm is a greedy algorithm that finds the minimum spanning tree (MST) for a connected weighted graph.
     * 
     * approach : 
     * 1. Sort all the edges in non-decreasing order of their weight.
     * 2. Pick the smallest edge. 
     * 3. Check if it forms a cycle with the spanning tree formed so far.
     * 4. If it doesn't form a cycle, include this edge in the MST.
     * 5. Repeat steps 2-4 until there are (V-1) edges in the MST.
     * 
     * Note : MST mein hamesha V-1 edges honge, jahan V number of vertices hain.
     */
    
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e2){
            return this.weight - e2.weight; // Sort edges in non-decreasing order of their weight
        }
    }

    static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(0, 3, 40));
        edges.add(new Edge(0, 3, 50));
    }

    static int n = 4;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i = 0 ; i < n; i++){
            parent[i] = i;
        }
    }

    public static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(rank[parentA] == rank[parentB]){
            parent[parentB] = parentA;
            rank[parentA]++;
    }
    else if (rank[parentA] < rank[parentB]){
        parent[parentA] = parentB;
    }
    else {
        parent[parentB] = parentA;
    }
    }

    public static void kruskalMST(ArrayList<Edge> edges, int vertices){
        init(); // Initialize parent and rank arrays
        // Sort edges based on weight
        Collections.sort(edges); // O(ElogE)
        int mstCost = 0;
        int count = 0;

        for(int i = 0; count < vertices - 1; i++){ // O(V)
            Edge e = edges.get(i);

            int parentA = find(e.src);
            int parentB = find(e.dest);

            if(parentA != parentB){
                union(e.src, e.dest);
                mstCost += e.weight;
                count++;
            }
        }

        System.out.println("Cost of MST is : " + mstCost);
    }
     public static void main(String[] args){
        int vertices = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);

        kruskalMST(edges, vertices);

    }
}