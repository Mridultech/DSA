public class DeleteANode {

    /*
     * Concept of deleting a node from bst : 
     * case 1 : deleting leaf node : in this value just delete node and return null to parent 
     * case 2 : deleting node having only single child : just delete and connect the own child node to own parent node.
     * case 3 : deleting node having 2 childs : replace the value of current node with inorder successor and then delete the inorder successor node. 
     * 
     */
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

     public static Node delete(Node root, int value){
        //checking in which subtree of parent tree does the node lies
        if(root.data < value){
            root.right = delete(root.right,value);
        }
        else if(root.data > value){
            root.left = delete(root.left, value);
        }
        else{ // hame element to mil gaya 
            //case 1 : Leaf Node 
            if(root.left == null && root.right == null){
                return null; // parent ko null return krdiya juisse automatically garbage collector delete kaardega leaf node ko.
            }

            //case 2 : single child node 
            else if(root.left == null){
                return root.right; // parent ko right child return kiya jisse parent ka left child null ho jaayega.
            }
            else if(root.right == null){
                return root.left; // parent ko left child return kiya jisse parent ka right child null ho jaayega.
            }
            //case 3 : 2 child node 
            else{
                //find inorder successor 
                Node is = findInorderSuccessor(root.right); // right subtree se inorder successor ko find kiya.
                root.data = is.data; // current node ka data ko inorder successor ke data se replace kiya.
                root.right = delete(root.right, is.data); // inorder successor ko delete kiya.

                //Note : Inorder successor tree mein right subtree mein leftmost node hota hai
            }
        }
        return root; // parent ko return kiya jisse parent ka left ya right child update ho jaayega.
     }

     public static Node insert(Node root, int value){
        if(root == null){
            return new Node(value); // jab root null ho tab naya node create karke return kiya.
            
        }
        if(value < root.data){
            root.left = insert(root.left, value);
        } else if(value > root.data){
            root.right = insert(root.right, value);
        }
        return root; // jab root null nahi hai tab parent ko return kiya jisse parent ka left ya right child update ho jaayega.
     }
    
     public static Node findInorderSuccessor(Node node) {
        //jab tak right subtree of parent tree mein leftmost node pe na pahcuch jaiye tab tak nichye left mein jate rho.
         while (node.left != null) {
             node = node.left;
         }
         return node;
     }

     public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left); // left subtree ko traverse kiya.
        System.out.print(root.data + " "); // current node ko print kiya.
        inorder(root.right); // right subtree ko traverse kiya.
     }
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,7,6,10,14,13};
        Node root = null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }

        root = delete(root, 10);

        System.out.println("Inorder traversal after deletion of 10 : ");
        inorder(root);  }
    
}
