class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return say(countAndSay(n - 1));
    }

    private String say(String last) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < last.length()) {
            char digit = last.charAt(i);
            int k = i + 1;
            while (k < last.length() && last.charAt(k) == digit) {
                k++;
            }
            sb.append((char)(k - i + '0')).append(digit);
            i = k;
        }
        return sb.toString();
    }
}