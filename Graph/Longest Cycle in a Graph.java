class Solution {
    public int longestCycle(int[] edges) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int n=edges.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(edges[i]!=-1){
                list.get(i).add(edges[i]);
            }
        }
        int[] in=new int[n];
        for(int i=0;i<n;i++){
            for(int k:list.get(i)){
                in[k]++;
            }
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
               pq.add(i);
            }
        }
        boolean[] visited=new boolean[n];
        while(!pq.isEmpty()){
            int node=pq.poll();
            visited[node]=true;
            for(int next:list.get(node)){
                in[next]--;
                if(in[next]==0){
                    pq.add(next);
                }
            }
        }
        int ans=-1;
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            int count=0;
            int cur=i;
            while(!visited[cur]){
                visited[cur]=true;
                count++;
                cur=edges[cur];
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}