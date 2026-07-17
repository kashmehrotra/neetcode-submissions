class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for (int i=0;i<rows;i++) {
            dfs(i, 0, pacific, heights);
            dfs(i, cols-1, atlantic, heights);
        }
        for (int i=0;i<cols;i++) {
            dfs(0, i, pacific, heights);
            dfs(rows-1, i, atlantic, heights);
        }
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, boolean[][] ocean, int[][] heights) {
        ocean[row][col] = true;
        for (int[] dir: directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if (nr >=0 && nr < heights.length &&
                nc >= 0 && nc < heights[0].length && 
                !ocean[nr][nc] && heights[row][col] <= heights[nr][nc]) {
                dfs(nr, nc, ocean, heights);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic2(int[][] heights) {
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
}
