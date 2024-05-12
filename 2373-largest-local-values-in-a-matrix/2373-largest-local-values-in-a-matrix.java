class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int[][] maxLocal=new int[n-2][n-2];
        for(int row=0;row<n-2;row++){
            for(int col=0;col<n-2;col++){
                maxLocal[row][col]=findMax(row,col,grid);
            }
        }
        return maxLocal;
    }
    public int findMax(int row,int col,int[][] grid){
        int max=0;
        for(int x=row;x<row+3;x++){
            for(int y=col;y<col+3;y++){
                max=Math.max(max,grid[x][y]);
            }
        }
        return max;
    }
}