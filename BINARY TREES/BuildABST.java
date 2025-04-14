public class BuildABST {
    

    /*
     * Approach : 
     * 1. pehle ek root node lelenge then pehli value ko root mein daal denge. 
     * 2. uske bad comparison krenge if value[i] > root then use right subtree mein dal denge.
     * 3. if value[i] < root then use left subtree mein dal denge
     * 
     * hw problem
     */

     static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
     }

     public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
     }

     public static Node insert(Node root, int val) {
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            //left subtree
            root.left = insert(root.left,val);
        }

        if(root.data < val){
            //right subtee
            root.right = insert(root.right,val);
        }

        return root;
     }
    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for(int i = 0 ; i < values.length; i+=){
            root = insert(root, values[i]);
        }

        inOrder(root);
    }
}
