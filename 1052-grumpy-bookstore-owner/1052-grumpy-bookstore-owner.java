class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=grumpy.length;
        int j=0;
        int currWin=0;
        int maxWin=0;
        for(int i=0;i<n;i++){
            currWin+=customers[i]*grumpy[i];
            maxWin=Math.max(currWin,maxWin);
            if(i>=minutes-1){
                currWin-=customers[j]*grumpy[j++];
            }
        }
        int res=maxWin;
        for(int k=0;k<grumpy.length;k++){
            
                res+=customers[k]*(1-grumpy[k]);
            
        }
        return res;
    }
}