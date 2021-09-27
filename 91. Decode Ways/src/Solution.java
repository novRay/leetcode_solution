public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        s = " " + s;
        for (int i = 1; i <= n; i++) {
            int curr = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';
            if (curr != 0) {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && prev != 0 && 10 * prev + curr <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "2101";
        System.out.println(s.numDecodings(str));
    }
}
