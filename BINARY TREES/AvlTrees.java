public class AvlTrees {

    /*
     * AVL Tree is a self-balancing binary search tree.
     * It maintains the balance factor of each node to be -1, 0, or 1.
     * The balance factor is calculated as the  |height of the left subtree minus the height of the right subtree|.
     * agar avl trees mein balance factor -1, 0, 1 hai toh woh balanced hai.
     * agar aur kuch ho jaye toh woh unbalanced hai.
     * agar bst mein n elements hai to uske n! alag tree combinations bant sakte hai.
     * ab ham balancing ke liye rotations ka concept use karte hai .
     * 
     * Rotations:
     * 1. Left Rotation (LL rotations): ye jab use hoti hai jab jis node ka balance factor bigda hai uske left ke left mein insertion hui ho.
     * isme ham right mein rotation krte hai.
     * 
     * ex :     10
     *         /
     *       5           =>         5
     *     /                      /   \     
     *   2                      2     10    
     * 
     * 2. Right Rotation (RR rotations): ye jab use hoti hai jab jis node ka balance factor bigda hai uske right ke right mein insertion hui ho.
     * isme ham left mein rotation krte hai.
     * 
     * ex :     10
     *            \
     *             20           =>            20
     *              \\                       /   \
     *              30                    10    30
     * 
     * 3. RL Rotation: ye jab use hoti hai jab jis node ka balance factor bigda hai uske right ke left mein insertion hui ho.
     * isme pehle right rotation karte hai phir left rotation karte hai.
     * 
     * ex :     10                   10
     *            \\         RR        \\          LL         
     *             20       =>         15        =>        20   
     *            /                     \\                 /  \\
     *           15                      20             10    30
     * 
     * 4. LR Rotation: ye jab use hoti hai jab jis node ka balance factor bigda hai uske left ke right mein insertion hui ho.
     * * isme pehle left rotation karte hai phir right rotation karte hai.
     * 
     * ex :     10                   10
     *         /        LL          /        RR         7
     *       5          =>         7         =>       /   \\
     *        \\                   /                 5     10      
     *          7               5
     * 
     * Note : manlo agar balance factor ek sath 2 nodes ka ek sath bigad jaye to pehle balance use krenge jo last node inserted ke sabse paas hoga.
     * 2. jab bhi lambe cases bane like rll , lrl, toh unhe pehle chote case mein convert karenge shuru ke 2 letters pick karke.
     * ex : RLL = > RL 
     */

    // Node class jo ek node ko represent karegi tree ke andar
    static class Node {
        int data, height; // data means node ka value, height har node ki height store karne ke liye
        Node left, right; // left aur right child node pointers

        Node(int data) {
            this.data = data;
            height = 1; // jab node create hoti hai, toh wo leaf node hoti hai isliye height = 1
        }
    }

    public static Node root; // hamara main tree ka root node

    // height function kisi bhi node ki height return karta hai
    public static int height(Node root) {
        if (root == null) {
            return 0; // null ka matlab height 0 hoti hai
        }
        return root.height; // agar node hai toh uski height return karo
    }

    // Balance factor calculate karne ka function
    public static int getBalanceFactor(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right); // left - right height ka difference hi balance factor hota hai
    }

    // Right rotate: jab Left Left case hota hai tab use hoti hai
    public static Node rightRotate(Node y) {
        Node x = y.left; // left child store karo
        Node T2 = x.right; // x ke right subtree ko temporarily save karo

        // Rotation perform karo
        x.right = y;
        y.left = T2;

        // Heights update karo har node ki
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // new root return karo
        return x;
    }

    // Left rotate: jab Right Right case hota hai tab use hoti hai
    public static Node leftRotate(Node x) {
        Node y = x.right; // right child store karo
        Node T2 = y.left; // y ke left subtree ko temporarily save karo

        // Rotation perform karo
        y.left = x;
        x.right = T2;

        // Heights update karo har node ki
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // new root return karo
        return y;
    }

    // Insert function BST ki tarah insert karta hai aur AVL balance maintain karta hai
    public static Node insert(Node root, int key) {
        // base case: agar root null hai to new node create karke return kar do
        if (root == null) {
            return new Node(key);
        }

        // normal BST insertion
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // duplicates allowed nahi hai AVL tree mein
        }

        // height update karo har node ki
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // balance factor nikalo to check unbalanced ya nahi
        int balancefactor = getBalanceFactor(root);

        // Left Left Case
        if (balancefactor > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        // Right Right Case
        if (balancefactor < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        // Left Right Case
        if (balancefactor > 1 && key > root.left.data) {
            root.left = leftRotate(root.left); // pehle left rotation left child pe
            return rightRotate(root); // phir right rotation root pe
        }

        // Right Left Case
        if (balancefactor < -1 && key < root.right.data) {
            root.right = rightRotate(root.right); // pehle right rotation right child pe
            return leftRotate(root); // phir left rotation root pe
        }

        return root; // agar koi imbalance nahi mila to simple root return karo
    }

    // Preorder traversal (root -> left -> right)
    public static void preorder(Node root) {
        if (root == null) {
            return; // base case
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        // Output dekhenge preorder traversal ke through
        System.out.println("Preorder traversal of AVL Tree:");
        preorder(root);
    }
}
