public class Solution2 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int maxLen = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                int preLen = dp[i - 1];
                int pre = i - 1 - preLen;
                if (pre >= 0 && s.charAt(pre) == '(') {
                    dp[i] = preLen + 2;
                    if (pre - 1 >= 0) {
                        dp[i] += dp[pre - 1];
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution2 sl = new Solution2();
        String s = "()()))))()()(";
        System.out.println(sl.longestValidParentheses(s));
    }
}
