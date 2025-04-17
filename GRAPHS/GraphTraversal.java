import java.util.*;
public class GraphTraversal {

    /*
     * In graphs there are two ways for traversing the graph:
     * 
     * 1. Depth First Search (DFS) : It is a recursive algorithm that starts at the root node and explores as far as possible along each branch before backtracking.
     *  - isme keval ek source pakadna hai or ek single bari mein ek neighbour ko visit krte jana hai unhe chodke jo already visited hai . 
     * 
     * -> approach :
     *    1. Start from the root node and mark it as visited.
     *    2. Then visit the first neighbour and mark it as visited.
     *    3. Then visit the first neighbour of the first neighbour and mark it as visited.
     *    4. similarly till end sare nodes visit karne hai .
     * 
     * 
     * 2. Breadth First Search (BFS) : It is an iterative algorithm that starts at the root node and explores all its immediate neighbors at the present depth prior to moving on to nodes at the next depth level.
     *  - isme level vertical bante hai or isme hame pehle length mein search krna hai height ke bajai.
     *  - Implemented using Queues.
     *  -> approach : 
     *     - 1. Start from the root node and add it to the queue.
     *       2. Fir element ko remove karenge queue se or use visit tick krdenge and then uske immediate neighbours ko queue mein add karenge.
     *       3. Fir next ko visit krenge and then remove krenge fir use print karake check karenge uske neighbours ko.
     *       4. Agar uske neighbours visited honge to add nahi krayenge or agar visited false hoga to add kara denge . 
     * 
     * similarly next element ko pakadke same process repeat karenge.
     */

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

     public static void bfs(ArrayList<Edge>[] graph){ // time complexity : O(V + E)
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        q.add(0); // starting from the root node

        while(!q.isEmpty()){
            int current = q.poll(); // remove the element from the queue

            if(!visited[current]){ // check if it is visited or not
                System.out.print(current + " "); // print the current node
                visited[current] = true; // mark it as visited
                for(int i = 0 ; i < graph[current].size(); i++){
                    Edge e = graph[current].get(i); // get the edge
                        q.add(e.dest); // add the neighbour to the queue
                }
            }
        }
        System.out.println(); // print the current node after visiting all its neighbours
     }

     public static void dfs(ArrayList<Edge>[] graph, int current, boolean visited[]){
        //visit
        System.out.print(current + " ");
        visited[current] = true; // mark it as visited

        for(int i = 0 ; i < graph[current].size(); i++){
            Edge e = graph[current].get(i); // get the edge
            if(!visited[e.dest]){ // check if it is visited or not
                dfs(graph, e.dest, visited); // call the dfs function recursively
            }
        }
     }
    public static void main(String[] args){
        int vertices = 7;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        System.out.println("BFS Traversal: ");
        bfs(graph); // calling bfs function to traverse the graph
        boolean[] visited = new boolean[graph.length]; // initialize visited array
        System.out.println("DFS Traversal: ");
        dfs(graph, 0, new boolean[vertices]); // calling dfs function with starting node and visited array

    }
}