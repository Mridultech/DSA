public class Basics {

    /*
     * Tries Notes here:
     * 
     * Tries are also known as prefix trees ,retrival trees or digital search trees.
     * 
     * 1. Tries kya hai?
     *    - Trie ek tree-like data structure hai jo strings ko efficiently store aur search karne ke liye use hota hai.
     *    - Iska use mostly dictionary-based problems me hota hai, jaise prefix search, autocomplete, etc.
     * 
     * 2. Trie ka structure:
     *    - Har node ek character ko represent karti hai.
     *    - Root node empty hoti hai.
     *    - Har edge ek character ko represent karti hai.
     *    - Leaf node ek complete word ko represent karti hai.
     * 
     * 3. Operations in Trie:
     *    - Insert: Ek word ko trie me add karna.
     *    - Search: Check karna ki word trie me hai ya nahi.
     *    - StartsWith: Check karna ki koi prefix trie me exist karta hai ya nahi.
     * 
     * 4. Time Complexity:
     *    - Insert/Search/StartsWith: O(L), where L is the length of the Largest string or word.
     *    - Space Complexity: O(N * L), where N is the number of words and L is the average length of words.
     * 
     * 5. Applications:
     *    - Autocomplete systems (Google search, mobile keyboards).
     *    - Spell checkers.
     *    - Longest prefix matching (network routing).
     *    - Word games (like Boggle).
     * 
     * 6. Example:
     *    - Words: ["cat", "cap", "bat"]
     *    - Trie Structure:
     *          root
     *         /   \
     *        c     b
     *       / \     \
     *      a   a     a
     *     /     \     \
     *    t       p     t
     * 
     * 7. Important Points:
     *    - Trie me har node ek hashmap ya array ke through children ko store karti hai.
     *    - Space optimization ke liye compressed tries (Radix Tree) ka use hota hai.
     * 
     * 8. Extras : 
     *   - Trie mein ek parent ke kitne bhi children ho sakte hain, lekin har child ek unique character ko represent karta hai.
     * 
     * 9. Main use : Questions like prefix search, autocomplete, longest common prefix, etc.
     */

     static class Node{
        Node children[] = new Node[26]; // Assuming only lowercase English letters
        // Each index represents a character (0 for 'a', 1 for 'b', ..., 25 for 'z')
        boolean isEndOfWord = false; // Is this node the end of a word?
        // Constructor to initialize the node
        public Node(){
            for(int i = 0; i < children.length; i++){
                children[i] = null; // Initialize all children to null
            }
        }
     }

     static Node root = new Node(); // Root node of the trie

    //Operations in tries : 

    // 1. Insert

    public static void Insert(String word){
        Node currentNode = root; // Start from the root node
        for(int level = 0 ; level < word.length() ; level++){
            int index = word.charAt(level) -'a' ; // Calculate index (0 for 'a', 1 for 'b', ..., 25 for 'z')
            if(currentNode.children[index] == null){
                currentNode.children[index] = new Node(); // Create a new node if it doesn't exist
            }
            currentNode = currentNode.children[index]; // Move to the next node
        }
        currentNode.isEndOfWord = true; // Mark the end of the word
    }

    // 2. Search

    public static boolean Search (String key){
    
        Node currentNode = root; // Start from the root node
        for(int i = 0 ; i < key.length() ; i++){
            int index = key.charAt(i) - 'a'; // calculate index (0 for 'a', 1 for 'b', ..., 25 for 'z')
            if(currentNode.children[index] == null){
                return false; // If the character is not found, return false
            }
            currentNode = currentNode.children[index]; // Move to the next node
        }
        return currentNode.isEndOfWord == true; // Return true if it's the end of a word
    }

    public static void main(String[] args){

        String words[] = {"cat", "cap", "bat"};

        // Create a new root node for the trie
        for(int i = 0 ; i < words.length ; i++){
            Insert(words[i]); // Insert each word into the trie
        }

        System.out.println(Search("cat")); // true
        System.out.println(Search("cap")); // true
        System.out.println(Search("bat")); // true
        System.out.println(Search("batman")); // false
    }
}