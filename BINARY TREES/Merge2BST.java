import java.util.*;

// Ye class do BSTs ko merge karegi ek hi balanced BST mein
public class Merge2BST { // time complexity : O(m+n) , space complexity : O(m+n) , m = size of first BST , n = size of second BST

    // Node class – simple structure ek BST node ka
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Ye function BST ko inorder traversal mein convert karta hai (sorted array milti hai)
    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) return;

        // Left -> Root -> Right (Inorder)
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    // Ye function sorted array se ek balanced BST banata hai using recursion
    public static Node createBST(ArrayList<Integer> arr, int start, int end) {
        if (start > end) return null;

        // Beech ka element le rahe hai taaki BST balanced ho
        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));

        // Left subtree banega left part of array se
        root.left = createBST(arr, start, mid - 1);

        // Right subtree banega right part of array se
        root.right = createBST(arr, mid + 1, end);

        return root;
    }

    // MAIN FUNCTION: 2 BSTs ko merge karke ek balanced BST return karta hai
    public static Node mergeBST(Node root1, Node root2) {
        // Step 1: root1 BST ka inorder (sorted array)
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        // Step 2: root2 BST ka inorder
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Step 3: dono sorted arrays ko merge karo into finalArr
        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();

        // Dono arrays ko compare karte hue merge kar rahe hai
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        // Agar koi element bach gaya ho arr1 mein
        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        // Agar koi element bach gaya ho arr2 mein
        while (j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        // Step 4: Final sorted array se balanced BST banao
        return createBST(finalArr, 0, finalArr.size() - 1);
    }

    // Preorder traversal (Root -> Left -> Right) – final BST print karne ke liye
    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");  // 👈 Print kar rahe hain data
        preorder(root.left);
        preorder(root.right);
    }

    // MAIN METHOD: Sample trees banaye ja rahe hai yaha se
    public static void main(String[] args) {
        // Pehla BST: 2 -> (1, 4)
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        // Dusra BST: 9 -> (3, 12)
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        // Dono BSTs ko merge kar rahe hain
        Node mergedRoot = mergeBST(root1, root2);

        // Final merged BST ka preorder traversal print kar rahe hain
        System.out.println("Preorder of Merged Balanced BST:");
        preorder(mergedRoot);
    }
}
