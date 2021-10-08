import java.util.*;

public class Solution2 {
    static final int L = 10;
    int N = (int)1e5+10, P = 131;
    int[] h = new int[N], p = new int[N];
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 1; i + L - 1 <= n; i++) {
            int hash = h[i + L - 1] - h[i - 1] * p[L];
            cnt.put(hash, cnt.getOrDefault(hash, 0) + 1);
            if (cnt.get(hash) == 2) {
                res.add(s.substring(i - 1, i + L - 1));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.findRepeatedDnaSequences("AAAAAAAAAAA");
    }
}
