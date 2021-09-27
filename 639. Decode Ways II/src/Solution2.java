public class Solution2 {
    static final int MOD = 1000000007;
    public int numDecodings(String s) {
        int n = s.length();
        long a = 0, b = 1, c = 0;
        for (int i = 0; i < n; i++) {
            c = 0;
            char curr = s.charAt(i);
            int currNum = curr - '0';
            for (int item = 1; item <= 26; item++) {
                if (item < 10) {
                    if (curr == '*' || currNum == item) {
                        c = (c + b) % MOD;
                    }
                } else {
                    if (i > 0) {
                        char prev = s.charAt(i - 1);
                        int prevNum = prev - '0';
                        int tens = item / 10, ones = item % 10;
                        if ((prev == '*' || prevNum == tens) && ((curr == '*' && ones != 0) || currNum == ones)) {
                            c = (c + a) % MOD;
                        }
                    }
                }
            }
            a = b;
            b = c;
        }
        return (int)c;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String str = "1*";
        s.numDecodings(str);
    }
}
