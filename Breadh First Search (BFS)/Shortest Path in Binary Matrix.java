class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==1){
            return -1;
        }
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,1});
        int[][] dir={{-1,0},{-1,-1},{-1,1},{0,-1},{0,1},{1,0},{1,-1},{1,1}};
        while(!q.isEmpty()){
            int cur[] =q.poll();
            int r=cur[0];
            int c=cur[1];
            int d=cur[2];
            if(r==n-1&&c==m-1){
                return d;
            }
            for(int i=0;i<8;i++){
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==0){
                    grid[nr][nc]=1;
                    q.add(new int[]{nr,nc,d+1});
                }
            }
        }
        return -1;
    }
}