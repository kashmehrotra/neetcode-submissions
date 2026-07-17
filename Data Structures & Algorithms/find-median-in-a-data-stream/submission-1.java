class MedianFinder {

    // max heap
    private PriorityQueue<Integer> small;
    
    // min heap
    private PriorityQueue<Integer> large;

    private boolean isEven = true;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (this.isEven) {
            this.large.offer(num);
            this.small.offer(this.large.poll());
        } else {
            this.small.offer(num);
            this.large.offer(this.small.poll());
        }
        this.isEven = !this.isEven;
    }
    
    public double findMedian() {
        if (this.isEven) {
            return (this.small.peek() + this.large.peek())/2.0;
        } else {
            return (double)this.small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */