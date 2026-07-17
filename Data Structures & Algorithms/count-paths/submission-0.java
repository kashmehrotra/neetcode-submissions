class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        return count(dp, m-1, n-1);
    }

    private int count(int[][] dp, int row, int col) {
        if (row < 0 || col < 0) {
            return 0;
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        if (row == 0 || col == 0) {
            return 1;
        }
        dp[row][col] = count(dp, row-1, col) + count(dp, row, col-1);
        return dp[row][col];
    }
}