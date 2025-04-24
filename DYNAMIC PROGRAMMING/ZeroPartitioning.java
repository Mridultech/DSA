public class ZeroPartitioning { // time complexity : O(n*capacity)
    /*
     * Also known as Minimum subset sum difference or partitioning subsets.
     * 
     * Approach : 
     * isme kya hai hame ek array diya hai aur hame usko do subsets mein partition karna hai aise ki dono subsets ka difference zero ho agar possible hai to true return kre else false.
     * 
     * solved by using knapsack approach .
     * this problem is also known as partition equal subset sum problem.
     */

     public static boolean isZeroPartition(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i = 0 ; i < arr.length; i++){
            sum += arr[i];
        }

        int capacity = sum/2; // kyuki hame do subsets mein partition karna hai toh dono ka sum half ho jayega.

        int dp[][] = new int[n+1][capacity+1]; // dp array ko initialize karte hain.

        // Agar sum odd hai, toh directly false return karein
        if (sum % 2 != 0) {
            return false;
        }

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
        return sum1 == capacity; // dono subsets ka difference.
     }
    public static void main(String[] args) {
        int nums[] = {1, 6, 11, 5};
        int nums2[] = {1, 2, 3};
        System.out.println("Minimum partitioning is : " + isZeroPartition(nums2)); // 1, 2 and 3
        System.out.println("Minimum partitioning is : " + isZeroPartition(nums)); // 1, 5, 6 and 11, 5
    }
}