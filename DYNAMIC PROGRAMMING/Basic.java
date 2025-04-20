public class Basic {

    /*
     * Dynamic programming : 
     * - A method for solving complex problems by breaking them down into simpler subproblems.
     * - By this we can improve the complexity of the problem.
     * By applying dynamic programming, we can avoid the repeated calculation of the same subproblems.
     * ex : in recursion tree of factorial we're calculating the same subproblems again and again.
     * This concept is also known as memoization.
     * Memoization is a technique where we store the results of expensive function calls and reuse them when the same inputs occur again.
     * This can significantly reduce the time complexity of the algorithm.
     * 
     * Dynamic programming is optimized recursion 
     * 
     * Identification for dynamic programming:
     * 1. Optimal Problem : problems in which the optimal solution can be constructed from optimal solutions of its subproblems.
     * 2. Some choice is given : problems in which we have to make some choices to get the optimal solution.
     * 
     * Dynamic Programming is a technique in computer programming that helps to efficiently solve a class of problems that have overlapping subproblems and optimal substructure property.
     * overlapping subproblems means that the problem can be broken down into smaller subproblems which are reused several times.
     * optimal substructure means that the optimal solution to the problem can be constructed from the optimal solutions of its subproblems.
     * 
     * Note : Greedy approach is also a technique in computer programming that helps to efficiently solve a class of optimal problems.
     * 
     * 
     */

    // Example: Fibonacci series

    public static int fib(int n, int[] dp) { // yaha time complexity O(n) ho jayegi or simple recursion me O(2^n) ho jayegi.
        // Base case
        if (n == 1 || n == 0) {
            return n;
        }
        // Check if the value is already computed
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] =  fib(n - 1,dp) + fib(n - 2,dp);
        return dp[n];
    }
    public static void main(String[] args){
        int n = 5;
        int[] dp = new int[n+1];
        System.out.println("Fibonacci of " + n + " is : " + fib(5, dp));
    }
}