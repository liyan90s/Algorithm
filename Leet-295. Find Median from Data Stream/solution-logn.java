class MedianFinder {
    PriorityQueue<Integer> maxHeap, minHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());    
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if (minHeap.size() > maxHeap.size()) {      // balancing the heaps
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (double) (maxHeap.peek() + minHeap.peek()) * 0.5;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */