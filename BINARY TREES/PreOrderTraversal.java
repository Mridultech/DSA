
public class PreOrderTraversal { // time complexity : O(n)

    /*
     * Pre-order traversal of a binary tree is a type of depth-first traversal where the nodes are recursively visited in this order: root, left subtree, right subtree.
     * This means that for each node, you first process the node itself, then recursively visit the left child, and finally recursively visit the right child.]
     */

     
    static class Node {
        int data;
        Node left;
        Node right;

        // constructor
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;

            // ✅ YAHI SAFETY CHECK ADDED HAI
            if (index >= nodes.length || nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        PreOrderTraversal.preorder(root);
        // Output: 1 2 4 5 3 6
    }
}
