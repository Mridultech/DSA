import java.util.*;
public class QueueReversal {

    /*
     * problem statement : 
     * Given a queue, reverse it.
     * ex : Input: 1 2 3 4 5
     * Output: 5 4 3 2 1
     * 
     * Approach:
     * 1. Create a stack and push all the elements of the queue into the stack.
     * 2. Pop all the elements from the stack and push them back into the queue.
     * 3. The queue is now reversed.
     */

    public static void queueReversal(Queue<Integer> q){
        
        //pehle stack banayenge

        Stack<Integer> s = new Stack<>(); 

        //queue ke elements ko stack me daalenge

        while(!q.isEmpty()){
            s.push(q.remove());
        }

        //stack ke elements ko queue me daalenge

        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();

        // queue me elements daalenge
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);

        queueReversal(q);

        // queue ke elements ko print karayenge 

        System.out.println("Reversed Queue: ");
        
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
