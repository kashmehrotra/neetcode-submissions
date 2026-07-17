class Solution {

    class Trie {
        Trie[] next = new Trie[26];
        String word;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie curr = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (curr.next[i] == null) {
                    curr.next[i] = new Trie();
                }
                curr = curr.next[i];
            }
            curr.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie root = buildTrie(words);
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, Trie curr, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '0' || curr.next[board[i][j] - 'a'] == null) {
            return;
        }
        curr = curr.next[board[i][j] - 'a'];
        if (curr.word != null) {
            res.add(curr.word);
            curr.word = null;
        }
        char original = board[i][j];
        board[i][j] = '0';
        dfs(board, i-1, j, curr, res);
        dfs(board, i, j-1, curr, res);
        dfs(board, i+1, j, curr, res);
        dfs(board, i, j+1, curr, res);
        board[i][j] = original;
    }
}