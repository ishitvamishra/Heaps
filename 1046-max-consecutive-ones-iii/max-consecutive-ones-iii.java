class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, zeros=0, maxLen = 0;

        for(int r = 0;r < nums.length;r++){
            //check krlo agar current index pe zero h toh zeros ko increase krlo
            if(nums[r]==0) zeros++;

            //agar zeros k ko exceedd krta h toh check kro left jaha h vo kya zero h agar hai toh zeros 
            //zeros ko decrease kro aur left pointer ko aage badha do 
            if(zeros > k){
                if(nums[l] == 0) zeros--;
                l++;
            }
            // calculate maxLen each time when visiting any index of array
            maxLen = Math.max(maxLen , r-l+1);
        }
        return maxLen;
    }
}