class Solution {
    public boolean exist(char[][] board, String word) {
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