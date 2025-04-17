import java.util.*;
public class ConnectedComponents {

    /*
     * 
     * Connected Components in a Graph
     * Connected components are subgraphs in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.
     * 
     * Approach : 
     * graph mein kayi connected components ho sakte hain.
     * to sabko normally jaise hamne bfs ya dfs kiya hai, waise hi karenge to sare nodes traverse nahi ho payenge.
     * 
     * to hame isme do alag methods banane pdenge ek to dfs ya bfs ka jo ki ek connected component ko traverse karega.
     * dusra hoga helper method of dfs ya bfs.
     * 
     */

     static class Edge{
        int src;
        int dest;
        int weight;

        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
     }

     public static void bfs(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                bfsUtil(graph, i, visited);
            }
        }
     }

     public static void bfsUtil(ArrayList<Edge>[] graph, int src, boolean[] visited){ // by default convenction hai helper methods ke liye naam ke age util lagadete hai compulsory nahi hai lekin ye ek convention hai.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()){
            int current = queue.poll();
            visited[current] = true;
            System.out.print(current + " ");

            for(int i = 0 ; i < graph[current].size() ; i++){
                Edge e = graph[current].get(i);
                queue.add(e.dest);
            }
        }
     }

     public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i = 0 ; i < graph.length; i++){
            dfsUtil(graph, i, vis);
        }
     }

     public static void dfsUtil(ArrayList<Edge>[] graph , int curr, boolean vis[]){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i = 0 ; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }
        }
     }

    public static void main(String[] args){

    }
}