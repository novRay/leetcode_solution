public class Solution2 {
    // Center expanding method
    //  Time: O(n^2)
    //  Space: O(1)
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLength = 1;
        int start = 0;
        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroundCenter(s, i, i);             //e.g. aba
            int evenLen = expandAroundCenter(s, i, i + 1);  //e.g. abba
            int currMaxLen = Math.max(oddLen, evenLen);
            if (currMaxLen > maxLength) {
                 maxLength= currMaxLen;
                 start = i - maxLength  / 2;
            }
        }
        return s.substring(start, start + maxLength);
    }

    /**
     *  Expand from the center to left and right, end the loop when left and right point to
     *  different characters
     * @param s The input string
     * @param left The left starting bound
     * @param right The right starting bound, equal to left when the palindrome length is odd
     * @return The length of palindrome
     */
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right <s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            } else {
                left--;
                right++;
            }
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = longestPalindrome("babad");
        System.out.println(s);
    }
}
