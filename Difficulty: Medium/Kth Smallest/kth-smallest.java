class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0;i<k ;i++){
            p.add(arr[i]);
        }
        
        for(int i = k;i<arr.length;i++){
            if(p.peek() > arr[i]){
                p.remove();
                p.add(arr[i]);
            }
        }
        
        return p.peek();
    }
}
