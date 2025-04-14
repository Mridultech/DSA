import java.util.*;
public class NRopesMinimumCost {

    /*
     * Problem statement : Given are N ropes of different lengths, the task is to connect these ropes into one rope with
       minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.
     * 
     * Isme hame n ropes ki length ki ek array di hai ab hame us array ki total cost nikalni hai or ham keval 2 ropes ki length ko hi ek bari mein add kr skte hai . 
     * sum of two ropes = sum of their respective lengths.
     * here we'll use concept of priority queue.
     * 
     * approach :
     * 1. Create a priority queue to store the lengths of the ropes.
     * 2. Add all the lengths to the priority queue.
     * 3. While there are more than one rope left:
     *  a. Remove the two smallest ropes from the priority queue.
     *  b. Calculate the cost of connecting them (sum of their lengths).
     *  c. Add the cost to the total cost.
     *  d. Add the new rope back to the priority queue.
     * 4. Return the total cost.
     * 
     * example:
     *  Input: arr[] = {4, 3, 2, 6}
     * Output: 29
     * Explanation:
     * 1. Connect ropes of lengths 2 and 3, cost = 5
     * 2. push back 5 to the queue and total cost = 5
     * 3. Connect ropes of lengths 4 and 5, cost = 9
     * 4. push back 9 to the queue and total cost = 5 + 9 = 14
     * 5. Connect ropes of lengths 6 and 9, cost = 15
     * 6. push back 15 to the queue and total cost = 14 + 15 = 29
     * 7. Now only one rope is left in the queue, so we stop here.
     * 
     */

     public static int getMinimumCost(int arr[]){
        // Create a priority queue to store the lengths of the ropes
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all the lengths to the priority queue
        for (int length : arr) {
            pq.add(length);
        }

        int totalCost = 0;

        // While there are more than one rope left
        while (pq.size() > 1) {
            // Remove the two smallest ropes
            int first = pq.poll();
            int second = pq.poll();

            // Calculate the cost of connecting them
            int cost = first + second;
            totalCost += cost;

            // Add the new rope back to the priority queue
            pq.add(cost);
        }

        return totalCost;
     }
    public static void main(String[] args) {
      int arr[] = {4, 3, 2, 6}; // min cost = 15
      System.out.println("Minimum cost to connect ropes: " + getMinimumCost(arr));
      
      }
}
