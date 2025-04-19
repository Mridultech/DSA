import java.util.*;
import java.util.LinkedList;
public class CycleDetectionBFS {
    
    /*
     * Here is a simple implementation of cycle detection in an undirected graph using BFS.
     * 
     * Agar kisi visited node pe wapas pahuch jaayein via koi node jo parent nahi hai,
     *    toh cycle hai.
     * BFS ko har connected component ke liye chalayenge.
     */

    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0 ; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        //creating edges for vertex 1: 
        graph[0].add(new Edge(1,2));
        //creating edges for vertex 2:
        graph[1].add(new Edge(2, 3)); 
        graph[1].add(new Edge(2, 4));
        //creating edges for vertex 3:
        graph[2].add(new Edge(3, 2));
        graph[2].add(new Edge(3, 4));
        //creating edges for vertex 4:
        graph[3].add(new Edge(4, 2));
        graph[3].add(new Edge(4, 3));
        
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0 ; i < graph.length; i++){
            if(!visited[i]){
                if(detectCycleUtil(graph, i, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int current, boolean[] visited, int parent){
        Queue<Integer> q = new LinkedList<>();
        q.add(current);

        //case 1 : if neighbours was not visited :
        for(int i = 0 ; i < graph[current].size(); i++){
            current = q.poll();
            Edge e = graph[current].get(i);
            if(!visited[i]){
                if(detectCycleUtil(graph,e.dest,visited,current)){
                    return true;
                }
            }

        //case 2 : if neighbour is visited but not parent => cycle confirms

        else if(e.dest != parent){
            return true;
        }

        //case 3 : if neighbousr is visited and parent too => continue
        }

        return false;
    }

    public static void main(String[] args){
    int vertices = 5;
    @SuppressWarnings("unchecked")
    ArrayList<Edge>[] graph = new ArrayList[vertices];
    createGraph(graph);
    System.out.println(detectCycle(graph) ? "Cycle is present in the graph." : "Cycle is not present in the graph.");

        

    }
}
