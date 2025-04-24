public class WildcardMatching { // Class ka naam, jisme pura logic likha gaya hai

    public static boolean isMatch(String s, String p) { // isMatch function, jo string 's' ko pattern 'p' ke sath match karega
        int n = s.length(); // input string 's' ki length store ki
        int m = p.length(); // pattern 'p' ki length store ki

        boolean dp[][] = new boolean[n + 1][m + 1]; // Dynamic Programming table banayi: dp[i][j] true hoga agar s ka i part, p ke j part se match karta hai
        dp[0][0] = true; // Empty string with empty pattern match karta hai, to pehla cell true hai

        // Agar pattern empty hai aur string mein characters hain, to obviously match nahi hoga
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false; // s ke characters hai par pattern empty hai = mismatch
        }

        // Jab string empty ho (s = ""), lekin pattern mein shayad "*" ho sakte hain jo empty string se match karte hain
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') { // agar pattern ka current character '*'
                dp[0][j] = dp[0][j - 1]; // '*' previous wale result ko carry karega, kyunki '*' empty bhi match kar sakta hai
            }
        }

        // Yahan se actual DP table fill karna start kar rahe hain
        for (int i = 1; i < n + 1; i++) { // string ke characters par loop
            for (int j = 1; j < m + 1; j++) { // pattern ke characters par loop
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    // agar current characters same hain ya pattern mein '?' hai (jo kisi bhi single character se match karta hai)
                    dp[i][j] = dp[i - 1][j - 1]; // to diagonally previous value copy karo
                } else if (p.charAt(j - 1) == '*') {
                    // agar pattern ka character '*'
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; 
                    // '*' ya to current character ko consume kare (dp[i-1][j]) ya ignore kare (dp[i][j-1])
                } else {
                    dp[i][j] = false; // agar koi match nahi bana, to obviously false
                }
            }
        }

        return dp[n][m]; // poori string aur poora pattern match karta hai ya nahi, ye final answer return hoga
    }

    public static void main(String[] args) {
        String s = "baaaabab"; // input string
        String p = "ba**abc"; // pattern jisme wildcard characters hai (*, ?)
        System.out.println(isMatch(s, p)); // match function ko call karke output print karo
    }
}
