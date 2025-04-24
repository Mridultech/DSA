// Counting Trees using Catalan Numbers
// Time Complexity: O(n^2)

public class CountingTrees {
    /*
     * The number of unique BSTs that can be formed with n distinct nodes is given by the nth Catalan number.
     * The formula for the nth Catalan number is:
     * C(n) = (2n)! / ((n + 1)! * n!)
     */
    
    public static int countBST(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int left = dp[j];
                int right = dp[i - j - 1];
                dp[i] += left * right;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Number of BSTs for " + n + " nodes will be: " + countBST(n));
    }
}