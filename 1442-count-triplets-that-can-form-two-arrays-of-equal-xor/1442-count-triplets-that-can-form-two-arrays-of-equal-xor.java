class Solution {
    public int countTriplets(int[] arr) {
        int[] preFixXor=new int[arr.length+1];
        preFixXor[0]=0;
        for(int i=1;i<=arr.length;i++){
            preFixXor[i]=preFixXor[i-1]^arr[i-1];
        }
        int triplet=0;
        for(int i=0;i<preFixXor.length;i++){
            for(int k=i+1;k<preFixXor.length;k++){
                if(preFixXor[i]==preFixXor[k]){
                    triplet+=k-i-1;
                }
            }
        }
        return triplet;
    }
}