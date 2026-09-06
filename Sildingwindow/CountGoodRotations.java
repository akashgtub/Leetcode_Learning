class Solution {
    public int countGoodRotations(int[] nums) {
        int n=nums.length;
        int half=n/2;
        int window=0;
        int total=0;
        for(int num:nums){
            total+=num;
        }
        for(int i=0;i<half;i++){
            window+=nums[i];
        }
        for(int i=0;i<n;i++){
            
        }
    }
}