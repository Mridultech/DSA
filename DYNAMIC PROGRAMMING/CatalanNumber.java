import java.util.*;
public class CatalanNumber { 
    /*
     * Concept of Catalan Numbers:
     * 
     * Catalan numbers are a sequence of natural numbers that occur in various 
     * counting problems, often involving recursively-defined objects.
     * 
     * The nth Catalan number is given by the formula:
     * C(n) = (2n)! / ((n+1)! * n!)
     * 
     * Alternatively, it can be computed recursively as:
     * C(n) = Σ (C(i) * C(n-i-1)) for i = 0 to n-1
     * 
     * Applications of Catalan Numbers:
     * 1. Counting the number of valid parentheses expressions of length 2n.
     * 2. Counting the number of rooted binary trees with n+1 leaves.
     * 3. Counting the number of ways to triangulate a polygon with n+2 sides.
     * 4. Counting the number of paths in a grid that do not cross above the diagonal.
     * 
     * Example:
     * For n = 3:
     * C(3) = C(0)*C(2) + C(1)*C(1) + C(2)*C(0)
     *      = 1*2 + 1*1 + 2*1
     *      = 5
     * 
     * concept catalan of 0 to n-1 is being multiplied with catalan of n-1 to 0 correspondingly.
     */
    
    public static int catalanRecursion(int n){ 
        if(n == 0 || n == 1){ 
            return 1; 
        }

        int ans = 0;
        for(int i = 0 ; i <= n-1 ; i++){
            ans += catalanRecursion(i) * catalanRecursion(n-i-1);
        }

    return ans;
}

public static int catalanMemoization(int n, int dp[]){
    if(n == 0 || n == 1){
        return 1;
    }
    if(dp[n] != -1){
        return dp[n];
    }

    int ans = 0;
    for(int i = 0 ; i < n ; i++){
        ans += catalanMemoization(i,dp) * catalanMemoization(n-i-1, dp);
    }

    return dp[n] = ans;
}

public static int catalanTabulation(int n){
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;

    for(int i = 2 ; i <= n ; i++){
        for(int j = 0 ; j < i ; j++){
            dp[i] += dp[j]*dp[i-j-1];
        }
    }

    return dp[n];
}

public static void main(String[] args){
    int n = 4;
    System.out.println("Catalan number for " + n + " is: " + catalanRecursion(n));
    int dp[] = new int[n+1];
    Arrays.fill(dp, -1);
    System.out.println("Catalan number for " + n + " using memoization is: " + catalanMemoization(n, dp));
    System.out.println("Catalan number for " + n + " using tabulation is: " + catalanTabulation(n));

}

}