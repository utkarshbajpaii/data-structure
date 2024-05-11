class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n=quality.length;
        double[][] worker_ratio=new double[n][2];
        for(int worker=0;worker<n;worker++){
            worker_ratio[worker][0]=(double)wage[worker]/quality[worker];
            worker_ratio[worker][1]=quality[worker];
        }
        Arrays.sort(worker_ratio,(a,b)->Double.compare(a[0],b[0]));
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        double sum=0;
        for(int i=0;i<k;i++){
            pq.offer((int)worker_ratio[i][1]);
            sum+=worker_ratio[i][1];
        }
        double managerRatio=worker_ratio[k-1][0];
        double result=managerRatio*sum;
        for(int manager=k;manager<n;manager++){
            managerRatio=worker_ratio[manager][0];
            pq.offer((int)worker_ratio[manager][1]);
            sum+=worker_ratio[manager][1];
            if(pq.size()>k){
                sum-=pq.poll();
            }
            result=Math.min(result,managerRatio*sum);
        }
        return result;
    }
}