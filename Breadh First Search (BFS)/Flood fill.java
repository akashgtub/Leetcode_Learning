class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q=new LinkedList<>();
        int n=image.length;
        int m=image[0].length;
        q.add(new int[]{sr,sc});
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        int k=image[sr][sc];
        image[sr][sc]=color;
        boolean[][] visited=new boolean[n][m];
        visited[sr][sc]=true;
        while(!q.isEmpty()){
            int[] cur=q.poll();
              int r=cur[0];
              int c=cur[1];
              for(int i=0;i<4;i++){
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&!visited[nr][nc]&&image[nr][nc]==k){
                    image[nr][nc]=color;
                    visited[nr][nc]=true;
                    q.add(new int[]{nr,nc});
                }
              }
        }
        return image;
    }
}