class Solution {
    class DisJoint{
        int[] parent;
        int[] rank;
        DisJoint(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=0;
            }
        }
        public int find(int x){
            if(x!=parent[x]){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x,int y){
             int rootX=find(x);
             int rootY=find(y);
             if(rank[rootX]<rank[rootY]){
                parent[rootX]=rootY;
             }
             else if(rank[rootX]>rank[rootY]){
                parent[rootY]=rootX;
             }
             else{
                parent[rootY]=rootX;
                rank[rootX]++;
             }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisJoint d=new DisJoint(n);
        for(int[] e:edges){
            d.union(e[0],e[1]);
        }
        return d.find(source)==d.find(destination);
    }
}