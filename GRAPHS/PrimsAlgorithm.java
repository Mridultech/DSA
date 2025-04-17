import java.util.*;

public class PrimsAlgorithm {

    /*
     * Prim's Algorithm is a greedy algorithm that finds the minimum spanning tree (MST) for a weighted undirected graph.
     * 
     * Approach to create mst using Prim's Algorithm:
     * 1. pehle do set bnayenge mst set and non-mst set. 
     * 2. mst set me starting node ko daalenge.
     * 3. mst se non-mst wale har edge ki cost nilkalo and then minimum cost ko dekho.
     * 4. at end src and dest ko visited set me true karke daal do. 
     * 
     * Note : ek cost variable track krna hai jisme cost add krate rhenge.
     */

    static class Edge{
        int src;
        int dest;
        int cost;

        public Edge(int src, int dest, int cost){
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    static class Pair implements Comparable<Pair>{
        Integer vertex;
        int cost;

        public Pair(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    @Override
    public int compareTo(Pair o){
        return this.cost - o.cost; //ascending order
    }
}    
    public static void prims(ArrayList<Edge> graph[], ArrayList<Integer> edge){
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0)); // starting node with cost 0
        int finalCost = 0; // total cost of mst

        while(!pq.isEmpty()){
            Pair current = pq.remove(); // remove the minimum cost edge
            if(!visited[current.vertex]){
                visited[current.vertex] = true; // mark the vertex as visited
                finalCost += current.cost; // add the cost to the final cost
                edge.add(current.vertex);

                //for adding neighbours of current vertex to the priority queue
                for(int i=0; i<graph[current.vertex].size(); i++){
                    Edge e = graph[current.vertex].get(i); // get the edge
                    if(!visited[e.dest]){ // if the destination is not visited
                        pq.add(new Pair(e.dest, e.cost)); // add it to the priority queue
                    } 
                }
            }
        }

        System.out.println("Final cost of MST IS : " + finalCost);
    }
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding directed edges
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 4));
        graph[2].add(new Edge(2, 4, 5));
        graph[3].add(new Edge(3, 5, 6));
        graph[4].add(new Edge(4, 5, 7));
    }
    public static void main(String[] args){
        int vertices = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);
        System.out.println("Minimum cost of MST is : ");

        ArrayList<Integer> edge = new ArrayList<>();

        prims(graph,edge);

        //printing vertices from arraylist 

        for(int i = 0 ; i < edge.size(); i++){
            System.out.println(edge.get(i));
        }
    }
}
