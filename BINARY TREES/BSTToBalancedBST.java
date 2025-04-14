import java.util.*;
public class BSTToBalancedBST {

    /*
     * Given a binary search tree, convert it to a balanced binary search tree.
     * 
     */
    static class Node{
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void getInOrder(Node root , ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        getInOrder(root.left, inorder);
        inorder.add(root.data);
        getInOrder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder , int start , int end){
        if(start > end){
            return null;
        }

        int mid = (start+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, start, mid-1);
        root.right = createBST(inorder, mid+1, end);
        return root;
    }
    public static Node balanceBST(Node root){ // time complexity : 2 * O(n) = O(n)
        //inorder sequence , time complexity O(n)
        ArrayList<Integer> inorder = new ArrayList<>();
        getInOrder(root, inorder);

        //sorted inorder -> balanced BST , time complexity O(n)
        root = createBST(inorder, 0 , inorder.size()-1);
        return root;
    }
    public static void main(String[] args){
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balanceBST(root);
        preorder(root);
    }
}
