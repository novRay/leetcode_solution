public class Solution2 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int begin = lo;
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int realMid = (begin + mid) % n;
            if (nums[realMid] == target) {
                return realMid;
            }
            if (nums[realMid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = new int[] {6, 7, 0, 1, 2, 4, 5};
        s.search(nums, 2);
    }
}
