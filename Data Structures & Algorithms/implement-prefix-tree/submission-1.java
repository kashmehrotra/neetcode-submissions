class PrefixTree {

    Node rootNode;

    class Node {
        char ch;
        Node[] children = new Node[26];
        boolean isEnd;

        Node() {}

        Node(char ch) {
            this.ch = ch;
            for (int i=0;i<26;i++) {
                this.children[i] = null;
            }
            this.isEnd = false;
        }
    }

    public PrefixTree() {
         rootNode = new Node('*');
    }

    public void insert(String word) {
        Node current = rootNode;
        for (char ch : word.toCharArray()) {
            if (current.children[ch-'a'] == null) {
                current.children[ch-'a'] = new Node(ch);
            }
            current = current.children[ch-'a'];
        }
        current.isEnd = true;
        // print();
    }

    private void print() {
        Node current = rootNode;
        for (int i=0;i<5;i++) {
            System.out.println(current.ch);
            for (int j=0;j<26;j++) {
                // System.out.print(current.children[j] + " n ");
                if (current.children[j] != null) {
                    System.out.print(current.children[j].ch + " " + current.children[j].isEnd + " ");
                    current = current.children[j];
                }
            }
            System.out.println("----");
        }
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
