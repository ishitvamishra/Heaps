class Solution {

    static class Node {
        int value;
        int row;
        int col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Node> minHeap =
                new PriorityQueue<>((a, b) -> a.value - b.value);

        int max = Integer.MIN_VALUE;

        // Step 1: Initialize heap with first element of each list
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new Node(val, i, 0));
            max = Math.max(max, val);
        }

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        // Step 2: Process heap
        while (true) {
            Node curr = minHeap.poll();
            int min = curr.value;

            // Update best range
            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            // Move to next element in the same list
            if (curr.col + 1 == nums.get(curr.row).size()) {
                break; // one list exhausted
            }

            int nextVal = nums.get(curr.row).get(curr.col + 1);
            minHeap.offer(new Node(nextVal, curr.row, curr.col + 1));
            max = Math.max(max, nextVal);
        }

        return new int[]{rangeStart, rangeEnd};
    }
}
