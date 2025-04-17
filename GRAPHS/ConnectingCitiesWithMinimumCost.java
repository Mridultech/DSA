import java.util.*;
public class ConnectingCitiesWithMinimumCost {

    /*
     * Problem statement : Find minimum cost for connecting all cities on map.
     * is swal mein simply hame bas given graph ke liye MST nikalna hai.
     */

    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e2){
            return this.cost - e2.cost; // ascending order
        }
    }

    public static int connectCities(int cities[][]){ // Time complexity : Same as that of prims algorithm O(ElogV)
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[cities.length];

        pq.add(new Edge(0,0));
        int finalCost = 0;

        while(!pq.isEmpty()){
            Edge current = pq.remove();
            if(!visited[current.dest]){
                visited[current.dest] = true;
                finalCost += current.cost;

                for(int i = 0 ; i < cities[current.dest].length; i++){
                    if(cities[current.dest][i] != 0){
                        pq.add(new Edge(i, cities[current.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }
    public static void main(String[] args){
        int cities[][] = {
                {0, 1, 2, 3, 4},
                {1, 0, 5, 0, 7},
                {2, 5, 0, 6, 0},
                {3, 0, 6, 0, 0},
                {4, 7, 0, 0, 0}
            };
               
        System.out.print("Minimum cost to connect all cities is : " + connectCities(cities));
                
        
    }
}