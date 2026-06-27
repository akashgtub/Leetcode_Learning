class Solution {
    public int findLHS(int[] nums) {
         Arrays.sort(nums);
         int left=0,max=0;
         for(int i=0;i<nums.length;i++){
            while(nums[i]-nums[left]>1){
                left++;
            }
            if(nums[i]-nums[left]==1){
                max=Math.max(max,i-left+1);
            }
         }
         return max;

    }
}