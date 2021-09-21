import java.util.Arrays;

// Greedy + Binary Search (Patience Sort)
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int res = 0;
        for (int num : nums) {
            int lo = 0;
            int hi = res;
            if (res == 0 || num > tails[res - 1]) {
                tails[res] = num;
                res ++;
            } else {
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (tails[mid] < num) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                tails[lo] = num;
            }
        }
        return res;
    }
}
