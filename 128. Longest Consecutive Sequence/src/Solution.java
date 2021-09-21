import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int start : set) {
            if (set.contains(start) && !set.contains(start - 1)) {
                int end = start;
                while (set.contains(end + 1)) {
                    end += 1;
                }
                res = Math.max(res, end - start + 1);
            }
        }
        return res;
    }
}
