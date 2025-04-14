public class MinimumDistanceBetweenTwoNodes {

    /*
     * ✅ Minimum distance between two nodes = 
     * Distance from LCA to n1 + Distance from LCA to n2
     * 
     * 💡 Jaise 2 log ek common point se nikalte hain alag-alag raste pe,
     * toh dono ka distance calculate karne ke liye unka junction (LCA) pakad lo.
     */

    // 👷 Node class bana rahe hain — ek ek node ka data aur branches store karega
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null; // initially koi left child nahi
            this.right = null; // initially koi right child nahi
        }
    }

    // 🔍 Lowest Common Ancestor (LCA) dhoondhne wala function
    public static Node lca(Node root , int n1 , int n2){
        if (root == null) return null; // 🛑 base case — agar tree hi khali hai

        // ✅ Agar current node hi kisi ek value ke barabar hai
        if(root.data == n1 || root.data == n2){
            return root; // potential LCA mil gaya
        }

        // 🔁 Left aur right subtrees me recursively dhoondho
        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        // 🔄 agar right null hai, matlab dono nodes left me honge
        if(rightLca == null){
            return leftLca;
        }

        // 🔄 agar left null hai, matlab dono nodes right me honge
        if(leftLca == null){
            return rightLca;
        }

        // 🔥 agar dono taraf se kuch mila, toh current node hi LCA hai
        return root;
    }

    // 🔢 Kisi node se target node tak ka distance find karna
    public static int lcaDist(Node root, int n){
        if(root == null){
            return -1; // ❌ agar node null hai toh -1 return karo
        }

        if(root.data == n){
            return 0; // 🎯 target mil gaya toh distance 0
        }

        // 🔍 Left aur Right subtree me target dhoondhna
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        // 😵 agar dono side se nahi mila
        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        // 👉 agar left me nahi mila, right me mila toh +1 (ek step aage badh gaya)
        else if(leftDist == -1){
            return rightDist + 1;
        }
        else {
            return leftDist + 1; // 👈 left me mila toh usme +1 karke return
        }
    }

    // 🔥 Minimum distance calculate karne ka final function
    public static int minDist(Node root, int n1 , int n2){
        Node lca = lca(root,n1,n2); // 📌 Pehle LCA nikaal lo

        // 🚨 agar LCA null aaya, matlab koi node missing ho sakti hai
        if (lca == null) {
            System.out.println("LCA not found. One or both nodes may not be present in the tree.");
            return -1;
        }

        // 🔢 LCA se n1 aur n2 tak ka distance find karo
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        // ❗ agar kisi node ka distance -1 hai, toh wo node tree me nahi hai
        if (dist1 == -1 || dist2 == -1) {
            System.out.println("One or both nodes are not present in the tree.");
            return -1;
        }

        return dist1 + dist2; // ✅ final answer = dist1 + dist2
    }

    public static void main(String[] args) {
        // 🌳 Ek sample binary tree bana rahe hain:
        /*
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 6; // ✅ Distance between node 4 and node 6
        int result = minDist(root, n1, n2); // 🚀 Call kar rahe hain final function

        // 🎉 Agar result valid hai toh output print karo
        if (result != -1) {
            System.out.println("Minimum distance between " + n1 + " and " + n2 + " is: " + result);
        }
    }
}
