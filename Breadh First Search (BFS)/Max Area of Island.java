class Solution {
    static int max;
    static void bfs(int[][] grid,int sr,int sc,boolean[][] visited,int n,int m){
        int count=0;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        visited[sr][sc]=true;
        while(!q.isEmpty()){
            int[] cur=q.poll();
              count++;
              for(int i=0;i<4;i++){
                int nr=cur[0]+dir[i][0];
                int nc=cur[1]+dir[i][1];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&!visited[nr][nc]&&grid[nr][nc]!=0){
                    visited[nr][nc]=true;
                    q.add(new int[]{nr,nc});
                }
              }
        }
        max=Math.max(max,count);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
         max=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==1){
                 bfs(grid,i,j,visited,n,m);
            }
        }
       } 
       return max;
    }
}