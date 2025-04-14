import java.util.*;

public class GroupAnagramsTogether { // is question ko dubara pdunga

    // 🌲 Har node ek character ko represent karti hai
    static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 26 alphabets ke liye space
        List<String> words = new ArrayList<>(); // Yahan par hum original words store karenge (sorted form se match hone wale)

        public TrieNode() {
            // Initially sabhi child nodes null honge
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    // 🌳 Trie ka root node
    static TrieNode root = new TrieNode();

    // 🔡 Ye method ek word ko insert karega sorted form mein
    public static void insert(String word) {
        // 1️⃣ Word ko character array mein convert karo aur sort kar do
        char[] sortedChars = word.toCharArray();
        Arrays.sort(sortedChars);
        String sorted = new String(sortedChars); // Sorted version ban gaya

        TrieNode currentNode = root;

        // 2️⃣ Har character ko Trie mein insert karo
        for (int i = 0; i < sorted.length(); i++) {
            int index = sorted.charAt(i) - 'a'; // ASCII value se index nikal rahe hain (0 to 25)
            if (currentNode.children[index] == null) {
                // Agar child node exist nahi karti toh bana do
                currentNode.children[index] = new TrieNode();
            }
            // Move to the child node
            currentNode = currentNode.children[index];
        }

        // 3️⃣ Last node tak jaake, usme original word add kar do
        // Jaise "eat", "tea", "ate" sabka sorted form "aet" hai — toh sab ek hi node par store honge
        currentNode.words.add(word);
    }

    // 📦 Ye method recursive hai aur Trie ko traverse karke groups collect karega
    public static void collectGroups(TrieNode node, List<List<String>> result) {
        if (node == null) return;

        // Agar kisi node mein words ki list hai, toh wo ek group hoga
        if (!node.words.isEmpty()) {
            result.add(node.words);
        }

        // Har child node ko visit karo recursively
        for (int i = 0; i < 26; i++) {
            collectGroups(node.children[i], result);
        }
    }

    public static void main(String[] args) {
        // 📥 Input words array
        String[] words = { "eat", "tea", "tan", "ate", "nat", "bat" };

        // 🏗️ Har word ko insert karna hai Trie mein
        for (String word : words) {
            insert(word);
        }

        // 📦 Result store karne ke liye List of Lists
        List<List<String>> groupedAnagrams = new ArrayList<>();

        // 🚀 Trie traverse karke sab groups collect karo
        collectGroups(root, groupedAnagrams);

        // 🖨️ Print all grouped anagrams
        System.out.println("Grouped Anagrams:");
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}
