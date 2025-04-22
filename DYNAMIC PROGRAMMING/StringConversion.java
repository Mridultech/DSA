public class StringConversion {

    // Function to calculate LCS
    public static int LCS(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void stringConversion(String str1, String str2) {
        int lcsLength = LCS(str1, str2);
        int deletions = str1.length() - lcsLength;
        int insertions = str2.length() - lcsLength;

        System.out.println("Minimum operations required for conversion:");
        System.out.println("Deletions: " + deletions);
        System.out.println("Insertions: " + insertions);
    }

    public static void main(String[] args) {
        String word1 = "abcdef";
        String word2 = "aceg";
        stringConversion(word1, word2);
    }
}
