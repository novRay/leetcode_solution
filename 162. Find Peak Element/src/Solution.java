// Binary Search
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        // Divide and conquer
        // the peak must be where "uphill" part
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {    // if 'mid' is at a downhill, drop right part and look at left part
                right = mid;
            } else {    // if 'mid' is at an uphill, drop left part and look at right part
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[] {1, 2, 1, 3, 5, 6, 4};
        int peak = s.findPeakElement(a);
        System.out.println(peak);
    }
}
