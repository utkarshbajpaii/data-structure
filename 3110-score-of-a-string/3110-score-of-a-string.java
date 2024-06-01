class Solution {
    public int scoreOfString(String s) {
        int i=0;
        int j=1;
        int sum=0;
        while(j<s.length()){
            int p=s.charAt(i)-'a';
            int k=s.charAt(j)-'a';
            int diff=Math.abs(p-k);
            sum+=diff;
            i++;
            j++;
        }
        return sum;
    }
}