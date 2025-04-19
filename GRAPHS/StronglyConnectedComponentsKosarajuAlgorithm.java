import java.util.*;
public class StronglyConnectedComponentsKosarajuAlgorithm { // O(V+E) time complexity

    /*
     * Strongly Connected components (SCC) of a directed graph are the maximal subgraphs such that every vertex is reachable from every other vertex in the subgraph.
     * Kosaraju's algorithm is a linear time algorithm to find all strongly connected components in a directed graph.
     * 
     * Hint : Reverse DFS traversal gets us the strongly connected components.
     * 
     * Approach : Note : all 3 steps have time complexity of O(V+E) where V is the number of vertices and E is the number of edges.
     * 1. Get nodes in stack(Topological sort).
     * 2. Reverse the graph using transpose.
     * 3. Do DFS on the reversed graph using the nodes in the stack.
     * 4. Each time we do a DFS, we get a strongly connected component.
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
            graph[i] = new ArrayList();
        }

        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
    }
    public static void topSort(ArrayList<Edge>[] graph, boolean[] visited, Stack<Integer> stack, int current){
        visited[current] = true;

        for(int i = 0 ; i < graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(!visited[e.dest]){
                topSort(graph,visited,stack,e.dest);
            }
        }

        stack.push(current);
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int current){
        visited[current] = true;
        System.out.print(current + " ");

        for(int i = 0 ; i < graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(!visited[e.dest]){
                dfs(graph,visited,e.dest);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge>[] graph, int vertices){
        //step 1 : get nodes in stack
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        for(int i = 0; i < vertices; i++){
            if(!visited[i]){
                topSort(graph, visited, stack, i);
            }
        }

        //step 2 : reverse the graph using transpose

        ArrayList<Edge>[] transpose = new ArrayList[vertices];

        //creating the transpose graph
        for(int i = 0; i < graph.length ; i++){
            visited[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        //adding edges in reverse direction
        for(int i = 0 ; i < vertices; i++){
            for(int j = 0 ; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);   
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }

        //step 3 : dfs on transposed graph : 
        while(!stack.isEmpty()){
            int current = stack.pop();
            if(!visited[current]){
                System.out.print("SCC : ");
                dfs(transpose,visited,current);
                System.out.println(); // print the strongly connected component
            }
        }
    }
    public static void main(String[] args){
        int vertices = 4;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);

        kosaraju(graph, vertices);
    }
}
