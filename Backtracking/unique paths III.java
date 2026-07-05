class Solution {
    static int n;
    static int m;
    static int count=0;
    static int[][] sol;
    static int total=0;
    static void solve(int i,int j,int[][] grid,int cur){
    if(i<0||i>=n||j<0||j>=m||sol[i][j]==1||grid[i][j]==-1){
        return ;
    }
    if(grid[i][j]==2){
        if(cur==total){
        count++;
        }
        return;
    }
    sol[i][j]=1;
   solve(i,j+1,grid,cur+1);
   solve(i+1,j,grid,cur+1);
   solve(i,j-1,grid,cur+1);
   solve(i-1,j,grid,cur+1);
    sol[i][j]=0;
 }
    public int uniquePathsIII(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        sol=new int[n][m];
        count=0;
        total=0;
        int sr=0,sc=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=-1){
                    total++;
                }
                if(grid[i][j]==1){
                   sr=i;
                   sc=j;
                }
            }
        }
        solve(sr,sc,grid,1);
        return count;
    }
}