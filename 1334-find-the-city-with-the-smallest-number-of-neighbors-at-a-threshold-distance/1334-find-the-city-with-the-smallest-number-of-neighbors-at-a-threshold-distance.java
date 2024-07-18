class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=(int)1e9;
            }
        }
        for(int[] i:edges){
            int u=i[0];
            int v=i[1];
            int wt=i[2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        for(int i=0;i<n;i++){
            dist[i][i]=0;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==1e9||dist[k][j]==1e9){
                        continue;
                    }
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        int cntCity=n;
        int cntNo=-1;
        for(int city=0;city<n;city++){
            int cnt=0;
            for(int adjcity=0;adjcity<n;adjcity++){
                if(dist[city][adjcity]<=distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=cntCity){
                cntCity=cnt;
                cntNo=city;
            }
        }
        return cntNo;
    }
}