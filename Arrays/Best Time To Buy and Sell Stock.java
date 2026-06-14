/*
Initially, I decided to solve this problem using a brute-force approach by checking every possible buy and sell combination. Although the logic was correct, the solution had a time complexity of O(n²), making it unsuitable for large inputs and causing it to fail the time limit constraints.

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

After analyzing the problem further, I realized that I only needed to keep track of the minimum stock price encountered so far and calculate the potential profit at each step. This led me to a one-pass solution where the array is traversed only once while continuously updating the minimum price and maximum profit.

Time Complexity: O(n)

Space Complexity: O(1)

*/

class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int p:prices){
            min=Math.min(min,p);
            max=Math.max(max,p-min);
        }
        return max;
    }
}