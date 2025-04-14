import java.util.*;
public class DiameterOfTree { // time complexity : O(n) because har node pe traverse karne ke sath uski height bhi calculate kr rhe hai or har baar height calculate krne ke liye hame O(n) time lagta hai

    /*
     * less optimized approach.
     * Diameter of tree : Number of nodes in longest path between two leaves having longest path betwwen them
     * 
     * case 1 : jab path root node se jaa rha hai
     * diameter = height of left subtree + height of right subtree + 1
     * case 2 : jab path tree ke subtree mein exist krti hai or root se nahi jati
     * tree mein ham left subtree ki diameter nikalenge , right subtree ki diameter nikalenge and diamter passing through root (i.e case 1) nikalalenge jo value sabse badi aayegi wo hi pure tree ki diamter hogi
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

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }

        int leftDiameter = diameter(root.left);
        int leftheight = height(root.left);
        int rightDiameter = diameter((root.right));
        int rightheight = height(root.right);

        int selfDiameter = leftheight + rightheight + 1;

        return Math.max(selfDiameter,Math.max(leftDiameter,rightDiameter));

    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print("Diameter of tree : " + diameter(root));
    }
}
