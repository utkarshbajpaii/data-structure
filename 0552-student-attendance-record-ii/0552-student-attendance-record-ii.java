class Solution {
    int M=1000000007;
    public int checkRecord(int n) {
        int[][][] dp=new int[n+1][2][3];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(n,0,0,dp);
    }
    public int helper(int n,int absent,int late,int[][][] dp){
        if(absent>=2||late>=3){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[n][absent][late]!=-1){
           return dp[n][absent][late];
        }
        int A=helper(n-1,absent+1,0,dp)%M;
        int l=helper(n-1,absent,late+1,dp)%M;
        int P=helper(n-1,absent,0,dp)%M;

        return dp[n][absent][late]=((A+l)%M+P)%M;
        
    }
}