class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int up=dp[i-1][j];
                int upLeft=Integer.MAX_VALUE;
                int upRight=Integer.MAX_VALUE;
                if(j>0){
                    upLeft=dp[i-1][j-1];
                }
                if(j<n-1){
                    upRight=dp[i-1][j+1];
                }
                dp[i][j]=matrix[i][j]+Math.min(up,Math.min(upLeft,upRight));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,dp[n-1][i]);
        }
        return min;
    }
}