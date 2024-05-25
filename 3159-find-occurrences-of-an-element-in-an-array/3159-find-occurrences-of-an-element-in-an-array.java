class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                list.add(i);
            }
        }
        int[] result=new int[queries.length];
        for(int j=0;j<queries.length;j++){
            if(queries[j]<=list.size()){
                result[j]=list.get(queries[j]-1);
            }else{
                result[j]=-1;
            }
        }
        return result;
    }
}