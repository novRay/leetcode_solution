import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        String s = "";
        dfs(n, 0, 0, s, res);
        return res;
    }

    /**
     * Depth first search tree,
     * add left node '(' when its number is less than n,
     * add right node ')' when its number is less than left number and n.
     * e.g. for n = 2
     *              ""
     *            /
     *          "("
     *      /         \
     *    "(("       "()"
     *      \        /
     *     "(()"   "()("
     *        \        \
     *       "(())"   "()()"
     * @param n Parenthesis pair number
     * @param lc '(' number
     * @param rc ')' number
     * @param s One combination of well-formed parentheses
     * @param res The result
     */
    private void dfs(int n, int lc, int rc, String s, List<String> res) {
        if (lc == n && rc == n) {
            res.add(s);
            return;
        }
        if (lc < n) {
            dfs(n, lc + 1, rc, s + '(', res);
        }
        if (rc < n && rc < lc) {
            dfs(n, lc, rc + 1, s + ')', res);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res = s.generateParenthesis(3);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
