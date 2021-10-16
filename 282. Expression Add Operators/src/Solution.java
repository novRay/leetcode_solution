import java.util.*;

public class Solution {
    List<String> ans = new ArrayList<>();
    long t;
    String s;
    int n;
    public List<String> addOperators(String num, int target) {
        t = target;
        s = num;
        n = num.length();
        dfs(0, 0, "", 0);
        return ans;
    }

    private void dfs(long prev, long cur, String exp, int depth) {
        if (depth == n) {
            if (cur == t) ans.add(exp);
            return;
        }
        for (int i = depth; i < n; i++) {
            if (i != depth && s.charAt(depth) == '0') break;    //skip leading zero
            long next = Long.parseLong(s.substring(depth, i + 1));
            if (depth == 0) {
                dfs(next, next, "" + next, i + 1);
            } else {
                dfs(next, cur + next, exp + "+" + next, i + 1);
                dfs(-next, cur - next, exp + "-" + next, i + 1);
                dfs(prev * next, cur - prev + prev * next, exp + "*" + next, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.addOperators("105", 5);
    }
}