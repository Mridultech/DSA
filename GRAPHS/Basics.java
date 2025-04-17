import java.util.*;
public class Basics {

    /*
     * Graphs ke Notes
     * 
     * 1. Graph kya hai?
     *    - Graph ek collection hai vertices (nodes) aur edges (connections) ka.
     *    - Types of Graphs:
     *      a. Directed Graph: Jahan edges ka direction hota hai.
     *      b. Undirected Graph: Jahan edges ka direction nahi hota.
     *      c. Weighted Graph: Jahan edges par weights hote hain.
     *      d. Unweighted Graph: Jahan edges par koi weights nahi hote.
     * 
     * 2. Graph ka Representation:
     *    - Adjacency Matrix: 2D array jisme rows aur columns vertices ko represent karte hain.
     *    - Adjacency List: Har vertex ke liye ek list hoti hai jo uske adjacent vertices ko store karti hai.
     *    - Edge List: Har edge ke liye ek list hoti hai jo uske adjacent vertices ko store karti hai.
     *    - Implicit Graph: Jahan graph ke vertices aur edges explicit roop se nahi define hote.
     * 
     * 3. Basic Terminology:
     *    - Vertex: Graph ka ek point.
     *    - Edge: Do vertices ke beech ka connection.
     *    - Degree: Ek vertex ke adjacent edges ki sankhya.
     *    - Path: Vertices ka sequence jo edges se connected hote hain.
     *    - Cycle: Path jisme starting aur ending vertex same hota hai.
     * 
     * 4. Common Algorithms:
     *    - BFS (Breadth-First Search): Graph ko level-wise traverse karta hai.
     *    - DFS (Depth-First Search): Graph ko depth-wise traverse karta hai.
     *    - Dijkstra's Algorithm: Shortest path find karne ke liye use hota hai.
     * 
     * Example graph : 
     * 
     *                                  0    2
     *                                   \  /  \
     *                                     1 -- 3             
     * Diagrams: For above given graphs 
     * 
     *    - Adjacency Matrix ka example: yeh thoda space jada consume krta hai plus unoptimized for searching.
     * 
     *       0  1  2  3
     *   0  [0, 1, 0, 0]
     *   1  [1, 0, 1, 1]
     *   2  [0, 1, 0, 1]
     *   3  [0, 1, 1, 0]
     * 
     *    - Adjacency List ka example: yeh most optimized way hai representation ka kyuki isme time complexity : O(V)
     *      0 -> 1
     *      1 -> 0, 2, 3
     *      2 -> 1, 3
     *      3 -> 1, 2
     * 
     *    - Edge List ka example:
     * 
     *      Edge List : {{0,1},{1,2},{2,3},{3,1}}
     *      Generally edge list ka use kam hota hai lekin sorting wale questions mein use hota hai .
     * 
     *    -Implicit Graph : 
     *      In questions mein koi batayega nahi ki graph ka sawaal hai practice se intution strong hogi.
     *      Ek visualization of graph leke solve krne honge.
     * 
     *    5. Application of graphs :
     *  
     *    1. MAPS(Shortest Path) 
     *    2. Social Networks  
     *    3. Delivery Network(Shortest cyclic route)
     *    4. visualizations of physics and chemistry (chemical bonds).
     *    5. Routing Algorithms (internet routing).
     *    6. Machine Learning(Computational Graphs).
     *    7. Dependency Graphs (task scheduling).
     *    8. Computer Vision (image segmentation).
     *    9. Game Development (pathfinding).
     *    10. Graph Databases : neo4j, ArangoDB, Amazon Neptune, nebula graph, etc.
     *    11. Research purposes (graph theory).
     *    12. Flood Fill Algorithm (image processing).
     * 
     * 
     * 
     */

    static class Edge {

        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args){

        //created graph using adjacency List : 
        
        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices]; // empty arraylist 

        for(int i = 0 ; i < vertices ; i++){
            graph[i] = new ArrayList<>(); // arraylist of edges
        }   

        // Adding edges to the graph
        //0th vertex
        graph[0].add(new Edge(0, 1, 5)); // 0 -> 1 with weight 5
        
        //1th vertex
        graph[1].add(new Edge(1, 0, 5)); // 1 -> 0 with weight 5
        graph[1].add(new Edge(1, 2, 1)); // 1 -> 2 with weight 1
        graph[1].add(new Edge(1, 3, 3)); // 1 -> 3 with weight 3

        //2th vertex
        graph[2].add(new Edge(2, 1, 1)); // 2 -> 1 with weight 1
        graph[2].add(new Edge(2, 3, 1)); // 2 -> 3 with weight 1
        graph[2].add(new Edge(2, 4, 4)); // 2 -> 4 with weight 4

        //3th vertex
        graph[3].add(new Edge(3, 1, 3)); // 3 -> 1 with weight 3
        graph[3].add(new Edge(3, 2, 1)); // 3 -> 2 with weight 1

        //4th vertex
        graph[4].add(new Edge(4, 2, 2)); // 4 -> 2 with weight 2

        // Finding 2's neighbours : 

        for(int i = 0 ; i <graph[2].size() ; i++){
            Edge e = graph[2].get(i); // get the edge at index i
            System.out.println("Vertex 2 is connected to vertex " + e.dest + " with weight " + e.weight);
        }
    }
}
