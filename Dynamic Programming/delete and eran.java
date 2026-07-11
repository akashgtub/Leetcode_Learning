class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int n:nums){
            max=Math.max(max,n);
        }
        int[] freq=new int[max+1];
        for(int n:nums){
            freq[n]+=n;
        }
        int[] dp=new int[max+1];
        dp[0]=freq[0];
        dp[1]=freq[1];
        for(int i=2;i<=max;i++){
            dp[i]=Math.max(dp[i-1],freq[i]+dp[i-2]);
        }
        return dp[max];
    }
}