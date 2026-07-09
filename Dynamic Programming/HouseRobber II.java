class Solution {
    static int rob(int nums[],int start,int end){
        int n=end-start+1;
        if(n==1){
            return nums[start];
        }
        int[] dp=new int[n];
        dp[0]=nums[start];
        if(n>=2){
            dp[1]=Math.max(nums[start+1],nums[start]);
        }
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],nums[start+i]+dp[i-2]);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
      int a=rob(nums,0,n-2);
      int b=rob(nums,1,n-1);
      return Math.max(a,b);
    }
}