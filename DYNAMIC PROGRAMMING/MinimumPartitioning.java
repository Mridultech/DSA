public class MinimumPartitioning { // time complexity : O(n*capacity)
    /*
     * Also known as Minimum subset sum difference or partitioning subsets.
     * 
     * Approach : 
     * isme kya hai hame ek array diya hai aur hame usko do subsets mein partition karna hai aise ki dono subsets ka sum minimum ho.
     * 
     * solved by using knapsack approach .
     */

     public static int minimumPartition(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i = 0 ; i < arr.length; i++){
            sum += arr[i];
        }

        int capacity = sum/2; // kyuki hame do subsets mein partition karna hai toh dono ka sum half ho jayega.

        int dp[][] = new int[n+1][capacity+1]; // dp array ko initialize karte hain.

        //bottom up 
        for(int i = 1 ; i < n+1; i++){
            for(int j = 1 ; j < capacity + 1 ; j++){
                if(arr[i-1] <= j){
                    dp[i][j]= Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]); // agar current element ko include karte hain toh uska sum aur previous element ka sum.
                   
                }
                else {
                    dp[i][j] = dp[i-1][j]; // agar current element ko include nahi karte hain toh previous element ka sum.
                }
            }
        }
        int sum1 = dp[n][capacity]; // maximum sum of subset 1.
        int sum2 = sum - sum1; // maximum sum of subset 2.
        return Math.abs(sum1 - sum2); // dono subsets ka difference.
     }
    public static void main(String[] args) {
        int nums[] = {1, 6, 11, 5};
        System.out.println("Minimum partitioning is : " + minimumPartition(nums)); // 1, 5, 6 and 11, 5
    }
}