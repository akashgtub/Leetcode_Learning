/*After completing around 50 Two Pointer problems, I started learning the Sliding Window technique. While solving this problem, I observed that all elements in the array are positive, which makes it possible to dynamically expand and shrink a window instead of checking every possible subarray.

I used a sliding window approach where:

The right pointer expands the window by adding elements.
Once the current sum becomes greater than or equal to the target, the left pointer shrinks the window to find the smallest valid subarray.
The minimum length is updated whenever a valid window is found.
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=target){
               min=Math.min(min,i-left+1);
               sum-=nums[left];
               left++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}