public class ShortestUniquePrefixProblem {

    /*
     * Problem Statement:
     * Find the shortest unique prefix for each word in the list.
     * A prefix is unique if it is not a prefix of any other word.
     * Assume all words are unique and no word is prefix of another.
     * 
     * Example:
     * Input : { "zebra", "dog", "dove", "duck" }
     * Output: { "z", "dog", "dov", "du" }
     */

    // Trie Node class
    static class Node {
        Node[] children = new Node[26]; // 26 letters
        int frequency; // how many words pass through this node

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            frequency = 0; // default freq is 0
        }
    }

    // Root of Trie
    public static Node root = new Node();

    // Inserts a word into the trie
    public static void insert(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            // agar node nahi hai to naya banao
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new Node();
            }

            // next node pe move karo
            currentNode = currentNode.children[index];

            // har node pe frequency badhao
            currentNode.frequency++;
        }
    }

    // Finds shortest unique prefix of a word
    public static String shortestUniquePrefix(String word) {
        Node currentNode = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            // prefix mein current char add karo
            prefix.append(word.charAt(i));

            // move to next node
            currentNode = currentNode.children[index];

            // agar freq == 1, toh yahi unique prefix hai
            if (currentNode.frequency == 1) {
                break;
            }
        }
        return prefix.toString();
    }

    // Main function
    public static void main(String[] args) {
        String[] words = { "zebra", "dog", "dove", "duck" };

        // Step 1: Build Trie with all words
        for (String word : words) {
            insert(word);
        }

        // Step 2: Print shortest unique prefix for each word
        System.out.println("Shortest unique prefix for each word is:");
        for (String word : words) {
            System.out.println(word + " -> " + shortestUniquePrefix(word));
        }
    }
}
