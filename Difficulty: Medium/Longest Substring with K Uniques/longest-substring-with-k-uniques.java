class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        if(k == 0 || s.length() == 0) return 0;
        
        int left  = 0;
        int maxLen = -1;
        
        Map<Character, Integer> freq = new HashMap<>();
        for(int right = 0;right < s.length(); right++){
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch,0)+1);
            
            if(freq.size() > k){
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar)-1);
                
                if(freq.get(leftChar) == 0){
                    freq.remove(leftChar);
                }
                left++;
            }
            
            if(freq.size() == k){
                maxLen = Math.max(maxLen, right-left+1);
            }
        }
        return maxLen;
    }
}