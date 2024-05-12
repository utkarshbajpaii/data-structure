class Solution {
    public int minPathSum(int[][] grid) {
       int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,grid,dp);
    }
    public int f(int m,int n,int[][] grid,int[][] dp){
        if(m==0&&n==0){
            return grid[0][0];
        }
        if(m<0||n<0){
            return (int) Math.pow(10,9);
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int up=grid[m][n]+f(m-1,n,grid,dp);
        int left=grid[m][n]+f(m,n-1,grid,dp);
        return dp[m][n]=Math.min(up,left);
    }
}