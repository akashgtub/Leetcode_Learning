class Solution {
    class DisJoint{
        int[] parent;
        int[] rank;
        DisJoint(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
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
            if(rootX==rootY){
                return;
            }
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
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DisJoint d=new DisJoint(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    d.union(i,j);
                }
            }
        }
        int p=0;
        for(int i=0;i<n;i++){
            if(d.find(i)==i){
                p++;
            }
        }
        return p;
    }
}