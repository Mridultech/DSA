public class Subtree {

    /*
     * Given the roots of two binary trees root and subRoot , return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
     * 
     * approach : 
     * 1. Find sub root by any traversal (root.data) == subRoot.data;
     * 2. check identical for (subtree , node subtree)
     * 
     * condition for non-identical : 
     * 1 node.data != subRoot.data
     * 2. node = null || subRoot = null
     * 3. leftSubtree -> non-identical
     * 4. rightSubtree -> non-identical
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

    public static boolean isIdentical(Node node,Node subRoot){
        // identical ki bahut conditions ho skti hai lekin compartively non-identical check krna aasan hai to ham wo krenge.
        if(node == null && subRoot == null){ // dono hi null hai to true return karo
            return true;
        } else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        if(!isIdentical(node.left,subRoot.left)){ // left subtree check karo
            return false;
        }
        if(!isIdentical(node.right,subRoot.right)){ 
            return false;
        }
        return true; // dono hi identical hai to true return karo
        }
    

    public static boolean isSubtree(Node node , Node subRoot){

        if(node == null){ // dono hi null hai to true return karo
            return false;
        }
        if(node.data == subRoot.data){ // pehle khudse comparison hai 
            if(isIdentical(node , subRoot)){
                return true;
            }
        }

        return isSubtree(node.left,subRoot) || isSubtree(node.right,subRoot); // dono me se koi bhi true ho to true return karo
    }


    public static void main(String[] args){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //subtree : 

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));  // Should print true if subtree exists

    }
}