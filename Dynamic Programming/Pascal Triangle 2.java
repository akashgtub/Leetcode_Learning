class Solution {
    public List<Integer> getRow(int r) {
     int[][] dp=new int[r+1][r+1];
   for(int i=0;i<=r;i++){
    dp[i][0]=1;
    dp[i][i]=1;
    for(int j=1;j<i;j++){
        dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
    }
   }
   List<Integer> list=new ArrayList<>();
   for(int j=0;j<=r;j++){
    list.add(dp[r][j]);
   }
   return list;
    }
}