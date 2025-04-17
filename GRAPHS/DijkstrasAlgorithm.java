import java.util.*;
public class DijkstrasAlgorithm { // Time complexity on solving by priority queue : V + ELogV , where ye elogv is for internal sorting within priority queue, and for external loop is V.

    /*
     * Shortest paths from source to all vertices (in weighted graph) , let source be 0
     * yeh ek form of greedy algorithm hai kyuki isme for globally optimized solution ham ek local greedy choice le rhe hai on every step.
     * 
     * Approach : 
     * 1. pehle ham sare nodes ko except source node ko infinity assign karte hai.
     * if(distance [u] + weight[u][v] < distance[v]){
     *   distance[v] = distance[u] + weight[u][v];
     * }
     * after updation ham dekhenge shortest konsa hai .
     * jo shortest hoga uske bhi shortest neighbours ko update karenge.
     * 
     * shortcoming of dijkstra : 
     * can't provide correct results for graph with negative weights for this we'll use bellman ford algorithm.
     * 
     */
    
     static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Directed edges only — ❌ Don't add reverse edges
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 5, 3));
        graph[4].add(new Edge(4, 5, 6));
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int path;

        public Pair(int node, int path){
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path; // path based sorting for pairs.
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src){
        int distance[] = new int[graph.length];
        for(int i = 0 ; i < graph.length; i++){
            if(i != src){
                distance[i] = Integer.MAX_VALUE;
            }
        }

        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair current = pq.remove();
            if(!visited[current.node]){
                visited[current.node] = true;
                //neighbours
                for(int i = 0 ; i < graph[current.node].size(); i++){
                    Edge e = graph[current.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if(distance[u] + wt < distance[v]){
                        distance[v] = distance[u] + wt;
                        pq.add(new Pair(v,distance[v]));
                    }
                }
            }

        }

        for(int i = 0 ; i < distance.length; i++){
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args){
            int vertices = 6;
            ArrayList<Edge>[] graph = new ArrayList[vertices];
            createGraph(graph);
            dijkstra(graph, 0);
        
        
    }
}