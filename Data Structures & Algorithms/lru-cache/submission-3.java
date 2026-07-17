class LRUCache {

    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node() {}

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(2000, 2000);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
    }

    private void moveNodeToFront(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }
    
    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }
        Node node = this.map.get(key);
        if (this.head.next == node) {
            return node.val;
        }
        moveNodeToFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (!this.map.containsKey(key)) {
            Node node = new Node(key, value);
            this.map.put(key, node);
            node.next = this.head.next;
            node.prev = this.head;
            this.head.next.prev = node;
            this.head.next = node;
            if (this.capacity < this.map.size()) {
                Node toBeEvicted = this.tail.prev;
                this.tail.prev = toBeEvicted.prev;
                toBeEvicted.prev.next = this.tail;
                this.map.remove(toBeEvicted.key);
            }
            return;
        }
        Node node = this.map.get(key);
        node.val = value;
        moveNodeToFront(node);
    }
}
