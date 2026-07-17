class Solution {
    public String longestPalindrome(String s) {
        int idStart = 0, len = 0;
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for (int i=n-1;i>=0;i--) {
            for (int j=i;j<n;j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (len < j-i+1) {
                        idStart = i;
                        len = j-i;
                    }
                }
            }
        }
        return s.substring(idStart, idStart+len+1);
    }
}
