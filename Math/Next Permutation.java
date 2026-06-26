class Solution {
    public void nextPermutation(int[] nums) {
          int idx1=-1,idx2=-1;
          int n=nums.length;
          for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx1=i;
                break;
            }
          }
          if(idx1==-1){
            reverse(nums,0);
          }
          else{
            for(int i=n-1;i>=0;i--){
                if(nums[i]>nums[idx1]){
                    idx2=i;
                    break;
                }
            }
            int temp=nums[idx1];
            nums[idx1]=nums[idx2];
            nums[idx2]=temp;
            reverse(nums,idx1+1);
          }
    }
    static void reverse(int[] nums,int left){
        int right=nums.length-1;
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}