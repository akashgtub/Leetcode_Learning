class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
              if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        boolean[][] dp=new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                 boolean a=false;
                 boolean b=false;
                 a=dp[i-1][j];
                 if(j>=nums[i-1]){
                    b=dp[i-1][j-nums[i-1]];
                 }
                 dp[i][j]=a||b;
            }
        }
       return dp[n][target];
    }
}