class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list=new ArrayList<>();
        HashSet<String> set=new HashSet<>(wordDict);
        String currSentence="";
        solve(0,currSentence,list,set,s);
        return list;
    }
    public void solve(int i,String currSentence,List<String> list,HashSet<String> set,String s){
        if(i>=s.length()){
            list.add(currSentence.trim());
            return;
        }
        for(int j=i;j<s.length();j++){
            String tempWord=s.substring(i,j+1);
            if(set.contains(tempWord)){
                String originalSentence=currSentence;
                if(!currSentence.isEmpty()){
                    currSentence+=" ";
                }
                currSentence+=tempWord;
                solve(j+1,currSentence,list,set,s);
                currSentence=originalSentence;
            }
        }
    }
}