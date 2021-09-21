public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (n == 0 || nums[lo] != target) {
            return new int[]  {-1, -1};
        }
        int left = lo;
        hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2 + 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        int right = hi;
        return new int[] {left, right};
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = new int[] {};
        int[] res = s.searchRange(nums, 7);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
