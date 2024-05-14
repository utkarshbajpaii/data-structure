class Solution {
    int m,n;
    int[] row={1,-1,0,0};
    int[] col={0,0,-1,1};
    public int getMaximumGold(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int maxGold=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    maxGold=Math.max(maxGold,dfs(grid,i,j));
                }
            }
        }
        return maxGold;
    }
    public int dfs(int[][] grid,int i,int j){
        if(i>=m||i<0||j>=n||j<0||grid[i][j]==0){
            return 0;
        }
        int originalGold=grid[i][j];
        grid[i][j]=0;
        int maxGold=0;
        for(int k=0;k<4;k++){
            int newX=i+row[k];
            int newY=j+col[k];
            maxGold=Math.max(maxGold,dfs(grid,newX,newY));
        }
        
        
        grid[i][j]=originalGold;
        return originalGold+maxGold;
    }
}