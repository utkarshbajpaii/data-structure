class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n=s.length();
        int currCost=0;
        int maxLen=0;
        int i=0;
        int j=0;
        while(j<n){
            currCost+=Math.abs(s.charAt(j)-t.charAt(j));
            while(currCost>maxCost){
                currCost-=Math.abs(s.charAt(i)-t.charAt(i));
                i++;
            }
            maxLen=Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}