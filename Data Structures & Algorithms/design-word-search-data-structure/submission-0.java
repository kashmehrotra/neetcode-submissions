class WordDictionary {

    Node rootNode;

    class Node {
        Node[] next;
        boolean isDone;

        Node() {
            this.next = new Node[26];
            for (int i=0;i<26;i++) {
                this.next[i] = null;
            }
            this.isDone = false;
        }
    }

    public WordDictionary() {
        this.rootNode = new Node();
    }

    public void addWord(String word) {
        Node node = this.rootNode;
        for (Character ch : word.toCharArray()) {
            if (node.next[ch-'a'] == null) {
                node.next[ch-'a'] = new Node();
            }
            node = node.next[ch-'a'];
        }
        node.isDone = true;
    }

    public boolean search(String word) {
        Node node = this.rootNode;
        return searchWord(word, 0, node);
    }

    private boolean searchWord(String word, int m, Node node) {
        if (word.length() == m) {
            return node.isDone;
        }
        boolean found = false;
        if (word.charAt(m) == '.') {
            for (int i=0;i<26;i++) {
                if (!found && node.next[i] != null) {
                    found = node.isDone || searchWord(word, m+1, node.next[i]);
                    if (found) {
                        return found;
                    }
                }
            }
            return found;
        }
        if (node.next[word.charAt(m)-'a'] != null) {
            found = searchWord(word, m+1, node.next[word.charAt(m)-'a']);
        }
        return found;
    }
}
