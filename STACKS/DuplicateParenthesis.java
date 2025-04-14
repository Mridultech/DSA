import java.util.*;
public class DuplicateParenthesis { // time complexity : O(n) and space complexity : O(n)
    
    /*
     * Problem statement : Given a valid expression, check for duplicate parenthesis in it.
     * For example, the expression ((a+b)) has duplicate parenthesis.
     * The expression (a+b) has no duplicate parenthesis.
     * Duplicate parenthesis means that there are two or more pairs of redundant parentheses that are not needed.
     * 
     * approach : 
     * 1. Create a stack to store the characters of the expression.
     * 2. Traverse the expression from left to right.
     * 3. If the character is an opening parenthesis or any operator, push it onto the stack.
     * 4. Then we take counter variable to count the number of characters between the opening and closing parenthesis.
     * 5. If the character is a closing parenthesis, pop the stack until we find the matching opening parenthesis.
     * 6. If the counter variable is 0, then we have found duplicate parenthesis. => matlab bichme kuch nahi tha or brackets redundant the.
     * 7. If the counter variable is greater than 0, then we have found a valid expression.
     */

    public static boolean isDuplicate(String str){
        // pehle stack bnayenge 
        Stack<Character> s = new Stack<>();

        for(int i = 0 ; i < str.length(); i ++){
            char ch = str.charAt(i);

            // closing parenthesis
            if(ch == ')'){
                int count = 0;
                while(s.pop() != '('){
                    count++;
                }
                if(count<1){
                    return true; //duplicate 
                }
            }else{
                //opening
                s.push(ch);
            }
        
        }
        return false;
    }
    public static void main(String[] args){
        String str = "((a+b))"; // duplicate parenthesis
        String str2 = "(a+b)"; // no duplicate parenthesis
        System.out.println(isDuplicate(str));
        System.out.println(isDuplicate(str2));

    }
}
