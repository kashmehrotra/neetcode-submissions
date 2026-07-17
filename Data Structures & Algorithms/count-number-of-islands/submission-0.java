class Solution {
    
    public int numIslands(char[][] grid) {
        int total = 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    total++;
                }
            }
        }
        return total;
    }

    private void helper(char[][] grid, int curri, int currj) {
        if (curri < 0 || currj < 0 || curri > grid.length-1 || currj > grid[0].length-1) {
            return;
        }
        if (grid[curri][currj] == '0') {
            return;
        }
        grid[curri][currj] = '0';
        helper(grid, curri, currj+1);
        helper(grid, curri+1, currj);
        helper(grid, curri, currj-1);
        helper(grid, curri-1, currj);
    }
}