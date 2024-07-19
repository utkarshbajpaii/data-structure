class Solution {
    private int timer=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> it:connections){
            int u=it.get(0);
            int v=it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<List<Integer>> bridge=new ArrayList<>();
        int[] vis=new int[n];
        int[] tin=new int[n];
        int[] low=new int[n];
        dfs(0,-1,adj,vis,tin,low,bridge);
        return bridge;
    }
    public void dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,int[] vis,int[] tin,int[] low,List<List<Integer>> bridge){
        vis[node]=1;
        low[node]=tin[node]=timer;
        timer++;
        for(int it:adj.get(node)){
            if(it==parent){
                continue;
            }
            if(vis[it]==0){
                dfs(it,node,adj,vis,tin,low,bridge);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>tin[node]){
                    bridge.add(Arrays.asList(it,node));
                }
            }else{
                low[node]=Math.min(low[it],low[node]);
            }
        }
    }
}