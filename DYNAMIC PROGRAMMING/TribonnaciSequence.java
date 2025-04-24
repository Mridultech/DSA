import java.util.*;

public class TribonnaciSequence {

    /*
     * Problem statement: Given the integer n, return the nth Tribonacci number.
     * 
     * The Tribonacci series is a generalization of the Fibonacci sequence where each term is the sum
     * of the three preceding terms.
     * 
     * a(n) = a(n-1) + a(n-2) + a(n-3) with a(0) = a(1) = 0, a(2) = 1.
     * 
     * Example:
     * Input : 5
     * Output : 0, 0, 1, 1, 2
     * 
     * Input : 10
     * Output : 0, 0, 1, 1, 2, 4, 7, 13, 24, 44
     * 
     * Input : 20
     * Output : 0, 0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513     
     */

    // Function to print the full Tribonacci sequence up to nth term
    public static void printFullTribonacci(int n) {
        if (n <= 0) {
            System.out.println("Invalid input. n must be greater than 0.");
            return;
        }

        int[] dp = new int[n];  // dp[i] will hold the ith Tribonacci number

        // Initialization of first three terms of Tribonacci sequence
        dp[0] = dp[1] = 0;
        if (n > 2) dp[2] = 1;

        // Fill the rest of the dp array using the recurrence relation
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // Print the full sequence
        System.out.print("Full Tribonacci sequence up to n = " + n + " : ");
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + (i < n - 1 ? ", " : ""));
        }
        System.out.println();
    }

    // Function to return the nth Tribonacci number
    public static int tribonacciMemoization(int n) {
        // Handling base cases directly
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;

        int[] dp = new int[n];  // Array to store intermediate tribonacci results

        // Initialization of dp array
        dp[0] = dp[1] = 0;
        dp[2] = 1;

        // Compute each value from bottom up using previously computed values
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n - 1];  // Return the nth tribonacci number (0-based indexing)
    }

    public static void main(String[] args) {
        int n = 10; // Input: Position of Tribonacci number

        // First, print the full Tribonacci sequence
        printFullTribonacci(n);

        // Then, print only the nth Tribonacci number
        System.out.println("Tribonacci number at position " + n + " is: " + tribonacciMemoization(n));
    }
}
