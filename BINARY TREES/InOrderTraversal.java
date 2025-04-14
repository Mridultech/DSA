public class InOrderTraversal { // time complexity : O(n)

    /*
     * Inorder Traversal: Left, Root, Right
     * 
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

            //  YAHI SAFETY CHECK ADDED HAI
            if (index >= nodes.length || nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        // Logic for inorder
        inOrder(root.left);

        System.out.println(root.data + " ");

        inOrder(root.right);
    }

    public static void main(String[] args){

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

        InOrderTraversal.inOrder(root);
        // Output: 1 2 4 5 3 6
    }
}
    

