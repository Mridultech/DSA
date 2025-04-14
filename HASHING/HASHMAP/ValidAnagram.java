import java.util.*;
public class ValidAnagram {

    /*
     * Problem statement : Given two strings s and t, return true if t is an anagram of s and false otherwise.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     * For example, "anagram" is an anagram of "nagaram", and "rat" is an anagram of "car".
     * conditions for anagram:
     * 1. Both strings should be of same length.
     * 2. Both strings should have same frequency of characters.
     * 3. Both strings should have same characters.
     * 4. Both strings should have same number of unique characters.
     * 
     * approach : 
     * 1. Check if the length of both strings is same. If not, return false.
     * 2. Create a frequency map for string s .
     * 3. now iterate through chars of string t and check if there is same frequency of chars in string s.
     * if there is some frequency of char present for that of s then decrement the frequency of that char in string s.
     * 4. If there is any char in string t which is not present in string s, return false.
     * 5. If all chars in string t are present in string s with same frequency, return true.
     * 6. at last we'll check that if map is empty or not. If it is empty then return true else false.
     * 7. Time complexity : O(n) where n is the length of string s or t.
     * 
     * Note : for worst case time complexiyt becomes O(n^2) agar wohi condition hui jisme hashfunction ne sabhi pairs ke liye same index return kiya joki kafi rare condition hai .
     * 
     */

     public static boolean isAnagram(String s , String t){
        //base case 
        if(s.length() != t.length()){
            return false;       
        }   


        //creating hashmap

        HashMap<Character, Integer> map = new HashMap<>();

        //map bana rhe hai for first string s : 

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch , 0) + 1);
        }

        //iterating through string t and checking if there is same frequency of chars in string s.

        for(int i = 0 ; i < t.length() ; i++){

            char ch = t.charAt(i);

            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }
                else{
                    map.put(ch , map.get(ch) - 1);
                }
            }
            else{
                return false;
            }
        }
        return map.isEmpty();
     }
    public static void main(String[] args) {
        String s = "mridul";
        String t = "purnima";
        System.out.println(isAnagram(s, t)); // false
    }
}