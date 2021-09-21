public class Solution3 {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        // scan left to right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                maxLen = Math.max(maxLen, right * 2);
            }
            if (right > left) { // there is no possible match on the left
                left = right = 0;
            }
        }
        left = right = 0;
        // scan right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                maxLen = Math.max(maxLen, left * 2);
            }
            if (left > right) { // there is no possible match on the right
                left = right = 0;
            }
        }
        return maxLen;
    }
}
