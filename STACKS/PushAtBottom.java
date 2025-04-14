import java.util.*;
public class PushAtBottom {

    public static void pushAtBottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data); // age ke values pe process krne ke liye
        s.push(top);
    }
    public static void main(String[] args){
        //Problem statement : ek given value ko stack ke bottom mein push krna hai baki stack upar normal hi rhega operationally as well as structural.
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s,4);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
} 
