import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int myAtoi(String s) {
        int len = s.length();
        Automation dfa = new Automation();
        for (int i = 0; i < len; i++) {
            dfa.manage(s.charAt(i));
        }
        return (int) (dfa.sign * dfa.ans);
    }

    static class Automation {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void manage(char c) {
            state = table.get(state)[get(c)];
            if (state.equals("in_number")) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if (state.equals("signed")) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }

    public static void main(String[] args) {
        int a = myAtoi("   -42");
        System.out.println(a);
    }
}
