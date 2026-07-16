class Solution {
    static class Pair{
        int node;
        long weight;
        Pair(int node,long weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int cur[]:roads){
            list.get(cur[0]).add(new Pair(cur[1],cur[2]));
            list.get(cur[1]).add(new Pair(cur[0],cur[2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.weight,b.weight));
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        long[] ways=new long[n];
        ways[0]=1;
        long mod=1000000007;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            int node=cur.node;
            long weight=cur.weight;
            if(weight>dist[node]){
                continue;
            }
            for(Pair next:list.get(node)){
                int node1=next.node;
                long weight1=next.weight;
                if(dist[node]+weight1<dist[node1]){
                    dist[node1]=dist[node]+weight1;
                    ways[node1]=ways[node];
                    pq.add(new Pair(node1,dist[node1]));
                }
                else if(dist[node]+weight1==dist[node1]){
                    ways[node1]=(ways[node]+ways[node1])%mod;;
                }
            }
        }
        return (int)ways[n-1];
    }
}