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
        System.out.println(" GET start 0 -- " + key);
        print();
        System.out.println(" GET start 1 -- " + key);
        if (!this.map.containsKey(key)) {
            return -1;
        }
        Node node = this.map.get(key);
        if (this.head.next == node) {
            return node.val;
        }
        moveNodeToFront(node);
        System.out.println(" GET end 0 -- " + key);
        print();
        System.out.println(" GET end 1 -- " + key);
        return node.val;
    }

    // -1 <-> 1 <-> 2 <-> 3 <-> 2000

    public void put(int key, int value) {
        System.out.println("put start " + key);
        print();
        System.out.println(" put ... " + key);
        if (!this.map.containsKey(key)) {
            Node node = new Node(key, value);
            this.map.put(key, node);
            node.next = this.head.next;
            node.prev = this.head;
            this.head.next.prev = node;
            this.head.next = node;
            System.out.println("put middle " + key);
            print();
            System.out.println(" put middle ... " + key);
            if (this.capacity < this.map.size()) {
                Node toBeEvicted = this.tail.prev;
                this.tail.prev = toBeEvicted.prev;
                toBeEvicted.prev.next = this.tail;
                this.map.remove(toBeEvicted.key);
            }
            // if (this.tail != null) {
            //     System.out.println(" === " + this.tail.key);
            //     if (this.tail.prev != null) {
            //         System.out.print(" prev " + this.tail.prev.key + " prev ");
            //     }
            //     if (this.tail.next != null) {
            //         System.out.print(" next " + this.tail.next.key + " next ");
            //     }
            //     System.out.println(" === ");
            // }
            // if (this.tail == null) {
            //     this.tail = node;
            // } else if (this.capacity < this.map.size() && this.tail.prev != null) {
            //     System.out.println("eviction while inserting " + key);
            //     this.map.remove(this.tail.key);
            //     this.tail = this.tail.prev;
            //     this.tail.next = null;
            // }
            print();
            System.out.println();
            return;
        }
        Node node = this.map.get(key);
        node.val = value;
        moveNodeToFront(node);
        print();
        System.out.println();
    }

    // -1 <-> 1 <-> 2 <-> 3 <-> 2000

    private void print() {
        if (this.head != null) {
            System.out.print(this.head.key + " -- ");
        }
        Node curr = this.head;
        while(curr != null) {
            System.out.print(curr.key + "=" + curr.val + ", ");
            curr = curr.next;
        }
        if (this.tail != null) {
            System.out.print(" -- " + this.tail.key);
        }
    }
}
