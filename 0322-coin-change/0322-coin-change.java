class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
     int ans= helper(n-1,amount,coins,dp);
        if(ans>=(int)Math.pow(10,9)){
            return -1;
        }
        return ans;
    }
    public int helper(int ind,int amt,int[] coins,int[][] dp){
        if(ind==0){
            if(amt%coins[0]==0){
                return amt/coins[0];
            }else{
                return (int)Math.pow(10,9);
            }
        }
        if(dp[ind][amt]!=-1){
            return dp[ind][amt];
        }
        int notTake=0+helper(ind-1,amt,coins,dp);
        int take=(int)Math.pow(10,9);
        if(coins[ind]<=amt){
            take=1+helper(ind,amt-coins[ind],coins,dp);
        }
        return dp[ind][amt]=Math.min(take,notTake);
    }
}