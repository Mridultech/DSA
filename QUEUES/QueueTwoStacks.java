import java.util.*;
public class QueueTwoStacks {

    /*
     * Implementation of queue using two stacks.
     * sab same hai bas add ka process thoda alag hai.
     * add() method is O(n) and remove() method is O(1).
     * for adding : 
     * 1. pop all elements from stack1 and push them to stack2.
     * 2. push the new element to stack1.
     * 3. pop all elements from stack2 and push them to stack1.
     */ 
    
        static class Queue {

            static Stack<Integer> stack1 = new Stack<>();

            static Stack<Integer> stack2 = new Stack<>();
            
            public static boolean isEmpty() {
                return stack1.isEmpty();            
            }

            //add 

            public static void add(int data){ //O(n)
                //step 1
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop()); // pop all elements from stack1 and push them to stack2.
                }
                //step 2
                stack1.push(data); // push the new element to stack1.
                //step 3
                while(!stack2.isEmpty()){
                    stack1.push(stack2.pop()); // pop all elements from stack2 and push them to stack1.
                }
            }

            //remove

            public static int remove() { // O(1)
                if(isEmpty()){
                    System.out.println("Queue is empty");
                    return -1;
                }

                return stack1.pop(); // remove the top element from stack1 and return it as it's front element.
            }

            //peek

            public static int peek() { // O(1)
                if(isEmpty()){
                    System.out.println("Queue is empty");
                    return -1;
                }

                return stack1.peek(); // return the top element from stack1 without removing it as it's front element.
            }
        }


    
    public static void main(String[] args){
        Queue q = new Queue(); // Create a queue using two stacks
        // Add elements to the queue
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek()); // peek() returns the front element of the queue without removing it.
            q.remove(); // remove() removes the front element of the queue.
        }
    }
}
