public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {  // [left, mid] is ordered, (mid, right] is unordered
                if (target < nums[mid] && target >= nums[left]) { // narrow range to 'ordered'
                    right = mid - 1;
                } else {    // narrow range to 'unordered'
                    left = mid + 1;
                }
            } else { // (mid, right] is ordered, [left, mid] is unordered
                if (target > nums[mid] && target <= nums[right]) { // narrow range to 'ordered'
                    left = mid + 1;
                } else { // narrow range to 'unordered'
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1};
        int t = 0;
        Solution s = new Solution();
        System.out.println(s.search(nums, t));
    }
}
