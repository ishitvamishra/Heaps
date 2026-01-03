class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        for(int i= 0;i<gifts.length;i++){
            p.add(gifts[i]);
        }

        long total = 0;
        while(k-->0){
            int gift= p.remove();
            gift = (int)Math.sqrt(gift);
            p.add(gift);
        }

        while(!p.isEmpty()){
            total = total+p.remove();
        }
        return total;
        
    }
}