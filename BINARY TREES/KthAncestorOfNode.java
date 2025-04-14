public class KthAncestorOfNode {

    /*
     * 🔥 Problem: Find kth ancestor of a given node in a binary tree
     * 👣 Step-by-step Approach:
     * 1. Node ka path trace karo root se target tak
     * 2. Har step pe distance track karo (distance = how far target is from current node)
     * 3. Jab distance == k ho jaye, tab us ancestor ka data store kar lo
     */

    // 🌍 Global variable to store answer when we find kth ancestor
    static int ans = -1;

    // 🔧 Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // 🧠 Recursive function to find kth ancestor
    public static int kAncestor(Node root , int n , int k){
        if(root == null){
            return -1; // 🌑 base case
        }

        if(root.data == n){
            return 0; // 🎯 target node mil gaya
        }

        // 🔁 Check left and right subtree
        int leftDistance = kAncestor(root.left, n, k);
        int rightDistance = kAncestor(root.right, n, k);

        // 😵 Node kahin bhi nahi mila
        if(leftDistance == -1  && rightDistance == -1){
            return -1;
        }

        // 🧮 max distance from current node to target node
        int max = Math.max(leftDistance,rightDistance);

        // 🎉 Check if this node is kth ancestor
        if(max + 1 == k){
            ans = root.data; // ✅ ancestor found — store in ans
        }

        return max + 1; // 🔄 keep returning distance upward
    }

    public static void main(String[] args){

        // 🌳 Build tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7); // ✅ corrected this node

        int n = 5 , k = 2;
        kAncestor(root, n, k); // 🧠 Just call it, answer will be stored in 'ans'

        if(ans == -1){
            System.out.println("kth ancestor not found");
        } else {
            System.out.println("kth ancestor of " + n + " is " + ans);
        } 
    }
}
