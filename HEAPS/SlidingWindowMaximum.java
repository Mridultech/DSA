import java.util.*;
public class SlidingWindowMaximum {

    /*
     * Can be best solved using deque in O(n) time complexity.
     * but here we'll solve it using priority queue In O(nlogk) time complexity.
     * concept of sliding windows is also used in computer networking and in many other fields.
     * 
     * Approach:
     * 1. add karenge k numbers priority queue me.
     * 2. phir priority quue se sabse bada number nikaalenge joki hamari pehli window ka max hoga.
     * 3. phir jab window slide hogi to priority queue se sabse bada number nikaalenge.
     *  inner process : 
     * jab tak queue khali nahi ho jati check karenge ki koi element i - k index se chota to nahi agar hai to remove krdenge
     * then current element add krdenge 
     * uske baad dobara sabse bada number nikaalenge joki current window ka max hoga.
     * 4. phir jab tak queue khali nahi ho jati check karenge ki koi element i - k index se chota to nahi agar hai to remove krdenge
     * then current element add krdenge
     * uske baad dobara sabse bada number nikaalenge joki current window ka max hoga.
     * 
     * isse hi repeat krte rhenge jab tak sari windows slide nahi ho jati. 
     */

     static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other){
            return other.value - this.value; // max heap
        }

     }
    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int rest[] = new int[arr.length - k + 1]; // n-k+1 windows banenge

        PriorityQueue<Pair> pq = new PriorityQueue<>(); // max heap

        //1st window 
        for(int i = 0 ; i < k ; i++){
            pq.add(new Pair(arr[i], i)); // add first k elements to the priority queue
        }

        rest[0] = pq.peek().value; // get the max of the first window

        // slide the window
        for(int i = k ; i < arr.length ; i++){
            while(pq.size() > 0 && pq.peek().index <= i - k){
                pq.poll(); // remove elements that are out of the current window
            }
            pq.add(new Pair(arr[i], i)); // add the current element to the priority queue
            rest[i - k + 1] = pq.peek().value; // get the max of the current window
        }

        // print the result
        for(int i = 0 ; i < rest.length ; i++){
            System.out.print(rest[i] + " ");
        } 
    }   
}
