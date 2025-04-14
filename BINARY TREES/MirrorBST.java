import java.util.*;  // 🔁 Java ka util package import kiya for any utilities (though not used directly here)

public class MirrorBST {

    // 🔧 Node class banayi – yahi basic block hai har tree ke node ka
    static class Node {
        int data; // 🧠 Node ka actual data
        Node left; // 👈 Left child
        Node right; // 👉 Right child

        // 👷 Constructor – jab bhi new node banega, data set hoga and left/right null honge
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 🔁 Recursive function to create mirror of given tree
    public static Node createMirror(Node root) {
        // 🛑 Base case – agar node hi null ho toh kuch karne ki zarurat nahi
        if (root == null) {
            return null;
        }

        // 🔄 Pehle left subtree ka mirror lelo
        Node leftMirror = createMirror(root.left);

        // 🔄 Phir right subtree ka mirror lelo
        Node rightMirror = createMirror(root.right);

        // ♻️ Ab actual mirroring – left/right ko swap kar diya
        root.left = rightMirror;
        root.right = leftMirror;

        // 🔙 Root return karo – yeh updated (mirrored) subtree ka root hai
        return root;
    }

    // 📦 Preorder traversal function (root → left → right)
    public static void preorder(Node root) {
        // 🛑 Agar current node null hai toh kuch print nahi karna
        if (root == null) {
            return;
        }

        // 🖨️ Pehle root ka data print karo
        System.out.print(root.data + " ");

        // 👈 Left subtree ka preorder
        preorder(root.left);

        // 👉 Right subtree ka preorder
        preorder(root.right);
    }

    // 🚀 Program ka entry point – yahan se sab shuru hoga
    public static void main(String[] args) {

        // 🌳 Manual tree banaya jaa rha hai:
        //         8
        //       /   \
        //      5     10
        //     / \      \
        //    3   6      11

        Node root = new Node(8); // 🟢 Root node
        root.left = new Node(5); // 👈 Left child of root
        root.right = new Node(10); // 👉 Right child of root
        root.left.left = new Node(3); // 👈👈 Left of left
        root.left.right = new Node(6); // 👉👈 Right of left
        root.right.right = new Node(11); // 👉👉 Right of right

        // 🪞 Mirror function call kar rahe hain
        root = createMirror(root);

        // 📣 Preorder traversal print karenge mirrored tree ka
        preorder(root);
    }
}
