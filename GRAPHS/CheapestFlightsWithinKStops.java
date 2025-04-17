import java.util.*;
import java.util.LinkedList;

public class CheapestFlightsWithinKStops {

    /*
     * Hint : Jo problems maps se related hote hain, unmein zyadatar graphs use hote hain.
     * Yeh bhi ek graph problem hai — jisme har flight ek directed weighted edge hoti hai.
     */

    // Edge class to represent flights
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int dest , int wt){
            this.src = s;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Graph creation function from flight data
    public static void createGraph(int flights[][], ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>(); // Har node ke liye adjacency list initialize kar rahe hain
        }

        for(int j = 0 ; j < flights.length; j++){
            int src = flights[j][0];
            int dest = flights[j][1];
            int wt = flights[j][2];

            Edge e = new Edge(src,dest,wt); // Flight ko edge ke form me bana rahe hain
            graph[src].add(e); // Source node ke list me add kar rahe hain
        }
    }

    // Info class to track state in BFS
    static class Info {
        int vertex;  // current node
        int cost;    // cost to reach this node
        int stops;   // kitne stops ke baad yahan pahunche

        public Info(int vertex, int cost, int stops){
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
    }

    // Main logic to find cheapest flight within k stops
    public static int cheapestFlight(int n , int flights[][], int src, int dest, int k){
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph); // graph build karte hain

        int dist[] = new int[n]; // shortest cost to reach each node
        for(int i = 0; i < n; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE; // initially sabka distance infinity hai except source
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0)); // BFS ke liye initial state add kar di

        while(!q.isEmpty()){
            Info curr = q.remove();

            if(curr.stops > k){
                continue; // agar allowed stops se zyada ho gaya, toh skip karte hain
            }

            // Current node ke sare neighbors check karte hain
            for(int i = 0 ; i < graph[curr.vertex].size(); i++){
                Edge e = graph[curr.vertex].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // Agar current path se naye cost pe jaana cheaper hai
                // NOTE: yahan pe dist[u] ki jagah curr.cost lena chahiye for accuracy
                if(dist[v] > curr.cost + wt && curr.stops <= k){
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops+1)); // next level me add karte hain
                }
            }
        }

        // Agar destination tak pahuchna possible hi nahi tha
        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dist[dest];
        } 
    }

    // Driver method
    public static void main(String[] args){
        System.out.println("Cheapest Flights Within K Stops program is running.");

        int n = 4;
        int flights[][] = {
                {0, 1, 100},
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };

        int src = 0, dist = 3, k = 1;

        int result = cheapestFlight(n, flights, src, dist, k);
        System.out.println("Cheapest flight cost = " + result);
    }
}
