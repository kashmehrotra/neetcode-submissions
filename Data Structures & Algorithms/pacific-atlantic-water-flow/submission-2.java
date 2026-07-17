class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        // straight
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (i == 0 || j == 0) {
                    pacific[i][j] = true;
                    continue;
                }
                if (pacific[i-1][j] && heights[i-1][j] <= heights[i][j]) {
                    pacific[i][j] = true;
                }
                if (pacific[i][j-1] && heights[i][j-1] <= heights[i][j]) {
                    pacific[i][j] = true;
                }
                if (i<m-1 && pacific[i+1][j] && heights[i+1][j] <= heights[i][j]) {
                    pacific[i][j] = true;
                }
                if (j<n-1 && pacific[i][j+1] && heights[i][j+1] <= heights[i][j]) {
                    pacific[i][j] = true;
                }
            }
        }
        for (int i=m-1;i>=0;i--) {
            for (int j=n-1;j>=0;j--) {
                if (i == m-1 || j == n-1) {
                    atlantic[i][j] = true;
                    continue;
                }
                if (atlantic[i+1][j] && heights[i+1][j] <= heights[i][j]) {
                    atlantic[i][j] = true;
                }
                if (atlantic[i][j+1] && heights[i][j+1] <= heights[i][j]) {
                    atlantic[i][j] = true;
                }
                if (i>0 && atlantic[i-1][j] && heights[i-1][j] <= heights[i][j]) {
                    atlantic[i][j] = true;
                }
                if (j>0 && atlantic[i][j-1] && heights[i][j-1] <= heights[i][j]) {
                    atlantic[i][j] = true;
                }
            }
        }

        // reverse
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (i>0 && atlantic[i-1][j] && heights[i-1][j] <= heights[i][j]) {
                    atlantic[i][j] = true;
                }
                if (j>0 && atlantic[i][j-1] && heights[i][j-1] <= heights[i][j]) {
                    atlantic[i][j] = true;
                }
                if (i<m-1 && atlantic[i+1][j] && heights[i+1][j] <= heights[i][j]) {
                    atlantic[i][j] = true;
                }
                if (j<n-1 && atlantic[i][j+1] && heights[i][j+1] <= heights[i][j]) {
                    atlantic[i][j] = true;
                }
            }
        }
        for (int i=m-1;i>=0;i--) {
            for (int j=n-1;j>=0;j--) {
                if (i<m-1 && pacific[i+1][j] && heights[i+1][j] <= heights[i][j]) {
                    pacific[i][j] = true;
                }
                if (j<n-1 && pacific[i][j+1] && heights[i][j+1] <= heights[i][j]) {
                    pacific[i][j] = true;
                }
                if (i>0 && pacific[i-1][j] && heights[i-1][j] <= heights[i][j]) {
                    pacific[i][j] = true;
                }
                if (j>0 && pacific[i][j-1] && heights[i][j-1] <= heights[i][j]) {
                    pacific[i][j] = true;
                }
            }
        }

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    //  1  2  3  4
    // 12 13 14  5
    // 11 16 15  6
    // 10  9  8  7
}
