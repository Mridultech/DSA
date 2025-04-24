import java.util.*;
public class MinimumArrayJumps {

    /*
     * Problem Statement: Given an array of non-negative integers, where each element represents the maximum number of steps that can be jumped going forward from that element. The goal is to reach the last index in the minimum number of jumps.
     * If not possible to reach the end, return -1.
     */

    public static int minimumJumps(int nums[]){
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1); // dp array ko -1 se fill karenge.
        dp[n-1] = 0; // last index par 0 jumps lagenge kyuki wahi par hain.

        for(int i = n-2 ; i >= 0 ; i--){
            int steps = nums[i]; // i index par kitne steps hain.
            int ans = Integer.MAX_VALUE; // minimum jumps ko store karne ke liye.
            for(int j = i+1; j <= i+steps && j < n ; j++){
                if(dp[j] != -1){
                    ans = Math.min(ans, dp[j] + 1); //ans and dp[j] and +1 kyuki ek step leke hi dp[j] par pahunch rahe hain.
                }
            }
            if(ans != Integer.MAX_VALUE){ // agar ans ko update kiya hai toh dp[i] mein store karenge.
                dp[i] = ans;
            }
        }
        return dp[0]; // 0th index par minimum jumps lagenge.
    }
    public static void main(String[] args){
        int nums[] = {2,3,1,1,4};
        System.out.println("Minimum jumps required to reach end of array is : " + minimumJumps(nums)); // 2 jumps lagenge kyuki 2 se 3 par jump karenge aur phir 3 se 4 par jump karenge. 
    }
}
