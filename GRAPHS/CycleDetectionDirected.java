import java.util.ArrayList;

public class CycleDetectionDirected {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Function to create the graph
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Directed edges only — ❌ Don't add reverse edges
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 5));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        boolean recStack[] = new boolean[graph.length];

        for(int i = 0 ; i < graph.length; i++){
            if(!visited[i]){
                if(isCycleUtil(graph,i,visited,recStack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int current, boolean visited[], boolean stack[]){
        visited[current] = true;
        stack[current] = true; // node entered in recursion stack

        for(int i = 0 ; i < graph[current].size(); i++){
            Edge e = graph[current].get(i);

            // ❗ If the destination is in stack, means a back-edge => cycle
            if(stack[e.dest]) {
                return true;
            }

            // ❗ Recur only if not visited
            if(!visited[e.dest] && isCycleUtil(graph, e.dest, visited, stack)){
                return true;
            }
        }

        stack[current] = false; // ❗ Backtrack
        return false;
    }

    public static void main(String[] args){
        int vertices = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);
        System.out.println("Cycle exists: " + isCycle(graph));
    }
}
