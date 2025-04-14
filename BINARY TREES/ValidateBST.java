public class ValidateBST {

    /*
     🧠 Concept: Check karna hai ki tree BST (Binary Search Tree) hai ya nahi.
     ✅ BST Rule: 
         1. Left subtree ke sab nodes < current node.
         2. Right subtree ke sab nodes > current node.
         3. Ye rule har level pe valid hona chahiye.
    */

    // Node class – tree ka ek ek node yahan define hoga
    static class Node {
        int data;
        Node left;
        Node right;

        // constructor – har new node ka left & right null initially
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ✅ Inorder traversal – tree ko sorted order mein print karega agar BST hai toh
    public static void inorder(Node root) {
        if (root == null) {
            return; // agar node hi null ho toh kuch print nahi karna
        }

        inorder(root.left); // left subtree pe jao
        System.out.print(root.data + " "); // root print karo
        inorder(root.right); // right subtree pe jao
    }

    // ✅ BST ke rules follow karte hue insert karna values ko
    public static Node insert(Node root, int value) {
        // base case – agar root hi null hai, naya node banake return kar do
        if (root == null) {
            return new Node(value);
        }

        // agar value chhoti hai toh left mein daalo
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            // warna right mein daalo (same value repeat ho toh bhi right mein jaayega)
            root.right = insert(root.right, value);
        }

        return root; // current root return karo recursion ke liye
    }

    // ✅ Core function: Check karna if tree is a valid BST using min/max boundaries
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true; // agar root hi null hai toh obviously valid hai
        }

        // ❌ Galat condition: agar value allowed range ke bahar chali gayi
        if (min != null && root.data <= min.data) {
            return false; // agar current node ka data min se chhota ya barabar ho
        }

        if (max != null && root.data >= max.data) {
            return false; // agar current node ka data max se bada ya barabar ho
        }

        // ✅ Recurse karo: 
        // Left ke liye max boundary current root ban jaayegi
        // Right ke liye min boundary current root ban jaayegi
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    // ✅ Main function – yahan se execution shuru hota hai
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 6, 10, 11, 14}; // input values (BST banne layak)
        Node root = null; // tree ka initial root null

        // 🔁 Saari values ko tree mein insert karo
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // ✅ Inorder traversal – sorted order print karega agar BST hai toh
        System.out.print("Inorder traversal of tree: ");
        inorder(root);
        System.out.println();

        // ✅ BST valid hai ya nahi – check kar lo
        if (isValidBST(root, null, null)) {
            System.out.println("The tree is a valid BST.");
        } else {
            System.out.println("The tree is NOT a valid BST.");
        }
    }
}
