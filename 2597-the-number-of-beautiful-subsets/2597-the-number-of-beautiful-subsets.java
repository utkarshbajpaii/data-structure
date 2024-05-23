class Solution {
    int result;
    // int K;
    public int beautifulSubsets(int[] nums, int k) {
        result=0;
        // K=k;
        Map<Integer,Integer> map=new HashMap<>();
        dfs(nums,0,map,k);
        return result-1;
    }
    public void dfs(int[] nums,int ind,Map<Integer,Integer> map,int k){
        if(ind==nums.length){
            result++;
            return ;
        }
        dfs(nums,ind+1,map,k);
        if(!map.containsKey(nums[ind]-k)&&!map.containsKey(nums[ind]+k)){
            map.put(nums[ind],map.getOrDefault(nums[ind],0)+1);
            dfs(nums,ind+1,map,k);
            map.put(nums[ind],map.get(nums[ind])-1);
            if(map.get(nums[ind])==0){
                map.remove(nums[ind]);
            }
        }
    }
}