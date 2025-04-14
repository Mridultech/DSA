import java.util.*;
public class Question0 { // O(n) time complexity and O(1) space complexity

    /*
     * Problem statement : First non-repeating character in a stream of characters given that all characters are of lower case.
     * Given a stream of characters, find the first non-repeating character in it.
     * For example, if the stream is "aabc", then the first non-repeating character is 'b'.
     * If the stream is "aabb", then there is no non-repeating character.
     * 
     * Note : Mostly stream of characters wale sawal mein queue ka use hota hai
     * 
     * approach : 
     * 1. Use a queue to store the characters in the stream.
     * 2. use an array named as frequency of size 26 to store the frequency of each character.
     * 3. For each character in the stream, increment its frequency in the array and add it to the queue.
     * 4. If the frequency of the character is 1, then it is a non-repeating character.
     * 5. If the frequency of the character is greater than 1, then it is a repeating character.
     * 6. If the queue is empty, then there is no non-repeating character.
     * 7. If the queue is not empty, then the first character in the queue is the first non-repeating character.
     */

     public static void printNonRepeating(String str){
        //Create an array to store the frequency of each character.
        int frequency[] = new int[26];

        //Create a queue to store the characters in the stream.
        Queue<Character> q = new LinkedList<>();

        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            q.add(ch);
            frequency[ch - 'a']++;

            while(!q.isEmpty() && frequency[q.peek() - 'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }
            else{
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
     }
    public static void main(String[] args){
        String stream = "aabccxb";
        printNonRepeating(stream);
        //Output : a -1 b b b b x
        
        
        

    }
}
