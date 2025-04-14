import java.util.*;

public class LowestCommonAncestor { // Time complexity : 3 * O(n) = O(n) , space complexity : O(n)

    /*
     * ✅ lowest common ancestor of a binary tree :
     *
     * 🔸 Approach :
     * 1. Dono given nodes ke liye ham root to node ke path nikal lenge.
     * 2. Dono path ko compare karenge aur jo last common node milega,
     *    wahi lowest common ancestor hoga.
     *
     * Example:
     *         1
     *       /   \
     *      2     3
     *     / \   / \
     *    4   5 6   7
     *
     * Agar hume LCA(4, 5) chahiye, toh:
     * path1: 1 → 2 → 4
     * path2: 1 → 2 → 5
     * Common: 1 → 2 → ❌ → LCA = 2
     */

    // Node class to represent a tree node
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 🔹 getPath() function:
     * Ye function ek particular node tak root se path nikalta hai.
     * Agar node mil gaya, toh true return karega, aur path mein nodes bhar dega.
     */
    public static boolean getPath(Node root, int n, ArrayList<Node> path) { // O(n)
        // base case: agar root null hai toh node mil hi nahi sakta
        if (root == null) {
            return false;
        }

        // current node ko path mein add kar liya
        path.add(root);

        // agar current node hi target hai, toh done
        if (root.data == n) {
            return true;
        }

        // left aur right subtree mein dhoondh rahe hain
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        // agar left ya right mein mil gaya toh true return karenge
        if (foundLeft || foundRight) {
            return true;
        }

        // agar kisi bhi subtree mein nahi mila, toh current node hata do path se
        path.remove(path.size() - 1);
        return false;
    }

    /**
     * 🔹 lca() function:
     * Ye function LCA nikalta hai by comparing root-to-node paths
     */
    public static Node lca(Node root, int n1, int n2) { // O(n)
        // Dono nodes ke liye path banaya
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1); // root se leke n1 tak ka path nikala
        getPath(root, n2, path2); // root se leke n2 tak ka path nikala

        // Common node dhoondhne ke liye loop chalayenge
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) { // O(n)
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // last common node hi hoga LCA
        return path1.get(i - 1);
    }

    public static void main(String[] args) {
        /*
         * Tree creation:
         *         1
         *       /   \
         *      2     3
         *     / \   / \
         *    4   5 6   7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 5;

        System.out.println("Lowest Common Ancestor of " + n1 + " and " + n2 + " is: " + lca(root, n1, n2).data);
    }
}
