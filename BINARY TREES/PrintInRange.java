public class PrintInRange {

    /*
     * Problem statement : Given a binary search tree and a range [low, high], print all the nodes that lie in the given range.
     * 
     * 
     */

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node insert(Node root , int value){
        //base case 
        if(root == null){
            return new Node(value);
        }
        
        if(value < root.data){
            root.left = insert(root.left,value);
        }
        else{
            root.right = insert(root.right,value);
        }

        return root;
    }

    public static void printInRange(Node root , int low , int high){
        //base case : 
        if(root == null){
            return;
        }

        //if the current node is in range, print it
        if(root.data >= low && root.data <= high){
            printInRange(root.left,low,high);
            System.out.println(root.data + " ");
            printInRange(root.right,low,high);
        }
        else if(root.data < low){
            printInRange(root.right, low, high);
        }
        else{
            printInRange(root.left, low, high);
        }
    }
public static void main(String[] args){
    int values[] = {1,2,3,4,5,6,7,8,9,0};
    int low = 5 , high = 8;
    Node root = null;

    for(int i = 0; i < values.length ; i++){
        root = insert(root,values[i]);
    }

    inorder(root);

    System.out.println();
    
    printInRange(root, low, high);
}
}
