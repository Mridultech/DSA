import java.util.*;
public class HeightOfTree { // time complexity : O(n)

    /*
     * Height of tree can be represented in two ways nodes and edges.
     * in terms of nodes : from root to deepest leaf node'
     * in terms of edges : 
     * Height of parent node is max of height of both right and left child nodes + 1.
     */

    static class Node {
        int data;
        Node left,right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height (Node root){
        if(root == null){ // agar ek bhi node na ho to
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        int height = Math.max(lh,rh) + 1;

        return height;
    }

    public static void main(String[] args){

        /*
         *              1
         *             / \
         *            2   3
         *           / \ / \
         *          4  5 6  7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print("Height of tree : " + height(root));
    }
}
