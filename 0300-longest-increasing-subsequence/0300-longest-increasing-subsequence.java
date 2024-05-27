class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(nums,-1,0,n,dp);
    }
    public int helper(int[] nums,int prev_ind,int ind,int n,int[][] dp){
        if(ind==n){
            return 0;
        }
        if(dp[ind][prev_ind+1]!=-1){
            return dp[ind][prev_ind+1];
        }
        int notTake=0+helper(nums,prev_ind,ind+1,n,dp);
        int take=0;
        if(prev_ind==-1||nums[ind]>nums[prev_ind]){
            take=1+helper(nums,ind,ind+1,n,dp);
        }
        return dp[ind][prev_ind+1]=Math.max(notTake,take);
    }
}