import java.util.*;
// Java ka util package import kara, kyunki hum isme kuch utility classes use karenge agar zarurat padi toh

public class SizeOfLargestBSTInBT {
    
    // Ek custom class banayi jiska naam hai Info
    // Ye class har node ke liye kuch zaroori info store karegi:
    static class Info {
        boolean isBST; // ye batata hai ki current subtree BST hai ya nahi
        int size;      // is subtree ka size (nodes ki total count)
        int min;       // is subtree mein sabse chhoti value
        int max;       // is subtree mein sabse badi value

        // Constructor to initialize values
        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    // Basic Node class banayi Binary Tree ke liye
    public static class Node {
        int data; // Node ka actual data/value
        Node left, right; // Left aur Right child

        // Constructor for Node
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Global variable to track max BST size
    public static int maxBST = 0;

    // Core logic yahaan hai - ye function har node ke liye info process karta hai
    public static Info largestBST(Node root) {
        // Base case: agar node null hai toh woh BST hai (by default) aur size 0
        if(root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Recursive call left and right subtree ke liye
        Info leftInfo = largestBST(root.left);   // left subtree ka info laaya
        Info rightInfo = largestBST(root.right); // right subtree ka info laaya

        // Apne current subtree ka size nikaala
        int size = leftInfo.size + rightInfo.size + 1;

        // Minimum value current subtree ke liye
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        // Maximum value current subtree ke liye
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // Condition to check if current subtree BST nahi ban raha
        if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
            // Agar left ke max se chhota nahi ya right ke min se bada nahi toh BST nahi
            return new Info(false, size, min, max); // isBST = false
        }

        // Agar left aur right dono BST hain tabhi current subtree bhi BST ho sakta hai
        if(leftInfo.isBST && rightInfo.isBST) {
            // maxBST update kar do agar yeh wala size ab tak ka max hai
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max); // isBST = true
        }

        // Agar upar waali condition fail hui toh BST nahi ban paya
        return new Info(false, size, min, max); // isBST = false
    }

    // Main method jahan pe tree banate hain aur function call karte hain
    public static void main(String[] args) {

        // Tree bana rahe hain manually jaise question mein diya hota hai
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20); // left subtree is NOT a BST

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80); // right subtree is a valid BST

        // largestBST function call kar rahe hain
        Info info = largestBST(root);

        // Final output print kar rahe hain
        System.out.println("largest BST size = " + maxBST); // Expected: 5 (right subtree)
    }
}
