import java.util.*;
public class RootToLeafPath {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();

    }

    public static Node insert(Node root , int value){
        if(root == null){
            return new Node(value);
        }
        if(value < root.data){
            root.left = insert(root.left , value);
        }else{ 
            
            root.right = insert(root.right , value);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void printRootToLeaf(Node root,ArrayList<Integer> path ){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }

        printRootToLeaf(root.left , path);
        printRootToLeaf(root.right , path);

        //backtracking step 
        path.remove(path.size() -1);
    }
    public static void main(String[] args){
        int values[] = {8,10,3,6,14,4,7,13};
        Node root = null;

        for(int i = 0; i < values.length; i++){
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        printRootToLeaf(root, new ArrayList<>());

    }
}
