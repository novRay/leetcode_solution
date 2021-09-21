public class Solution2 {
    public static int myAtoi(String s) {
        long ans = 0;
        int sign = 1;
        int i = 0;
        while (s.charAt(i) == ' ' && i < s.length() - 1) {
            i++;
        }
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            ans = ans * 10 + s.charAt(i) - '0';
            ans = sign == 1 ? Math.min(ans, (long)Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
            i++;
        }
        return (int) ans * sign;
    }

    public static void main(String[] args) {
        int a = myAtoi(" ");
    }
}
