import java.util.*;

public class Solution {
    static final int L = 10;
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i + L - 1 < s.length(); i++) {
            String sub = s.substring(i, i + L);
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            if (cnt.get(sub) == 2) {
                res.add(sub);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findRepeatedDnaSequences("AAAAAAAAAAA");
    }
}
