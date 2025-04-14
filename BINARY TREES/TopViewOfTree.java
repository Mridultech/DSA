import java.util.*;
public class TopViewOfTree {

    /*
     * Given a binary tree, print the top view of it. The top view is the set of nodes visible when the tree is viewed from the top.
     *                      
     * ex : 
     * tree :       1
     *             /   \
     *           2     3
     *         / \   / \
     *       4   5  6   7
     *  here the top view is 4,2,1,3,7 and 5,6 are not visible from the top as they are hidden by 4,2 and 3 respectively.
     * 
     * brief intro of hashmap :
     * A HashMap is a data structure that stores key-value pairs. It allows for fast retrieval of values based on their keys.
     * The keys in a HashMap are unique, meaning that each key can only be associated with one value. If you try to add a new value for an existing key, the old value will be replaced.
     * map(key, value) , *key = unique value but value can be duplicate.
     * 
     * Syntax to create a HashMap:
     * import java.util.HashMap;
     * HashMap<Keyvalue return Type, Value return Type> mapName = new HashMap<>();
     * 
     * hashmaps are very optimized and have O(1) time complexity for insertion, deletion and searching.
     * 
     * how to add key-value pair in hashmap:
     * mapname.put(key, value);
     * 
     * how to get value from hashmap:
     * 
     * mapname.get(key); // returns value associated with the key
     * 
     * how to check if a key exists in hashmap:
     * mapname.containsKey(key); // returns true if key exists, false otherwise
     * 
     * how to remove a key-value pair from hashmap:
     * mapname.remove(key); // removes the key and its associated value
     * 
     * horizontal distance in tree:
     * The horizontal distance of a node is the distance of the node from the root node in the horizontal direction.
     * The root node has a horizontal distance of 0. The left child of a node has a horizontal distance of the parent node - 1, and the right child has a horizontal distance of the parent node + 1.
     * kisi bhi root node ke liye left child ka horizontal distance = parent node ka horizontal distance - 1
     * right child ka horizontal distance = parent node ka horizontal distance + 1
     * by default, the root node has a horizontal distance of 0.
     * 
     * approach : 
     * 1. level order traversal se tree ke upar traverse krenge . 
     * 2. hashmap mein wo key value store krayenge jo pehle nahi ayi hogi .
     * 3. jab bhi koi node aaye uska horizontal distance check krenge agar wo hashmap mein nahi hai to usko add kar denge.
     * 4. jab bhi koi node aaye uska horizontal distance check krenge agar wo hashmap mein hai to usko ignore kar denge.
     * 5. jab tak tree ke saare nodes nahi aa jate tab tak level order traversal karte rahenge.
     * 6. jab saare nodes aa jaye to hashmap mein jo bhi key value pair hai usko print kar denge.
     * Note : hame ek min and max horizontal distance bhi rakhna padega taaki hame pata chale ki hame hashmap mein kaunse key value pair print karne hain.
     * ham min to max range mein iterate karenge aur hashmap se key value pair print kar denge.
     */

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    static class Info{
        Node node;
        int horizontalDistance;

        public Info(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }
    public static void topView(Node root){
        //Level Order
        Queue<Info> q = new LinkedList<>(); // is queue ko hamne Info type ka isiliye bnaaya kyuki isme ham node ki information store krenge
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0 , max = 0;


        q.add(new Info(root,0)); // root ko add karte hain queue mein aur uska horizontal distance 0 hai.
        q.add(null); // ye track krta hai ki tree kaha pe khatam hua hai.


        while(!q.isEmpty()){
            Info current = q.remove();
            if(current == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null); // jab tak queue khali nahi hoti tab tak null ko add karte rahenge.
                    continue; // agar current null hai to next iteration mein chale jao.
                }
            } else {
                if(!map.containsKey(current.horizontalDistance)){ // first time my horizontal distance occuring
                    map.put(current.horizontalDistance, current.node); // add to map    
                }
    
                if(current.node.left != null){ // agar left child hai to usko queue mein add karte hain aur horizontal distance -1 karte hain.
                    q.add(new Info(current.node.left, current.horizontalDistance - 1)); // left child ka horizontal distance parent node ka horizontal distance - 1 hota hai.
                    min = Math.min(min, current.horizontalDistance - 1); // min horizontal distance ko update karte hain.
                }
                
                if(current.node.right != null){ // agar right child hai to usko queue mein add karte hain aur horizontal distance +1 karte hain.
                    q.add(new Info(current.node.right, current.horizontalDistance + 1)); // right child ka horizontal distance parent node ka horizontal distance + 1 hota hai.
                    max = Math.max(max, current.horizontalDistance + 1);
                }
            }
            }

            // jab saare nodes aa jaye to hashmap mein jo bhi key value pair hai usko print kar denge.
            for(int i = min ; i <=max; i++){
                System.out.print(map.get(i).data + " "); // hashmap se key value pair print karte hain.
            }
            System.out.println();
            
        }

        
    
public static void main(String[] args){
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.right.left = new Node(5);
    root.right.right = new Node(6);
    root.left.right = new Node(7);
    
    topView(root); // 4 2 1 3 6
}

}