class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
        PriorityQueue<Integer> p = new PriorityQueue<>();
        int result [] = new int [n];
        
        for(int i =0;i<k-1;i++){
            result[i] = -1;
        }
        
        for(int i = 0;i<k;i++){
            p.add(arr[i]);
        }
        
        for(int i = k;i<n;i++){
            result[i-1]= p.peek();
            if(p.peek() < arr[i]){
                p.remove();
                p.add(arr[i]);
            }
        }
        
        result[n-1] = p.peek();
        return result;
        
        
    }
};