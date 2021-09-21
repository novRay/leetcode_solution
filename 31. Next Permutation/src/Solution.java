public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int revLen = 1; // length of reverse order sequence
        while (revLen < n && nums[n - revLen] <= nums[n - revLen - 1]) {
            revLen++;
        }
        int i = n - revLen - 1;
        if (revLen < n) {
            int j = n - 1;
            while (nums[i] >= nums[j]) {
                j --;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int from, int to) {
        int left = from;
        int right = to;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[] {3, 2, 1};
        s.nextPermutation(a);
    }
}
