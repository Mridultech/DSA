public class SortedArrayToBalancedBST { // O(n) -> Har node sirf ek hi baar visit ho rahi hai

    /*
     🧠 Sochne wali baat:
     1️⃣ Balanced BST matlab left aur right subtree ki height lagbhag same honi chahiye.
     2️⃣ BST ka inorder hamesha sorted hota hai.
     🔁 Isiliye agar array already sorted hai toh hum directly usse BST bana sakte hain.
     
     ⚙️ Approach:
     1. Har baar array ka middle element uthayenge aur usse root bana denge.
     2. Uske left wale elements se left subtree banega aur right wale se right subtree.
     3. Aise recursively divide karte jaayenge tab tak jab tak pura tree ban jaye.
     */

    // ✅ Node class banayi hai jo ek node ko represent karegi BST mein
    static class Node {
        int data; // 🧮 Node ka actual value
        Node left, right; // 👉 Left aur right branches

        Node(int data) {
            this.data = data; // 📌 Current node ka data set kar diya
            left = null; // 👈 Left initially null
            right = null; // 👉 Right initially null
        }
    }

    // 🔁 Preorder traversal (Root -> Left -> Right)
    public static void preorder(Node root) {
        if (root == null) {
            return; // ☠️ Base case - agar node null hai toh kuch mat kar
        }

        System.out.print(root.data + " "); // 🖨️ Root ko print kar diya
        preorder(root.left); // 👈 Left subtree mein gaya
        preorder(root.right); // 👉 Right subtree mein gaya
    }

    // 🎯 Actual function jo BST banayega sorted array se
    public static Node createBST(int arr[], int start, int end) {
        if (start > end) {
            return null; // 🙅‍♂️ Base case - agar start index bada ho gaya end se, toh kuch bhi nahi bacha
        }

        int mid = (start + end) / 2; // 🎯 Middle element nikaala - wahi banega root
        Node root = new Node(arr[mid]); // 🌱 Naya node banaya middle element ka

        // 🔄 Ab recursively left aur right subtree bana rahe hain
        root.left = createBST(arr, start, mid - 1); // ⬅️ Left subtree ke liye call
        root.right = createBST(arr, mid + 1, end);  // ➡️ Right subtree ke liye call

        return root; // 🔙 Root return kar diya
    }

    // 🚀 Main function jahan se sab kuch start hoga
    public static void main(String[] args) {
        int arr[] = {3, 5, 6, 8, 10, 11, 12}; // 📚 Sorted array diya hua hai
        Node root = createBST(arr, 0, arr.length - 1); // 🌳 BST bana liya array se
        preorder(root); // 📢 Tree ko print kar rahe hain preorder mein
    }
}
