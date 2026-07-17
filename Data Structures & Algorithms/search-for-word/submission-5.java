class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int p = 0;
        boolean[][] visited;
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                visited = new boolean[rows][cols];
                if (dfs(i, j, board, p, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // A B C E
    // S F E S
    // A D E E

    private boolean dfs(int r, int c, char[][] board, int p, String word, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }
        if (visited[r][c] || word.charAt(p) != board[r][c]) {
            return false;
        }
        if (p == word.length()-1) {
            return true;
        }
        visited[r][c] = true;
        boolean result = dfs(r+1, c, board, p+1, word, visited) || 
                            dfs(r-1, c, board, p+1, word, visited) ||
                            dfs(r, c+1, board, p+1, word, visited) ||
                            dfs(r, c-1, board, p+1, word, visited);
        visited[r][c] = false;
        return result;
    }






































    public boolean exist2(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean result = false;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                result = result || dfs(board, i, j, word, 0, visited);
            }
        }
        return result;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int wordIndex, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j]) {
            return false;
        }
        if (board[i][j] == word.charAt(wordIndex)) {
            if (word.length() - 1 == wordIndex) {
                visited[i][j] = true;
                return true;
            }
            visited[i][j] = true;
            if (dfs(board, i, j+1, word, wordIndex+1, visited) 
                || dfs(board, i, j-1, word, wordIndex+1, visited)
                || dfs(board, i+1, j, word, wordIndex+1, visited)
                || dfs(board, i-1, j, word, wordIndex+1, visited)
            ) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}