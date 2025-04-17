import java.util.*;

public class BipartiteGraph {

    /*
     * A bipartite graph is a graph whose vertices can be divided into two independent sets U and V such that every edge connects a vertex in U to one in V.
     * In other words, for every edge (u,v), either u belongs to U and v to V. We can also say that there is no edge that connects vertices of the same set.
     * 
     * Approach by colouring : 
     * case 1 : When neighbours of a vertex are not coloured, then colour them with the opposite colour of the vertex.
     * case 2 : When neighbours of a vertex are already coloured, then check if they are of same colour or not. If they are of same colour then the graph is not bipartite.
     * case 3 : When neighbours of a vertex are already coloured and are of different colours, then the graph is bipartite.
     * 
     * Note : For odd length cycles, graph is not bipartite.
     * For even length cycles, graph is bipartite.
     * 
     * 2. Acyclic graph is always bipartite.
     */

    static class Edge {
        int src; 
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding undirected edges (so add both directions)
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        graph[1].add(new Edge(1, 3));
        graph[3].add(new Edge(3, 1));

        graph[2].add(new Edge(2, 4));
        graph[4].add(new Edge(4, 2));

        graph[3].add(new Edge(3, 5));
        graph[5].add(new Edge(5, 3));

        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length];
        
        for(int i = 0; i < col.length; i++){
            col[i] = -1; // -1 means uncoloured
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < graph.length; i++){
            if(col[i] == -1){
                q.add(i);
                col[i] = 0;

                while(!q.isEmpty()){
                    int current = q.remove();

                    for(int j = 0 ; j < graph[current].size(); j++){
                        Edge e = graph[current].get(j);

                        if(col[e.dest] == -1){
                            // assign opposite colour
                            int nextCol = col[current] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;

                            // ❌ Bug fix: was q.add(null), should be e.dest
                            q.add(e.dest); 
                        }
                        else if(col[e.dest] == col[current]){
                            // Same colour on adjacent => Not bipartite
                            return false;
                        }                
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int vertices = 6;  // ✅ fix: graph uses 0 to 5 => total 6 vertices
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);

        System.out.println("Graph is bipartite : " + isBipartite(graph));
    }
}
