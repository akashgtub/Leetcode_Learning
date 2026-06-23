import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for(int num : nums) {
            if(s2.contains(num)) {
                s2.remove(num);
            } else if(s1.contains(num)) {
                s1.remove(num);
                s2.add(num);
            } else {
                s1.add(num);
            }
        }

        for(int num : s1) {
            return num;
        }

        return -1;
    }
}