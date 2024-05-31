class Solution {
    public int[] singleNumber(int[] nums) {
     Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                set.remove(nums[i]);
            }
        }
        int[] arr=new int[2];
        int i=0;
        for(int element:set){
            arr[i++]=element;
            
        }
        return arr;
    }
}