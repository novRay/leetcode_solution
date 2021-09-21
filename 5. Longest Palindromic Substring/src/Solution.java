/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Example 3:
 * Input: s = "a"
 * Output: "a"
 *
 * Example 4:
 * Input: s = "ac"
 * Output: "a"
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

public class Solution {
    // Dynamic programming
    //           / true, if substring S_i...S_j is a palindrome
    // P(i, j) = |
    //           \ false, otherwise.
    // P(i, j) = ( P(i+1, j−1) and S_i == S_j )
    // The base cases are:
    // 1. P(i, i) = true
    // 2. P(i, i + 1) = (S_i == S_i+1)
    //
    // Complexity:
    // Time: O(n^2)
    // Space: O(n^2)
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // dp[i][j] represents if s[i:j] is palindromic
        boolean[][] dp = new boolean[len][len];
        // mark all string with length 1 as true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLength = 1;
        int start = 0;
        // enumerate substring length
        for (int L = 2; L <= len; L++) {
            for (int left = 0; left < len; left++) {
                int right = left + L - 1;
                // when right index out of bound, end the loop
                if (right >= len) {
                    break;
                }

                if (s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                } else {
                    // s_i == s_j and substring length is shorter than 3
                    // e.g: aba
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
                // update max length
                if (dp[left][right] && right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    start = left;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String t = longestPalindrome("babad");
        System.out.println(t);
    }
}
