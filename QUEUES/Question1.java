import java.util.*;
public class Question1 { // time complexity : O(n) , space complexity : O(n)

    /*
     * Problem statement : Interleave 2 halves of a queue given that length of queue is even.
     * hindi : queue ko 2 hisson me baant do aur unhe interleave(pehle half ka 1 element then dusre ka pehla then pehle ka 2nd .. so on) kar do.
     * Input : 1 2 3 4 5 6 7 8
     * Output : 1 5 2 6 3 7 4 8
     * 
     * approach : 
     * 1. find the size of queue and half of it.
     * 
     */

     public static void interLeave(Queue<Integer> q){
        Queue<Integer> firsthalf = new LinkedList<>();
        int size = q.size();
        int half = size/2;

        for(int i = 0 ; i < half ; i++){
            firsthalf.add(q.remove());
        }

        while(!firsthalf.isEmpty()){
            q.add(firsthalf.remove());
            q.add(q.remove());
        }
     }
    public static void main(String[] args){

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        
       interLeave(q);

       while(!q.isEmpty()){
        System.out.print(q.remove() + " "); 
       }
       System.out.println();
    }
}
