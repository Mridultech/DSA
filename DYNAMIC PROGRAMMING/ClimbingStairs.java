import java.util.*;
public class ClimbingStairs { // memoization - O(n) && recursion - O(2^n)   

    /*
     * Climing Stairs Problem
     * Count ways to reach the nth stair. The person can climb either 1 stair or 2 stair at a time.
     * Recurrence relation:
     * ways(n) = ways(n-1) + ways(n-2)
     * kya logic hai : agar ham 3rd stair ke tarike nikal le to keval sbme 2 add krke 5 tak pahuch jayenge.
     * and agar ham 4th stair ke tarike nikal le to keval sbme 1 add krke 5 tak pahuch jayenge.
     * or in dono ko add krke total 5 tak pahuch jane ke tarike milenge.
     * 
     * Note : Due to dynamic programming, skewed tree banta hai instead of binary tree.
     * So, we can use memoization to store the values of the function calls in an array.
     */

    public static int countWays(int n, int ways[]){
        // Base case
        if(n == 0 || n == 1){
            return 1;
        }
        // Boundary case
        if(n < 0){
            return 0;
        }
        if(ways[n] != -1){
            return ways[n]; // Return the stored value if it has already been calculated
        }
        // Recursive case
        // ways[n] = countWays(n-1,ways) + countWays(n-2,ways); 
        // agar question ki variation aajaye jisme 3 stairs ya 4 stairs bhi uthne ki permission ho to usme ham isko aise likh sakte hai:
        ways[n] = countWays(n-1,ways) + countWays(n-2,ways) + countWays(n-3,ways);
        // for n stairs,
        // ways[n] = countWays(n-1,ways) + countWays(n-2,ways) + countWays(n-3,ways) + ... + countWays(0,ways);
        return ways[n];
    }
    /*
     * For tabulation : 
     * step 1 : create table and initalize it .
     * step 2 : meaning for every index of table.
     * step 3 : Fill the table in bottom up manner , i.e smaller to larger problems.
     * 
     * agar n variables change hote hai to n dimensional storage bnana hai.
     * 
     * yaha keval ek n change ho rha hai to single dimensional array banayenge dp naam se 0 se n index tak.
     * 
     * ith index = ways to reach ith stair
     */

    public static int countWaysTabulation(int n, int dp[]){
        dp[0] = 1;

        for(int i = 1 ; i <= n; i++){ // yaha pe keval 1 ya 2 stair climbing allowed hai for single turn.
            if(i == 1){
                dp[i] = dp[i-1] + 0;
            }
            else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args){
        int n = 5; // Number of stairs
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1); // Initialize the array with -1 to indicate that the value has not been calculated yet
        System.out.println("Number of ways to reach the " + n + "th stair: " + countWays(n,ways));

        int dp[] = new int[n+1];
        System.out.print("Number of ways to reach " + n + "th stair is : " + countWaysTabulation(n,dp));
    }
}
