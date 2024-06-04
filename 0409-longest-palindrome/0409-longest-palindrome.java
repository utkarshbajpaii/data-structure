class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int result=0;
        int oddFreq=0;
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)%2!=0){
                oddFreq++;
            }
            else{
                oddFreq--;
            }
        }
        if(oddFreq>0){
            return n-oddFreq+1;
        }
        return n;
    }
}