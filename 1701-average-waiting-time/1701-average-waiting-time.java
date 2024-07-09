class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n=customers.length;
       double serviceTime=customers[0][0]+customers[0][1];
       double totalTime=serviceTime-customers[0][0];
       for(int i=1;i<n;i++){
        if(serviceTime<customers[i][0]){
            serviceTime=customers[i][0];
        }
        serviceTime+=customers[i][1];
        totalTime+=(serviceTime-customers[i][0]);
       }
       return totalTime/n;
    }
}