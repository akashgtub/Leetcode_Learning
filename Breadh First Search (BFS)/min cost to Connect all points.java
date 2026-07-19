class Solution {
    static class Edge{
        int u,v,w;
        Edge(int u,int v,int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }
    static class DisJoint{
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
        public boolean union1(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX==rootY){
                return false;
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
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<Edge> list=new ArrayList<>();
        int n=points.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                  int d=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                  list.add(new Edge(i,j,d));
            }
        }
        Collections.sort(list,(a,b)->a.w-b.w);
        int cost=0;
        DisJoint d=new DisJoint(n);
        for(Edge e:list){
            if(d.union1(e.u,e.v)){
                cost+=e.w;
            }
        }
        return cost;
    }
}