// 215 Kth Largest Element in an Array with Heap Approach
    public int findKthLargest(int[] nums, int k) {
        // initialize heap  with the lowest element in the first position
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        // keep k largest elements in the heap
        // iterate through the array using an index
        for (int n: nums) {
          // for each iteration add a value to the heap
          heap.add(n);
          // check if the heap's size is greater than the K
          if (heap.size() > k)
          // return and chop off the first element in the queue
            heap.poll();
        }
        // now the first element in the queue is the Kth Largest
        return heap.poll();
  }
