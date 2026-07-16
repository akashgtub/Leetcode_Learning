class Solution {
static class Pair{
    int node,weight;
    Pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<List<Pair>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] cur:times){
            list.get(cur[0]).add(new Pair(cur[1],cur[2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.weight-b.weight));
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            int node=cur.node;
            int weight=cur.weight;
            if(weight>dist[node]){
                continue;
            }
            for(Pair next:list.get(node)){
                int node1=next.node;
                int weight1=next.weight;
                if(dist[node]+weight1<dist[node1]){
                    dist[node1]=dist[node]+weight1;
                    pq.add(new Pair(node1,dist[node1]));
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}