import java.util.*;
public class TopologicalSortBFS {

    /*
     * Fact : A dag has at least one vertex with indegree 0 and at least one vertex with outdegree 0.
     * Note : Topological sort is performed on dependency graphs.
     * 
     * approach : 
     * 1. normal array banao indegree kaa.
     * 2. normal bfs perform kro .
     * 3. jiski indegree 0 ho jaye usko queue mein daal do.
     * 3.a queue se pop kro or order mein print karado.
     * 4. current node ke neighbours ko update kro.
     * repeat till queue is empty and we get the topological order.
     */

     static class Edge{
        int src; // source node
        int dest; // destination node

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }


    public static void createGraph(ArrayList<Edge> graph[]){ 
        for(int i = 0 ; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // Adding edges to the graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 5));


    }

     public static void calculateIndegree(ArrayList<Edge> graph[], int indegree[]){
        for(int i = 0 ; i < graph.length; i++){
            int vertex = i;
            for(int j = 0 ; j < graph[vertex].size(); j++){
                Edge e = graph[vertex].get(j);
                indegree[e.dest]++;
            }
        }
     }
     public static void topSort(ArrayList<Edge> graph[]){
        int indegree[] = new int[graph.length];
        calculateIndegree(graph, indegree);
        // print indegree array
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int current = q.remove();
            System.out.print(current + " ");

            for(int i = 0 ; i < graph[current].size(); i++){
                Edge e = graph[current].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
     }
     
    
    public static void main(String[] args){
        int vertices = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);

        topSort(graph);

    }
}
 