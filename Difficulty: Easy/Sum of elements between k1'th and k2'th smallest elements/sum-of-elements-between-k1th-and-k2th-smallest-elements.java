// User function Template for Java

class Solution {
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        // Your code goes here
        PriorityQueue<Long> p = new PriorityQueue<>(Collections.reverseOrder());
        long sum =0;
        for(int i = 0;i<K2;i++){
            p.add(A[i]);
        }
        
        for(int i = (int) K2;i<N;i++){
            if(p.peek()> A[i]){
                p.remove();
                p.add(A[i]);
            }
        }
        
        p.remove();
        
        for(int i = 0; i< K2-K1-1;i++){
            sum += p.remove();
        }
        
        return sum;
    }
}
