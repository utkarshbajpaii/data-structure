class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
         return subarray(nums,k)-subarray(nums,k-1);
    }
        public int subarray(int[] nums,int goal){
        int left=0;
        int right=0;
        int sum=0;
        int result=0;
        for(right=0;right<nums.length;right++){
            sum+=nums[right]%2;
            while(sum>goal&&left<=right){
                sum-=nums[left]%2;
                left++;
            }
            result+=right-left+1;
        }
        return result;
    
    }
}