public class TransformToSumTree {

    /*
     * 📘 WHAT IS A SUM TREE?
     * ➤ Ek binary tree jisme har node ka data equal hota hai 
     *    uske left subtree + right subtree ke nodes ke sum ke barabar.
     * ➤ Leaf nodes ke left & right dono null hote hain, toh unka sum hota hai 0.
     * ➤ Hum original tree ko modify kar dete hain ek "Sum Tree" mein.
     */

    // 🌱 Node class: ek simple tree node define karne ke liye
    static class Node {
        int data;          // 🔢 Node ki value
        Node left, right;  // 👈 Left child & 👉 Right child

        Node(int data) {
            this.data = data;
            this.left = this.right = null; // 🌱 Initially left & right null hote hain
        }
    }

    // 🔁 Transform function: poore tree ko sum tree mein convert karta hai
    public static int transform(Node root) {

        if (root == null) {
            return 0; // 🛑 Base condition: agar node hi null hai, toh kuch nahi karna
        }

        int leftSum = transform(root.left);    // 👈 Left subtree ka sum nikal lo
        int rightSum = transform(root.right);  // 👉 Right subtree ka sum bhi nikal lo

        int oldValue = root.data;  // 💾 Apne current node ka original value save kar lo (kyunki overwrite karne wale hain)

        root.data = leftSum + rightSum;  // 🧠 Sum Tree rule: current node ka data = left subtree sum + right subtree sum

        return oldValue + root.data;  // 🔙 Total sum (original value + new data) return karo taaki parent node use kar sake
    }

    // 🚶‍♂️ Preorder traversal: root ➝ left ➝ right
    public static void preorder(Node root) {
        if (root == null) return;  // 🔚 Agar node null ho gaya toh stop

        System.out.print(root.data + " ");  // 📤 Pehle root ka data print karo
        preorder(root.left);  // 👈 Left subtree ka traversal
        preorder(root.right); // 👉 Right subtree ka traversal
    }

    public static void main(String[] args) {  // 🚀 Program ka entry point

        // 🛠️ Binary Tree Bana rahe hain
        Node root = new Node(1);               // 🌱 Root node
        root.left = new Node(2);               // 👈 Root ke left mein 2
        root.right = new Node(3);              // 👉 Root ke right mein 3
        root.left.left = new Node(4);          // 👈 2 ke left mein 4
        root.left.right = new Node(5);         // 👉 2 ke right mein 5
        root.right.left = new Node(6);         // 👈 3 ke left mein 6
        root.right.right = new Node(7);        // 👉 3 ke right mein 7

        /*
            🧠 Original Tree:
            
                    1
                  /   \
                 2     3
                / \   / \
               4   5 6   7

            ✅ Sum Tree Banana Hai:

                   27
                 /    \
                9      13
              /  \    /  \
             0    0  0    0

            🧾 Har node ka data = uske left + right subtree ka sum
        */

        transform(root);   // 🔁 Tree ko sum tree mein convert karo
        preorder(root);    // 📤 Preorder traversal ke through new tree print karo
    }
}
