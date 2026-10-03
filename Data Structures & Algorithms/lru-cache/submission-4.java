class LRUCache {

    class Node {
        Node left;
        Node right;
        int key;
        int val;

        Node(int key, int val) {
            this.left = null;
            this.right = null;
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail;
    Map<Integer, Node> keyMap;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-2, -2);
        this.head.right = this.tail;
        this.tail.left = this.head;
        this.keyMap = new HashMap<>();
    }

    private void moveToFront(Node node) {
        if (node.left == this.head) {
            return;
        }
        node.left.right = node.right;
        node.right.left = node.left;

        addToFront(node);
    }

    private void addToFront(Node node) {
        node.right = this.head.right;
        node.left = this.head;

        this.head.right.left = node;
        this.head.right = node;
    }

    private Node removeFromLast() {
        if (this.tail.left == this.head) {
            return null;
        }
        Node node = this.tail.left;
        node.left.right = this.tail;
        this.tail.left = node.left;
        return node;
    }
    
    public int get(int key) {
        if (!this.keyMap.containsKey(key)) {
            return -1;
        }
        Node node = this.keyMap.get(key);
        moveToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (this.keyMap.containsKey(key)) {
            Node node = this.keyMap.get(key);
            node.val = value;
            moveToFront(node);
            return;
        }
        Node node = new Node(key, value);
        addToFront(node);
        this.keyMap.put(key, node);
        if (this.capacity+1 == this.keyMap.size()) {
            Node removedNode = removeFromLast();
            if (removedNode == null) {
                return;
            }
            this.keyMap.remove(removedNode.key);
        }
    }
}
