class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    boolean isEven;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.isEven = true;
    }
    
    public void addNum(int num) {
        this.maxHeap.add(num);
        this.minHeap.add(this.maxHeap.poll());
        if (this.maxHeap.size() < this.minHeap.size()) {
            this.maxHeap.add(this.minHeap.poll());
        }
        this.isEven = !this.isEven;
    }
    
    public double findMedian() {
        if (!isEven) {
            return (double)maxHeap.peek();
        }
        return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
