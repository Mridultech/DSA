import java.util.*;
public class StackTwoQueues {

    /*
     * Implement a stack using two queues.
     */

    static class Stack{

        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        // Method 1 : for push : O(1) , pop : O(n) , peek : O(n)

        // // to check if the stack is empty
        // public static boolean isEmpty(){
        //     return q1.isEmpty() && q2.isEmpty();
        // }

        // //push 

        // public static void push(int data) { // O(1)
        //     if(!q1.isEmpty()){
        //         q1.add(data);
        //     }else{
        //         q2.add(data);
        //     }
        // }

        // //pop

        // public static int pop(){ // O(n)
        //     if(isEmpty()){
        //         System.out.println("Empty Stack!");
        //         return -1;
        //     }
        //     int top = -1;

        //     //case 1 

        //     if(!q1.isEmpty()){
        //         while(!q1.isEmpty()){
        //             top = q1.poll();
        //             if(q1.isEmpty()){
        //                 break;
        //             }
        //             q2.add(top);
        //         }
        //     }

        //     //case 2

        //     else{ 
        //         while(!q2.isEmpty()){
        //             top = q2.remove();
        //             if(q2.isEmpty()){
        //                 break;
        //             }
        //             q1.add(top);
        //         }
        //     }

        //     return top;

        // }

        // public static int  peek(){ // O(n)
        //     if(isEmpty()){
        //         System.out.println("Empty Stack!");
        //         return -1;
        //     }

        //     int top = -1;

        //      //case 1 

        //      if(!q1.isEmpty()){
        //         while(!q1.isEmpty()){
        //             top = q1.poll();
        //             q2.add(top);
        //         }
        //     }

        //     //case 2

        //     else{ 
        //         while(!q2.isEmpty()){
        //             top = q2.remove();
                    
        //             q1.add(top);
        //         }
        //     }

        //     return top;
        // }

        // Method 2 : for push : O(n) , pop : O(1) , peek : O(1)

        // to check if the stack is empty
        

    }
        public static void main(String[] args){
            Stack s = new Stack();
            
            s.push(1);
            s.push(2);
            s.push(3);

            while(!s.isEmpty()){
                System.out.println(s.peek());
                s.pop();
            }
    }
}
