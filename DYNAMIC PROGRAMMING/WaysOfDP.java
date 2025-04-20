public class WaysOfDP {

    //Tip by didi : Perseverance is the key to success.Never get down and always fight till victory.

    /*
     * Ways of Dynamic Programming
     * 
     * 1. Memoization (Top Down Approach)
     * 
     * step 1 : recursion ka program likhdo
     * step 2 : subproblems ko store karane ke liye storage banalo jisse badme bina calculate kre hue reuse kar sake.
     * 
     * 2. Tabulation (Bottom Up Approach) [efficient]
     * 
     * Note : Jo problems iteration se solve ho skti hai wo sb recursion se bhi ho skti hai and vice versa.
     * 
     * isme ham recursion ki bajaye iteration se solve karte hai.
     * step 1 : storage create kar lo.
     * step 2 : iteration se solve kar lo.
     */

     public static int fibTabulation(int n)
{
    int dp[] = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2 ; i <= n ; i++){
        dp[i] = dp[i-1] + dp[i-2]; 
    }

    return dp[n];
}
    public static void main(String[] args){
        int n = 5 ;
        System.out.println(fibTabulation(n));
    }
}