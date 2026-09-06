class Solution {
    public int countGoodRotations(int[] nums) {
        int n=nums.length;
        int half=n/2;
        long window=0;
        long total=0;
        for(int num:nums){
            total+=num;
        }
        for(int i=0;i<half;i++){
            window+=nums[i];
        }
        int count=0;
        for(int i=0;i<n;i++){
           long second=total-window;
            if(window>second){
                count++;
            }
            window-=nums[i];
            window+=nums[(i+half)%n];
        }
        return count;
    }
}