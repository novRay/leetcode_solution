// Binary Search twice, first for minIndex, second for target
public class Solution4 {
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

        int minIndex = lo;
        if (minIndex == 0) {
            lo = 0;
            hi = n - 1;
        } else if (target >= nums[0]) {
            hi = minIndex - 1;
            lo = 0;
        } else {
            lo = minIndex;
            hi = n - 1;
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int[] nums = new int[] {1, 3};
        int[] nums2 = new int[] {3, 1};
        int[] nums3 = new int[] {4, 5, 6, 7, 0, 1, 2};
        System.out.println(s.search(nums, 3));
        System.out.println(s.search(nums2, 3));
        System.out.println(s.search(nums3, 0));
    }
}
