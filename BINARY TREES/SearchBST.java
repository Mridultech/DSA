public class SearchBST { // Time complexity : O(H) , where h is height of tree for balanced bst , but still for skewed bst ( ek taraf jhuka hua tree) worst case time complexity will be again O(n)

    /*
     * Concept of search in binary search tree : 
     * 
     * Linear search : O(N)
     * Binary search : O(logn)
     * 
     * bst mein : 
     * 1. pehle ham compare karenge root mein 
     *      a. agar value root se choti hogi to left subtree mein search karenge.
     *      b. agar value root se badi hogi to right subtree mein search karenge.
     * 
     * yaha jadatar questions recursion and divide and conquer approach se solve honge.
     * 
     * approach : 
     * 1 . pehle key ko root se compare krenge if root == key then we'll return true.
     * 2. if key < root => go to left subtree.
     * 3. if key > root => go to right subtree.
     * 4. if root == null then we'll reutnr false .
     * 
     * Note : in worst case scenario height of balanced bst can be O(h)
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

     public static boolean search(Node root , int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data < key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key)
        }
     }
    public static void main(String[] args) {
        int key = 1;
        int values[] = {1,2,3,4,5,6,7,8};
        Node root = new Node(1);
        if(search(root,key) == true){
            System.out.println("Key Found!");
        }
        else{
            System.out.println("Key not Found!");
        }
    }
}
