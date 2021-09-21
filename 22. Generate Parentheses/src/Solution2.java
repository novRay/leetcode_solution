import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Dynamic Programming
public class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(List.of(""));
        dp.add(List.of("()"));
        if (n == 0) {
            return dp.get(0);
        }
        if (n == 1) {
            return dp.get(1);
        }
        for (int i = 2; i <= n; i++) {
            List<String> curr = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> inCmb = dp.get(j);
                List<String> outCmb = dp.get(i - 1 - j);
                for (String p : inCmb) {
                    for (String q : outCmb) {
                        curr.add("(" + p + ")" + q);
                    }
                }
            }
            dp.add(curr);
        }
        return dp.get(n);
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        List<String> res = s.generateParenthesis(3);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
