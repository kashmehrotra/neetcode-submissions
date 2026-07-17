class PrefixTree {

    Node rootNode;

    class Node {
        Node[] children = new Node[26];
        boolean isEnd;

        Node() {
            for (int i=0;i<26;i++) {
                this.children[i] = null;
            }
            this.isEnd = false;
        }
    }

    public PrefixTree() {
         rootNode = new Node();
    }

    public void insert(String word) {
        Node current = rootNode;
        for (char ch : word.toCharArray()) {
            if (current.children[ch-'a'] == null) {
                current.children[ch-'a'] = new Node();
            }
            current = current.children[ch-'a'];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        Node current = rootNode;
        for (char ch : word.toCharArray()) {
            if (current.children[ch-'a'] == null) {
                return false;
            }
            current = current.children[ch-'a'];
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node current = rootNode;
        for (char ch : prefix.toCharArray()) {
            if (current.children[ch-'a'] == null) {
                return false;
            }
            current = current.children[ch-'a'];
        }
        return true;
    }
}
