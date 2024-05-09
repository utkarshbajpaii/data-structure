class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        reverse(happiness);
        long result=0;
        int count=0;
        for(int i=0;i<k;i++){
            result+=Math.max(happiness[i]-count,0);
            count++;
        }  
        return result;
    }
    public void reverse(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}