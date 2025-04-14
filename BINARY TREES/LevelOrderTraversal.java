import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal { // O(2n) = O(n) time complexity and O(n) space complexity

    /*
     * Level order traversal of a binary tree is a breadth-first traversal that visits all the nodes at the present depth level before moving on to the nodes at the next depth level.
     * hame isse queue ki madad se implement karenge based on FIFO principle.
     * 
     * approach : 
     * 1. Create a queue and add the root node to it.
     * 2. While the queue is not empty, do the following:
     *   a. Remove the front node from the queue and print its value.
     *  b. Add the left child of the removed node to the queue (if it exists).
     *  c. Add the right child of the removed node to the queue (if it exists).
     * 3. Repeat step 2 until the queue is empty.
     * 4. The order in which the nodes are printed is the level order traversal of the binary tree.
     * 
     * appropriate places pe ham null lagayenge jisse level ko track kar sake.
     */

     static class Node {
        int data;
        Node left;
        Node right;

        // constructor
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;

            // ✅ YAHI SAFETY CHECK ADDED HAI
            if (index >= nodes.length || nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void levelOrder(Node root){
         if(root == null){
            return;
         }

         Queue <Integer> q = new LinkedList<>();
         q.add(root);
         q.add(null);

         while(!q.isEmpty()){
            Node currentNode = q.remove();
            if(currentNode == null){ // checking if current node is null or what ?
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else{
                    q.add(null);
                }
            } else {
                System.out.print(currentNode.data + " ");
                if(currentNode.left != null){ // left child ko queue mein add krdiya 
                    q.add(currentNode.left);
                }
                if(currentNode.right != null){ // right child ko queue mein add krdiya 
                    q.add(currentNode.right);
                }
            }
         }
    }
    public static void main(String[] args){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        LevelOrderTraversal.levelOrder(root);
    }
}
