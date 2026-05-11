class MedianFinder {
    private final PriorityQueue<Integer> smallHeap;
    private final PriorityQueue<Integer> largeHeap;


    public MedianFinder() {
        this.smallHeap = new PriorityQueue<>((a, b) -> b - a);
        this.largeHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if (
            smallHeap.size() - largeHeap.size() > 1 ||
            !largeHeap.isEmpty() &&
            smallHeap.peek() > largeHeap.peek()
        ) {
            largeHeap.add(smallHeap.poll());
        }
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }

    }
    
    public double findMedian() {
        if (smallHeap.size() == largeHeap.size())
            return (double) (smallHeap.peek() + largeHeap.peek()) / 2;
        else if (smallHeap.size() >  largeHeap.size())
            return (double) smallHeap.peek();
        else return (double) largeHeap.peek();
    }
}
