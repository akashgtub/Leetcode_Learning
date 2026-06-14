/*'
Leetcode Profile :AkashTCse'
 Name:Akash
 # Two Sum

### Problem

Given an array of integers and a target value, find the indices of the two numbers that add up to the target.

### Learning

Initially, I solved this problem using the brute force approach by checking every possible pair of elements. Although the solution was correct, it had a time complexity of O(n²), which is inefficient for large inputs.

After learning about HashMap, I optimized the solution by storing previously visited elements and their indices. This allowed me to find the required pair in a single traversal of the array.

### Key Takeaways

* Learned how to use HashMap for efficient lookups.
* Understood the difference between brute force and optimized approaches.
* Reduced time complexity from O(n²) to O(n).
* Improved problem-solving skills by identifying and eliminating unnecessary nested loops.

### Complexity

* Time Complexity: O(n)
* Space Complexity: O(n)



*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int need=target-nums[i];
            if(map.containsKey(need)){
                return new int[]{map.get(need),(i)};
            }
        map.put(nums[i],i);
        }
        return new int[]{};
    }
}