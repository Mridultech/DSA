public class WordBreakProblem {

    /*
     * Problem statement : Given an input string and a dictionary of words, find out if the input string can be broken into a space separated sequence of dictionary words.
     * 
     * example :
     * words[] = {i,like,sam,samsung,mobile,ice}
     * input = ilikesamsung
     * output = true
     * 
     */

    static class Node{
        Node children[] = new Node[26];
        boolean isEndOfWord = true;

        public Node() { 
            for(int i = 0 ; i < children.length ; i++){
                children[i] = null;
            }

        }
    }

    static Node root = new Node();

    public static void insert(String word){
        Node currentNode = root;
        for(int i = 0 ; i < word.length() ; i++){
            int index = word.charAt(i) - 'a';
            if(currentNode.children[index] == null){
                currentNode.children[index] = new Node();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    public static boolean search(String key){
        Node currentNode = root;
        for(int i = 0 ; i < key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(currentNode.children[index] == null){
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord == true;
    }

    public static boolean wordBreak(String input){
        if(input.length() == 0){
            return true;
        }
        for(int i = 1 ; i <= input.length() ; i++){
            if(search(input.substring(0,i)) && wordBreak(input.substring(i))){ // isme bydefault second string i se start hota hai and till the end of the string.
                // if the first part of the string is present in the dictionary and the second part of the string can be segmented into words from the dictionary then return true.
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};

        String input = "ilikesamsung";

        for(int i = 0 ; i < words.length ; i++){
            insert(words[i]);
        }

        boolean result = wordBreak(input);

        if(result){
            // if the result is true then the input string can be segmented into words from the dictionary.
            System.out.println("The input string can be segmented into words from the dictionary.");
        }else{
            System.out.println("The input string cannot be segmented into words from the dictionary.");
        }
    }
}