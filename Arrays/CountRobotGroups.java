import java.util.*;

class Solution {
    public int countRobotGroups(int[] position, int[] speed, int distance) {
        int n = position.length;
        List<Integer> groups = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!groups.isEmpty() && position[i] - position[i - 1] <= distance) {
                groups.set(groups.size() - 1, speed[i]);
            } else {
                groups.add(speed[i]);
            }
        }

        int count = 0;
        int frontSpeed = -1;

        for (int i = groups.size() - 1; i >= 0; i--) {
            int v = groups.get(i);

            if (v <= frontSpeed) {
                count++;
                frontSpeed = v;
            } else if (frontSpeed == -1) {
                count++;
                frontSpeed = v;
            }
        }

        return count;
    }
}