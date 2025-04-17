import java.util.ArrayList;

public class HasPath {

    public static boolean hasPath(ArrayList<Edge>[] graph , int src , int dest, boolean[] vis){ // time complexity : O(V + E)
        if(src == dest){
             return true;
            }
        for(int i = 0 ; i < graph[src].size() ; i++){
            Edge e = graph[src].get(i);
            vis[src] = true; // Mark the current node as visited
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }


    static class Edge{
        int src; // source node
        int dest; // destination node
        int weight; // weight of the edge

        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }


    public static void createGraph(ArrayList<Edge> graph[]){ 
        for(int i = 0 ; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // Adding edges to the graph
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 6, 1));
    }
    public static void main(String[] args){
        int vertices = 7;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        System.out.println("Has path ? : " + hasPath(graph, 0, 6, new boolean[vertices]));
        System.out.println("Has path ? : " + hasPath(graph, 0, 5, new boolean[vertices]));
        System.out.println("Has path ? : " + hasPath(graph, 0, 7, new boolean[vertices]));
    }
}