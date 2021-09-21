public class Solution {
    public int findNumberOfLIS(int[] nums)  {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        dp[0] = 1;
        cnt[0] = 1;
        int maxLen = 1;
        int total = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                }
                if (dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                } else if (dp[j] + 1 == dp[i]) {
                    cnt[i] += cnt[j];
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                total = cnt[i];
            } else if (dp[i] == maxLen) {
                total += cnt[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {2,2,2,2,2};
        System.out.println(s.findNumberOfLIS(nums));
    }
}

