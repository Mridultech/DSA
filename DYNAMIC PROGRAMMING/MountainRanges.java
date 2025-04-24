public class MountainRanges {

    /*
     * also called as Mountain and valleys
     * Note : At any moment number of down strokes must not exceed number of up strokes.
     * isme simply for n number catalan of n ways of mountain ranges are possible.
     */

    // time complexity : O(n^2) : same as that of catalan number
    // space complexity : O(n) : same as that of catalan number
    public static int mountainRanges(int n) {
        int dp[] = new int[n + 1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // i pairs -> mountain ranges
            for (int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i - j - 1];
                dp[i] += inside * outside;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Mountain ranges for n = " + n + " is : " + mountainRanges(n));
    }
}