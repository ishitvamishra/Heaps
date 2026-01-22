class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int W) {
        // code here
        int n = nums.length;
        int dp[][] = new int[n+1][W+1];
        
        for(int i = 0;i<=n;i++){
            dp[i][0] =  1;
        }
    
        
        for(int i = 1; i<=n; i++){
            for(int j = 0; j<=W;j++){
                //balls are less than what player has to play
                if(j<nums[i-1]){
                    dp[i][j] = dp[i-1][j];   //previous runs that was scored without current player
                }
                else{
                    //if he plays
                    dp[i][j] =dp[i-1][j] +dp[i-1][j-nums[i-1]];
                }
            }
        }
        
        return dp[n][W];
    }
}