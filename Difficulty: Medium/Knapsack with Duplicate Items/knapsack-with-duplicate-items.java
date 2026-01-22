class Solution {
    public int knapSack(int val[], int wt[], int W) {
        // code here
        int n = wt.length;
        int dp[][] = new int[n+1][W+1];
    
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=W;j++){
                //balls are less than what player has to play
                if(j<wt[i-1]){
                    dp[i][j] = dp[i-1][j];   //previous runs that was scored without current player
                }
                else{
                    //if he plays
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i][j-wt[i-1]]);
                }
            }
        }
        
        return dp[n][W];
        
    }
}