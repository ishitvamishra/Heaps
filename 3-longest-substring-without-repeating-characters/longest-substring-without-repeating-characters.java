class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, maxLen = 0;

        // Stores last index of each character
        int[] lastIndex = new int[256];
        for (int i = 0; i < 256; i++) lastIndex[i] = -1;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);

            // If character already seen in current window
            if (lastIndex[ch] >= left) {
                left = lastIndex[ch] + 1;
            }

            lastIndex[ch] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
