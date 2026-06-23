class Solution {
    public int removeElement(int[] nums, int val) {
       int results =0;
       for(int i=0;i<nums.length;i++){
        if(nums[i]!=val){
            nums[results]=nums[i];
            results++;
        }
       }
       return results; 
    }
}