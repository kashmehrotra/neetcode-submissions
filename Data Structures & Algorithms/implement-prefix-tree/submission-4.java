class PrefixTree {

    Node rootNode;

    class Node {
        Node[] next;
        boolean isEnd;

        Node() {
            this.next = new Node[26];
            for (int i=0;i<26;i++) {
                this.next[i] = null;
            }
            this.isEnd = false;
        }
    }

    public PrefixTree() {
        this.rootNode = new Node();
    }

    public void insert(String word) {
        Node node = rootNode;
        for (Character ch : word.toCharArray()) {
            if (node.next[ch-'a'] == null) {
                node.next[ch-'a'] = new Node();
            }
            node = node.next[ch-'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = rootNode;
        for (Character ch : word.toCharArray()) {
            if (node.next[ch-'a'] == null) {
                return false;
            }
            node = node.next[ch-'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = rootNode;
        for (Character ch : prefix.toCharArray()) {
            if (node.next[ch-'a'] == null) {
                return false;
            }
            node = node.next[ch-'a'];
        }
        return true;
    }
}
