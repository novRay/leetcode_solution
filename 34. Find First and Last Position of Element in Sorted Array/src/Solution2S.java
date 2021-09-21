public class Solution2S {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int left = findRightBorder(nums, target - 1);   // The right border of largest int smaller than target
        int right = findRightBorder(nums, target);  // The right border of target
        if (left == right) {    // target is not found
            return new int[] {-1, -1};
        }
        return new int[] {left, right - 1};

    }
    private int findRightBorder(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
    public static void main(String[] args) {
        Solution2S s = new Solution2S();
        int[] nums = new int[] {5,7,7,8,8,10};
        int[] res = s.searchRange(nums, 7);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
