// Binary search for one target, then spread to both sides until found different number
// But this approach, in worst-case when numbers in num[] are all the same, has O(n) runtime.
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                int start = mid, end = mid;
                while (start >= 0 && nums[start] == target) {
                    start--;
                }
                while (end < n && nums[end] == target) {
                    end++;
                }
                return new int[] {start + 1, end - 1};
            }
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {};
        int[] res = s.searchRange(nums, 1);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
