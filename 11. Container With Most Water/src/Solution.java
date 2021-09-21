public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n < 2) {
            return 0;
        }
        int left = 0;
        int right = n - 1;
        int ans = 0;
        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, temp);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
