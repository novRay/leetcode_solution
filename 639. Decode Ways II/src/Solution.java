
public class Solution {
    static final int MOD = 1000000007;
    public int numDecodings(String s) {
        int n = s.length();
        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; i++) {
            c = b * checkSingle(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * checkCombined(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }
    private int checkSingle(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }
    private int checkCombined(char prev, char curr) {
        if (prev == '*' && curr == '*') {
            return 15; // [11, 19]U[21, 26]
        }
        if (prev == '*') {
            return curr <= '6' ? 2 : 1;
        }
        if (curr == '*') {
            if (prev == '1') {
                return 9;
            }
            if (prev == '2') {
                return 6;
            }
            return 0;
        }
        if (prev != '0') {
            return (10 * (prev - '0') + (curr - '0')) <= 26 ? 1 : 0;
        }
        return 0;
    }
}
