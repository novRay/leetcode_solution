public class Solution2 {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == 0) {
            return 0;
        }
        int pprev = 0;
        int prev = 1;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr = 0;
            if (s.charAt(i) != '0') {
                curr = prev;
            }
            if (i > 0 && s.charAt(i - 1) != '0' && (10 * (s.charAt(i - 1) - '0') + (s.charAt(i) - '0') <= 26)) {
                curr += pprev;
            }
            pprev = prev;
            prev = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        String str = "10";
        System.out.println(s2.numDecodings(str));
    }
}
