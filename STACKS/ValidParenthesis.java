import java.util.*;
public class ValidParenthesis {
    /*
     * Problem statement : Given a string s containing just the characters '(',')','[',']','{','}', return true if the input string is valid.
     * A string is valid if:
     * 1. Open brackets must be closed by the same type of brackets.
     * 2. Open brackets must be closed in the correct order.
     * 3. Every close bracket has a corresponding open bracket of the same type.
     * 
     * expression mein har open bracket ka close bracket hona chahiye.
     * correct order mein ho and same type ka hona chahiye.
     * 
     * approach : ek stack bnayenge 
     * 1. jab bhi open bracket aaye ga toh usko stack mein push karenge.
     * 2. jab bhi close bracket aaye to use stack ke top (last pushed open bracket) se compare krenge agar pair bana to stack se pop karenge.
     * 3. agar pair nahi bana toh return false.
     * then at last jab expression complete ho jae to stack empty hona chahiye.
     * 4. agar stack empty hai toh return true.
     * 5. agar stack empty nahi hai toh return false.
     * 
     */

     public static boolean isValid(String str){
            //pehle ek stack banayenge 
            Stack<Character> s = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            //step 1 // checking for opening brackets
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }else{
                //closing
                //condition 1 : agar stack khali ho jaye
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
     }
    public static void main(String[] args) {
        String str = "({[()]}[])}";
        System.out.println(isValid(str));
    }
}
