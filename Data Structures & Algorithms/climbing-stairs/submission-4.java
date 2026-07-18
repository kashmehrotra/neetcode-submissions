class Solution {
    
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        return count(n, dp);
    }

    private int count(int n, int[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = count(n-1, dp) + count(n-2, dp);
        return dp[n];
    }
}
