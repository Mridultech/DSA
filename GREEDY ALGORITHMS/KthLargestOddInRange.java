import java.util.*;
public class KthLargestOddInRange{


    /*
     * Problem statement : We have two variables L and R indicating a range of integers. We need to find the Kth largest odd number in the range [L, R].
     * if k > number of odd numbers in the range, return -1.
     * Example : L = 1, R = 10, K = 3 => output : 5
     * 
     * approach : 
     * 1. Find the number of odd numbers in the range [L, R].
     * 2. If K > number of odd numbers in the range, return -1.
     * 3. Now, if k <= range then, 
     * find all odd in range
     * 4. Sort the odd numbers in descending order.
     * 5. Return the Kth largest odd number.
     * 
     */

    public static int kthLargestOddInRange(int l , int r , int k){
        //1 . find number of odd numbers within range 
        
        ArrayList<Integer> odd = new ArrayList<>();
        int count = 0; // Declare and initialize count
        for(int i = l ; i <= r ; i++){
            if(i % 2 != 0){
                odd.add(i);
                count++;
            }
        } 
        // 2. checking 

        if(k > count){
            return -1;
        }
        else{
            Collections.sort(odd, Collections.reverseOrder());
            int finalOdd = odd.get(k - 1);
            return finalOdd;
        }
    }
    public static void main(String[] args){
        int l = 1 , r = 10, k = 2;
        int result = kthLargestOddInRange(l, r, k);
        System.out.println("The " + k + "th largest odd number in the range [" + l + ", " + r + "] is: " + result);
    }
}